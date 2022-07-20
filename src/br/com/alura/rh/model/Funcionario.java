package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
	//TODO
	//composition
	//Funcionario and Terceirizado use DadosPessoais as a composition instead of herança because Funcionario have some difference from Terceirizado
	//Que, embora a herança favoreça o reaproveitamento de código, ela pode trazer efeitos colaterais quando não utilizada da maneira correta;
	//Que o Princípio de Substituição de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema.
	private DadosPessoais dadosPessoais;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.dadosPessoais.setSalario(novoSalario);
		this.dataUltimoReajuste = LocalDate.now();
	}

	public void promover(Cargo novoCargo) {
		this.dadosPessoais.setCargo(novoCargo);
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

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

}
