/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kou_ortalama_hesaplama;

/**
 *
 * @author ahmet
 */
public class Dersler {
    public String ders_adi,t_notu,harf_notu,Kredi;
    float dortlukPuan;

    public Dersler(String ders_adi, String t_notu, String harf_notu, float dortlukPuan, String Kredi) {
        this.ders_adi = ders_adi;
        this.t_notu = t_notu;
        this.harf_notu = harf_notu;
        this.dortlukPuan = dortlukPuan;
        this.Kredi = Kredi;
    }

    public String getDers_adi() {
        return ders_adi;
    }

    public void setDers_adi(String ders_adi) {
        this.ders_adi = ders_adi;
    }

    public String getT_notu() {
        return t_notu;
    }

    public void setT_notu(String t_notu) {
        this.t_notu = t_notu;
    }

    public String getHarf_notu() {
        return harf_notu;
    }

    public void setHarf_notu(String harf_notu) {
        this.harf_notu = harf_notu;
    }

    public float getDortlukPuan() {
        return dortlukPuan;
    }

    public void setDortlukPuan(float dortlukPuan) {
        this.dortlukPuan = dortlukPuan;
    }

    public String getKredi() {
        return Kredi;
    }

    public void setKredi(String Kredi) {
        this.Kredi = Kredi;
    }
    
    
}
