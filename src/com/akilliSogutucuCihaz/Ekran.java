package com.akilliSogutucuCihaz;

public class Ekran implements IEkran {

    @Override
    public void acilisMesajı() {
        System.out.println("Soğutucu Sistem Arayüzü\n");
    }

    @Override
    public Kullanici kullaniciGirisEkrani(ITusTakimi tusTakimi) {
        System.out.println("Kullanıcı adı: ");
        String kullaniciAdi = tusTakimi.stringVeriAl();

        System.out.println("Şifre: ");
        String sifre = tusTakimi.stringVeriAl();

        return new Kullanici.Builder(kullaniciAdi, sifre).build();
    }

    @Override
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi) {
        this.mesajYaz("");
        if (dogrulandiMi) this.mesajYaz("Hoş geldiniz.");
        else this.mesajYaz("Kullanici doğrulanmadı.");
        this.mesajYaz("");
    }

    @Override
    public void kullaniciCıkısEkrani() {
        this.mesajYaz("\nÇıkış yapıldı.\n");
    }

    @Override
    public int kullaniciSecenekleri(ITusTakimi tusTakimi) {
        boolean secenekHataliMi = false;
        int secenek;

        do {
            this.mesajYaz("Seçim:");
            this.mesajYaz("1) Sıcaklığı görüntüle");
            this.mesajYaz("2) Soğutucuyu aç");
            this.mesajYaz("3) Soğutucuyu kapat");
            this.mesajYaz("0) Çıkış");

            secenek = tusTakimi.intVeriAl();

            if (secenek < 0 || secenek > 3) {
                this.mesajYaz("\nYanlış giriş.");
                this.mesajYaz("Doğru seçenek giriniz:");
                secenekHataliMi = true;
            }
        } while (secenekHataliMi);

        return secenek;
    }

    @Override
    public void mesajYaz(String mesaj) {
        System.out.println(mesaj);
    }

    @Override
    public void sicaklikGoruntule(IAgArayuzu agArayuzu) {
        int sicaklik = agArayuzu.sicaklikOku();
        this.mesajYaz("\nSıcaklık Değeri: " + sicaklik +  " C \n");
    }

    @Override
    public void sogutucuAc(IAgArayuzu agArayuzu) {
        agArayuzu.sogutucuAc();
        this.mesajYaz("\nSoğutucu açıldı\n");
    }

    @Override
    public void sogutucuKapat(IAgArayuzu agArayuzu) {
        agArayuzu.sogutucuKapat();
        this.mesajYaz("\nSoğutucu kapatıldı\n");
    }
}
