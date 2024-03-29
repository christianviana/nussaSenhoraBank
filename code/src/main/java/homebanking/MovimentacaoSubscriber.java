package homebanking;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MovimentacaoSubscriber implements Subscriber<Movimentacao> {

	private Subscription subscription;

	private int counter = 0;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("Inscrito!");
		this.subscription = subscription;
		this.subscription.request(1);
		System.out.println("onSubscribe requisitou 1 item");
	}

	@Override
	public void onNext(Movimentacao movimentacao) {
		System.out.println("Nova movimentacao recebida!");
		// System.out.println(String.format("T�tulo: %s, Palavras Chave: %s",
		// postagem.getTitulo(), postagem.getPalavrasChave()));
		counter++;
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable e) {
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Finalizando inscri��o!");
	}

	public int getCounter() {
		return counter;
	}

}
