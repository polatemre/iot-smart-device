package com.akilliSogutucuCihaz;

import java.util.Scanner;

public class TusTakimi implements ITusTakimi{

    @Override
    public String stringVeriAl() {
        Scanner giris = new Scanner(System.in);
        return giris.nextLine();
    }

    @Override
    public int intVeriAl() {
        Scanner giris = new Scanner(System.in);

        int sayi = 0;
        boolean girisHataliMi;

        do {
            if (giris.hasNextInt()){
                sayi = giris.nextInt();
                girisHataliMi = false;
            }
            else {
                System.out.println("\nHatalı giriş");
                System.out.println("0-3 arası rakam giriniz.:");
                giris.next();
                girisHataliMi = true;
            }
        } while (girisHataliMi);
        return sayi;
    }
}
