package agendatelefonicarmifin;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ana-maria.constantin
 */
public class Abonat implements Serializable {

    public static final char SEX_M = 'M';
    public static final char SEX_F = 'F';

    private int id;
    private String nume, prenume;
    private String cnp;
    private char sex;
    // private int data_n, luna_n, anul_n;
    public NrMobil mobil;
    public NrFix fix;

    private Abonat() {
    }

    public Abonat(String nume, String prenume, String cnp, char sex) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.sex = sex;;

    }

    public Abonat(String nume, String prenume, String cnp, char sex, NrFix nrFix) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.sex = sex;;

    }

    public Abonat(String nume, String prenume, String cnp, char sex, NrFix nrFix, NrMobil nrMobil) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.sex = sex;
        this.fix = nrFix;
        this.mobil = nrMobil;

    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public char getSex() {
        return sex;
    }

    public NrFix getFix() {
        return fix;
    }

    public NrMobil getMobil() {
        return mobil;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setFix(NrFix fix) {
        this.fix = fix;
    }

    public void setMobil(NrMobil mobil) {
        this.mobil = mobil;
    }

    @Override
    public String toString() {
        return "Abonat{" + "id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", cnp=" + cnp + ", sex=" + sex + ", fix=" + fix + ", mobil=" + mobil + '}';
    }

}
