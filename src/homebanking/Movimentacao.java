package homebanking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Movimentacao implements Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private TipoMovimentacao tipoMovimentacao;
	private BigDecimal valor;
	private LocalDateTime dataHora;

	@Transient
	private Conta conta;

	@Transient
	private List<Observer> observers = new ArrayList<>();

	public Movimentacao(TipoMovimentacao tipoMovimentacao, BigDecimal valor, Conta conta) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.valor = valor;
		this.dataHora = LocalDateTime.now();
		this.conta = conta;
		this.registerObserver(new COAFObserver());
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.postContent(this);
		}
	}
}
