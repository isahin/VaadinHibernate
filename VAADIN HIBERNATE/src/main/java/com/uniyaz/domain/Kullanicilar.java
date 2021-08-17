package com.uniyaz.domain;

import javax.persistence.*;


@Entity
@Table(name = "KULLANICILAR")
public class Kullanicilar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KULLANICIADI", length = 20)
    private String kullaniciAdi;

    @Column(name = "SIFRE", length = 20)
    private String sifre;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
