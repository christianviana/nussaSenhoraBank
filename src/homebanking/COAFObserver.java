package homebanking;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

public class COAFObserver implements Observer {

	@Override
	public void postContent(Movimentacao movimentacao) {
		if (movimentacao.getValor().compareTo(new BigDecimal(50000)) > 0) {
			try {
				COAF.INSTANCE.recebeNotificacao(movimentacao);
			} catch (InterruptedException e) {
				System.out.println("Serviço COAF fora do ar!!!!");
			} catch (ExecutionException e) {
				System.out.println("Serviço COAF fora do ar!!!!");
			}
		}
	}

}
