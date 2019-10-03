package homebanking;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.NumberFormat;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public enum COAF {
	INSTANCE;

	public void recebeNotificacao(Movimentacao movimentacao) throws InterruptedException, ExecutionException {
		HttpClient cliente = HttpClient.newHttpClient();
		String body = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}";
		HttpRequest request = HttpRequest.newBuilder(URI.create("https://reqres.in/api/users"))
				.POST(HttpRequest.BodyPublishers.ofString(body)).build();

		CompletableFuture<HttpResponse<String>> asyncResponse = cliente.sendAsync(request,
				HttpResponse.BodyHandlers.ofString());

		if (asyncResponse.get().statusCode() == 201) {
			System.out.println(
					"COAF : Houve uma operação de " + NumberFormat.getInstance().format(movimentacao.getValor())
							+ " na conta " + movimentacao.getConta().getId());
		}

	}
}
