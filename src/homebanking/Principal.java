package homebanking;

import java.math.BigDecimal;

public class Principal {

	public static void main(String[] args) {
		Conta c1 = new ContaCorrente(1, new BigDecimal(100), new BigDecimal(1000));
		Conta c2 = new ContaCorrente(2, new BigDecimal(200), new BigDecimal(2000));
		Conta c3 = new ContaCorrente(3, new BigDecimal(300), new BigDecimal(2000));

		Cliente cli1 = new Cliente("Alessando", "1111111");

		cli1.adicionarContaCorrente(c1);
		cli1.adicionarContaCorrente(c3);

		Cliente cli2 = new Cliente("Christian", "2222222");
		cli2.adicionarContaCorrente(c2);

		System.out.println("Alessandro:" + cli1.aplicacoesTotais());
		System.out.println("Christian:" + cli2.aplicacoesTotais());

		cli1.transferirFundos(c1, c2, new BigDecimal(51000));

		System.out.println("Alessandro:" + cli1.aplicacoesTotais());
		System.out.println("Christian:" + cli2.aplicacoesTotais());

//
//		c1.operar(Conta.CREDITAR, 1.5);
//		c1.operar(Conta.DEBITAR, 0.5);
//		c1.operar(Conta.DEBITAR_COM_TED, 25.4);
//		c1.operar(Conta.DEBITAR, 63d);
//
//		Conta c2 = new Conta(2, 1000.0);
//		Conta c3 = new Conta(3, 250.0);
//
//		Correntista cliente1 = new Correntista("Christian", "0903946");
//
//		cliente1.adicionarContaCorrente(c1);
//		cliente1.adicionarContaCorrente(c2);
//		cliente1.adicionarContaCorrente(c3);
//
//		System.out.println(c1.getSaldo());
//		cliente1.contasPositivas().forEach(c -> System.out.println(c.getId()));
	}
}
