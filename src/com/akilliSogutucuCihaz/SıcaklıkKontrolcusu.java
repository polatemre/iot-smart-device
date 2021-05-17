package com.akilliSogutucuCihaz;

import java.util.Random;

public class SıcaklıkKontrolcusu implements Runnable{
    private int sicaklik;
    @Override
    public void run() {
        Random rand = new Random();
        try {
            Thread.sleep(10000);
            int sicaklik = rand.nextInt(10)-8;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
