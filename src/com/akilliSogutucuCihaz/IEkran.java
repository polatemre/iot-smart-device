package com.akilliSogutucuCihaz;

public interface IEkran {
    public void acilisMesajı();
    public Kullanici kullaniciGirisEkrani(ITusTakimi tusTakimi);
    public void kullaniciDogrulanmaMesaji(boolean dogrulandiMi);
    public void kullaniciCıkısEkrani();
    public int kullaniciSecenekleri(ITusTakimi tusTakimi);
    public void mesajYaz(String mesaj);
    public void sicaklikGoruntule(IAgArayuzu agArayuzu);
    public void sogutucuAc(IAgArayuzu agArayuzu);
    public void sogutucuKapat(IAgArayuzu agArayuzu);
}
