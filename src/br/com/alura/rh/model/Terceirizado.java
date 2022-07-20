package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado {
	
	//composition
	//Funcionario and Terceirizado use DadosPessoais as a composition instead of herança because Funcionario have some difference from Terceirizado
	//Que, embora a herança favoreça o reaproveitamento de código, ela pode trazer efeitos colaterais quando não utilizada da maneira correta;
	//Que o Princípio de Substituição de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema.
	private DadosPessoais dadosPessoais;
	private String empresa;

	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario, String empresa) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
		this.empresa = empresa;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return dadosPessoais.getNome();
	}

	public String getCpf() {
		return dadosPessoais.getCpf();
	}

	public Cargo getCargo() {
		return dadosPessoais.getCargo();
	}

	public BigDecimal getSalario() {
		return dadosPessoais.getSalario();
	}

}
