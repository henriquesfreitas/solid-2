package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;


//Single Responsability Principle
//Que classes/métodos/funções/módulos devem ter uma única responsabilidade bem definida;
//Que, segundo o Princípio de Responsabilidade Única (SRP), uma classe deve ter um e apenas um motivo para ser alterada;
//so in this case we create the ReajusteService who is responsible to ajust the salary instead of keeping this responsability in the
//Funcionario class
public class ReajusteService {
	
	private List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	//Que cada classe deve conhecer e ser responsável por suas próprias regras de negócio;
	//Que o princípio Aberto/Fechado (OCP) diz que um sistema deve ser aberto para a extensão, mas fechado para a modificação
	//Isso significa que devemos poder criar novas funcionalidades e estender o sistema sem precisar modificar muitas classes já existentes
	//Uma classe que tende a crescer "para sempre" é uma forte candidata a sofrer alguma espécie de refatoração.
	//in this case, we extracted the validations into classes, so each validation could be isolated, keeping simple to maintain 
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));

		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
