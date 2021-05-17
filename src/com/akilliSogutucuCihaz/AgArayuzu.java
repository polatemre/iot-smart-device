package com.akilliSogutucuCihaz;

public class AgArayuzu implements IAgArayuzu {
    ISicaklikRepository sicaklikRepo = new SicaklikRepositoryPostgreSql();

    IEyleyici eyleyici = new Eyleyici();
    IEyleyici eyleyici2 = new Eyleyici();

    @Override
    public int sicaklikOku() {
        return sicaklikRepo.sonSicaklikGetir();
    }

    @Override
    public void sogutucuAc() {
        eyleyici.sogutucuAc();
    }

    @Override
    public void sogutucuKapat() {
        eyleyici.sogutucuKapat();
    }
}
