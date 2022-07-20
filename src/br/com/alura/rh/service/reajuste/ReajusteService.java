package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;


//Single Responsability Principle
//Que classes/m�todos/fun��es/m�dulos devem ter uma �nica responsabilidade bem definida;
//Que, segundo o Princ�pio de Responsabilidade �nica (SRP), uma classe deve ter um e apenas um motivo para ser alterada;
//so in this case we create the ReajusteService who is responsible to ajust the salary instead of keeping this responsability in the
//Funcionario class
public class ReajusteService {
	
	private List<ValidacaoReajuste> validacoes;

	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	//Que cada classe deve conhecer e ser respons�vel por suas pr�prias regras de neg�cio;
	//Que o princ�pio Aberto/Fechado (OCP) diz que um sistema deve ser aberto para a extens�o, mas fechado para a modifica��o
	//Isso significa que devemos poder criar novas funcionalidades e estender o sistema sem precisar modificar muitas classes j� existentes
	//Uma classe que tende a crescer "para sempre" � uma forte candidata a sofrer alguma esp�cie de refatora��o.
	//in this case, we extracted the validations into classes, so each validation could be isolated, keeping simple to maintain 
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));

		BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
	
}
