package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;

public class VendedorMediator {
	private static VendedorMediator instance;
	private VendedorDAO repositorioVendedor;
	private AcumuloResgateMediator caixaDeBonusMediator;

	public VendedorMediator() {
		repositorioVendedor = new VendedorDAO();
		caixaDeBonusMediator = AcumuloResgateMediator.getInstance();
	}
	
	public static VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }
	
	public Vendedor buscar(String cpf) {
		Vendedor vendedor = repositorioVendedor.buscar(cpf);
		return vendedor;
	}
	
	private String validar(Vendedor vendedor) {
		if (StringUtil.ehNuloOuBranco(vendedor.getCpf())) {
			return "CPF nao informado";
		}
		
		if(!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
			return "CPF Invalido";
		}
		
		if(StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
			return "Nome completo nao informado";
		}
		
		if(vendedor.getSexo() == null) {
			return "Sexo nao informado";
		}
		
		if(vendedor.getDataNascimento() == null) {
			return "Data de nascimento invalida";
		}
		
		if (vendedor.calcularIdade() > 17) {
			return "Data de nascimento invalida";
		}
		
		if (vendedor.getRenda() < 0) {
			return "Renda menor que zero";
		}
		
		if (vendedor.getEndereco() == null) {
			return "Endereco nao informado";
		}
		
		if (StringUtil.ehNuloOuBranco(vendedor.getEndereco().getLogradouro())) {
			return "Logradouro nao informado";
		}
		
		if (vendedor.getEndereco().getLogradouro().length() < 4) {
			return "Logradouro tem menos de 04 caracteres";
		}
		
		if (vendedor.getEndereco().getNumero() < 0) {
			return "Numero menor que zero";
		}
		
		if (StringUtil.ehNuloOuBranco(vendedor.getEndereco().getCidade())) {
			return "Cidade nao informada";
		}
		
		if (StringUtil.ehNuloOuBranco(vendedor.getEndereco().getEstado())) {
			return "Estado nao informado";
		}
		
		if (StringUtil.ehNuloOuBranco(vendedor.getEndereco().getPais())) {
			return "Pais nao informado";
		}
		
		return null;
		
	}
	
	public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
		String validado = validar(vendedor);
		if (validado == null) {
			if(buscar(vendedor.getCpf()) != null) {
				ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, "Vendedor ja existente");
				return resultado;
			}else {
				long numeroCaixa = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
				if (numeroCaixa == 0) {
					ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(numeroCaixa, "Caixa de bonus nao foi gerada");
					return resultado;
				}else {
					repositorioVendedor.incluir(vendedor);
					ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(numeroCaixa, null);
					
					return resultado;
				}
			}
		}else {
			ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, validado);
			return resultado;
		}
	}
	
	public String alterar(Vendedor vendedor) {
		String validado = validar(vendedor);
		if(validado == null && buscar(vendedor.getCpf()) == null) {
			repositorioVendedor.alterar(vendedor);
			return null;
		}else {
			return "Vendedor inexistente";
		}
	}
	
}
