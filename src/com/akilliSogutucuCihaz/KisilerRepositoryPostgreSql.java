package com.akilliSogutucuCihaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KisilerRepositoryPostgreSql implements IKisilerRepository{

    private Connection baglan() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliSogutucu",
                    "postgres", "123123");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public boolean kullaniciDogrula(Kullanici kullanici) {
        System.out.println("Kullanıcı doğrulanıyor...");
        boolean sonuc = false;

        String sql = "SELECT * FROM \"Kullanicilar\" WHERE isim = \'" + kullanici.getIsim() +
                "\' AND sifre = \'" + kullanici.getSifre() + "\'" ;

        Connection conn = this.baglan();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            //***** Bağlantı sonlandırma *****
            conn.close();

            sonuc = rs.next();

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sonuc;
    }
}