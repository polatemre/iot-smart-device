package com.akilliSogutucuCihaz;

public interface ISubject {
    public void attach(IObserver subscriber);
    public void detach(IObserver subscriber);
    public void notify(int mesaj);
}
