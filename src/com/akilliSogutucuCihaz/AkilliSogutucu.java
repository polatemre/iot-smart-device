package com.akilliSogutucuCihaz;

public class AkilliSogutucu {
    IEkran ekran;
    ITusTakimi tusTakimi;
    IAgArayuzu agArayuzu;
    ISicaklikAlgilayici sicaklikAlgilayici;
    IKisilerRepository KisilerRepository;
    ISicaklikRepository SicaklikRepository;

    AkilliSogutucu(){
        ekran = new Ekran();
        tusTakimi = new TusTakimi();
        agArayuzu = new AgArayuzu();
        KisilerRepository = new KisilerRepositoryPostgreSql();
        SicaklikRepository = new SicaklikRepositoryPostgreSql();
        sicaklikAlgilayici = new SicaklikAlgilayici();

        sicaklikAlgilayici.attach(SicaklikRepository);
    }

    public void basla(){
        ekran.acilisMesajı(); //mesaj gösterilir
        Kullanici user; //kullanıcı oluşturur

        Thread threadRun = new Thread(sicaklikAlgilayici);
        threadRun.start();

        boolean cikis = false;
        int opsiyon = 0;

        user = ekran.kullaniciGirisEkrani(tusTakimi);
        boolean kullaniciDogrulama = KisilerRepository.kullaniciDogrula(user);
        ekran.kullaniciDogrulanmaMesaji(kullaniciDogrulama);
        do {
            if (kullaniciDogrulama){
                opsiyon = ekran.kullaniciSecenekleri(tusTakimi);
                cikis = kullaniciIslemleri(opsiyon);
            }
            else {
                ekran.mesajYaz("Tekrar denemek ister misiniz?(e/h): ");
                boolean tekrarDenensinMi = tusTakimi.stringVeriAl().equalsIgnoreCase("E");
                if (tekrarDenensinMi){
                    user = ekran.kullaniciGirisEkrani(tusTakimi);
                    kullaniciDogrulama = KisilerRepository.kullaniciDogrula(user);
                }
                else
                    cikis = true;
            }
        }while (!cikis);

        ekran.kullaniciCıkısEkrani();
        threadRun.stop();
    }

    private boolean kullaniciIslemleri(int opsiyon){
        boolean cikis = false;

        switch (opsiyon){
            case 0:
                cikis = true;
                break;
            case 1:
                ekran.sicaklikGoruntule(agArayuzu);
                break;
            case 2:
                ekran.sogutucuAc(agArayuzu);
                break;
            case 3:
                ekran.sogutucuKapat(agArayuzu);
                break;
        }

        return cikis;
    }

}


