package br.gov.cesarschool.poo.bonusvendas.negocio;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

/*
• long gerarCaixaDeBonus(Vendedor): deve gerar o número da caixa de bônus, que é o
cpf do vendedor concatenado com ano (4 dígitos), mês (dois dígitos) e dia (dois
dígitos) da data atual, e incluir em repositorioCaixaDeBonus uma caixa de bônus.
Retornar o número gerado, se a caixa de bônus for incluída no repositório, ou zero
caso contrário.
*/

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
	
	
}