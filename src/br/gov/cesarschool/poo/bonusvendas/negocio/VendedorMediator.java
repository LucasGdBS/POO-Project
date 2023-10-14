package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;

public class VendedorMediator {
	private static VendedorMediator instance;
	VendedorDAO repositorioVendedor;
	AcumuloResgateMediator caixaDeBonusMediator;

	VendedorMediator() {
		repositorioVendedor = new VendedorDAO();
		caixaDeBonusMediator = AcumuloResgateMediator.getInstancia();
	}
	
	public static VendedorMediator getInstancia() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }
	
	public Vendedor buscar(String cpf) {
		return repositorioVendedor.buscar(cpf);
	}
	
	private String validar(Vendedor vendedor) {
		
		if (StringUtil.ehNuloOuBranco(vendedor.getCpf())) {
			return "CPF nao informado";
		}else if(ValidadorCPF.ehCpfValido(vendedor.getCpf()) == false) {
			return "CPF invalido";
		}
		
		if(StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
			return "Nome completo nao informado";
		}
		
		if(vendedor.getSexo() == null) {
			return "Sexo nao informado";
		}
		
		if(vendedor.getDataNascimento() == null) {
			return "Data de nascimento nao informada";
		}
		
		if (vendedor.calcularIdade() < 18) {
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
			boolean flagIncluido = repositorioVendedor.incluir(vendedor);
			if (flagIncluido == false) {
				ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, "Vendedor ja existente");
				return resultado;
			}
			long numCaixa = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
			if (numCaixa == 0) {
				ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(numCaixa, "Caixa de bonus nao foi gerada");
				return resultado;
			}
			// Caso de sucesso
			ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(numCaixa, null);
			return resultado;
		}else {
			ResultadoInclusaoVendedor resultado = new ResultadoInclusaoVendedor(0, validado);
			return resultado;
		}
	}
	
	public String alterar(Vendedor vendedor) {
		String validado = validar(vendedor);
		if(validado == null) {
			if ( buscar(vendedor.getCpf()) == null){
				return "Vendedor inexistente";
			}else {
				repositorioVendedor.alterar(vendedor);
				return null;
			}
		}else {
			return "Vendedor inexistente";
		}
    }
	
}
