package homebanking;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id
	private String cpf;

	private String nome;
	private String sobreNome;
	private String endereco;
	private String telefone;

	@OneToMany
	private Set<Conta> contas = new HashSet<>();

	public Cliente() {
	}

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public void adicionarContaCorrente(Conta conta) {
		contas.add(conta);
	}

	public BigDecimal aplicacoesTotais() {
		return contas.stream().map(Conta::getSaldo).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private boolean isTitularConta(Conta conta) {
		return contas.contains(conta);
	}

	public void transferirFundos(Conta origem, Conta destino, BigDecimal valor) {
		if (!isTitularConta(origem)) {
			throw new InvalidParameterException("Não é o titular da conta de origem.");
		}

		if (isTitularConta(destino)) { // verifica se conta destino é do cliente
			origem.transferirFundos(destino, valor, TipoMovimentacao.TRANSFERENCIA_MESMO_TITULAR);
		} else {
			origem.transferirFundos(destino, valor, TipoMovimentacao.TRANSFERENCIA_TERCEIROS);
			origem.operar(OperacaoConta.DEBITAR, origem.taxaTransferenciaTerceiros,
					TipoMovimentacao.TAXA_TRANSFERENCIA_TERCEIROS);
		}
	}

	public List<Conta> contasPositivas() {
		return contas.stream().filter(Conta::saldoMaiorQueZero).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
