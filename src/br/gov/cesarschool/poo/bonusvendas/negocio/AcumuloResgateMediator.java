package br.gov.cesarschool.poo.bonusvendas.negocio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;

public class AcumuloResgateMediator {
	private static AcumuloResgateMediator instance;
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;
	
	private AcumuloResgateMediator() {
		CaixaDeBonusDAO repositorioCaixaDeBonus = new CaixaDeBonusDAO();
		LancamentoBonusDAO repositorioLancamento = new LancamentoBonusDAO();
	}
	
	public static AcumuloResgateMediator getInstance() {
		if (instance == null) {
			instance = new AcumuloResgateMediator();
		}
		return instance;
	}
	
	public long gerarCaixaDeBonus(Vendedor vendedor)
	{
		String cpf = vendedor.getCpf();
		cpf =cpf.substring(0, cpf.length() - 2);
		LocalDate dataHoje = LocalDate.now();
		
		String dataFormat = dataHoje.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		Long numeroCaixaLong = Long.parseLong(cpf + dataFormat);
		
		CaixaDeBonus caixaDeBonus = new CaixaDeBonus(numeroCaixaLong);
		
		if(repositorioCaixaDeBonus.incluir(caixaDeBonus))
		{
			return numeroCaixaLong;
		}
		else
		{
			return 0;
		}
	}
	
	public String acumularBonus(long numeroCaixaDeBonus, double valor)
	{
		if(valor <= 0)
		{
			return "Valor precisa ser maior que 0";
		}
		
		CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
		
		caixaDeBonus.creditar(valor);
		
		boolean flag = repositorioCaixaDeBonus.alterar(caixaDeBonus);
		
		if(!flag)
		{
			return "Erro em alterar a Caixa Bonus";
		}
		
		LancamentoBonusCredito lancamentoBonusCredito = new LancamentoBonusCredito(numeroCaixaDeBonus, valor, java.time.LocalDateTime.now());
		lancamentoBonusCredito.setNumeroCaixaDeBonus(numeroCaixaDeBonus);
		lancamentoBonusCredito.setValor(valor);
		
		boolean flag2 = repositorioLancamento.incluir(lancamentoBonusCredito);
		
		if(!flag2)
		{
			return "Erro em alterar caixa bonus";
		}
		
		return null;
	}
	
	public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo)
	{
		if(valor <= 0)
		{
            return "Valor menor que 0!";
        }

        CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);

        if (caixaDeBonus == null)
        {
            return "Caixa de bonus não existe!";
        }

        if(caixaDeBonus.getSaldo() < valor)
        {
            return "Saldo insuficiente.";
        }
        
        caixaDeBonus.debitar(valor);
        
        boolean flag = repositorioCaixaDeBonus.alterar(caixaDeBonus);
        
        if(!flag)
        {
            return "Erro ao alterar Caixa Bonus";
        }

        LancamentoBonusDebito lancamentoBonusResgate = new LancamentoBonusDebito(numeroCaixaDeBonus, valor, java.time.LocalDateTime.now(), tipo);
        lancamentoBonusResgate.setNumeroCaixaDeBonus(numeroCaixaDeBonus);
        lancamentoBonusResgate.getTipoResgate();

        boolean flag2 = repositorioLancamento.incluir(lancamentoBonusResgate);

        if(!flag2)
        {
            return "Erro ao incluir lançamento de bonus.";
        }

            return null;

    }
}