package homebanking;

import java.util.List;

public class Banco {

	private String nome;
	private String codigo;
	private List<Cliente> correntistas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Cliente> getCorrentistas() {
		return correntistas;
	}

	public void setCorrentistas(List<Cliente> correntistas) {
		this.correntistas = correntistas;
	}

}
