package homebanking;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {

	private TipoDeAplicacao tipoDeAplicacao;

	public ContaInvestimento(Integer id, BigDecimal saldo, TipoDeAplicacao tipo) {
		super(id, saldo);
		this.tipoDeAplicacao = tipo;
	}

}
