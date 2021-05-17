package com.akilliSogutucuCihaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    private List<IObserver> subscribers = new ArrayList<IObserver>();

    @Override
    public void run() {
        Random rand = new Random();
        int sicaklik;
        while (true) {
            try {
                sicaklik = rand.nextInt(10) - 8;
                this.notify(sicaklik);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void sicakilkOku() {
    }

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(int mesaj) {
        for (IObserver subscriber : subscribers){
            subscriber.update(mesaj);
        }
    }


}
