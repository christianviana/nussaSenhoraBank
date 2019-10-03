package homebanking;

public interface Subject {

	void registerObserver(Observer o);

	void notifyObservers();

}
