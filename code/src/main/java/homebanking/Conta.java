package homebanking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta implements OperacaoConta {

	@Id
	private Integer id;

	private BigDecimal saldo;
	public BigDecimal taxaTransferenciaTerceiros = new BigDecimal(4.50);

	@OneToMany
	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Conta(Integer id, BigDecimal saldo) {
		this.id = id;
		this.saldo = saldo;

	}

	public void operar(BinaryOperator<BigDecimal> operacao, BigDecimal valor, TipoMovimentacao tipoMovimentacao) {
		this.saldo = operacao.apply(this.saldo, valor);
		criaMovimentacao(tipoMovimentacao, valor);
	}

	private void criaMovimentacao(TipoMovimentacao tipoMovimentacao, BigDecimal valor) {
		Movimentacao novaMovimentacao = new Movimentacao(tipoMovimentacao, valor, this);
		movimentacoes.add(novaMovimentacao);
		novaMovimentacao.notifyObservers();

	}

	public void transferirFundos(Conta destino, BigDecimal valor, TipoMovimentacao tipoMovimentacao) {
		this.operar(DEBITAR, valor, tipoMovimentacao);
		destino.operar(CREDITAR, valor, tipoMovimentacao);
	}

	public Boolean saldoMaiorQueZero() {
		Predicate<BigDecimal> saldoPositivo = saldo -> saldo.compareTo(new BigDecimal(0)) > 0;

		return saldoPositivo.test(this.saldo);
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}