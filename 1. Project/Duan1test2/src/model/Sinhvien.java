/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class Sinhvien {
    private String masv;
    private String tensv;
    private boolean checkfalse;
    private String malop;
    private int tilenghi;
    private String ngaythi;
    private String trangthai;
    private int cathi= 0;

    public String getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(String ngaythi) {
        this.ngaythi = ngaythi;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public int getCathi() {
        return cathi;
    }

    public void setCathi(int cathi) {
        this.cathi = cathi;
    }

    public Sinhvien() {
    }

    public int getTilenghi() {
        return tilenghi;
    }

    public void setTilenghi(int tilenghi) {
        this.tilenghi = tilenghi;
    }
    
    

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public boolean isCheckfalse() {
        return checkfalse;
    }

    public void setCheckfalse(boolean checkfalse) {
        this.checkfalse = checkfalse;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
}
