package GeneralPractice.ObserverPattern.Observables;

import java.util.Observer;

public interface Observable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
    void setData();
}
