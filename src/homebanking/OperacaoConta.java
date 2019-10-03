package homebanking;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public interface OperacaoConta {

	public static BinaryOperator<BigDecimal> CREDITAR = (saldo, valor) -> saldo.add(valor);
	public static BinaryOperator<BigDecimal> DEBITAR = (saldo, valor) -> saldo.subtract(valor);
	// public static BinaryOperator<Double> DEBITAR_COM_TED = (saldo, valor) ->
	// saldo - valor - Conta.VALOR_TED;
}
