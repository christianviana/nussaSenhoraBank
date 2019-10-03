package homebanking;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

	private BigDecimal limiteCredito;

	public ContaCorrente(Integer id, BigDecimal saldo, BigDecimal limiteCredito) {
		super(id, saldo);
		this.limiteCredito = limiteCredito;
	}

}
