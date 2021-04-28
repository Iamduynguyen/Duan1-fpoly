/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Lop;
import model.Sinhvien;

/**
 *
 * @author dell
 */
public class SVChiacathi {

    static String[] ngaythi() {
        String[] a = new String[]{"a", "b", "c", "d", "e"};
        return a;
    }
    public static List<String> ngay(){
        List<String> x = new ArrayList<>();
        x.add("a"); x.add("b"); x.add("c"); x.add("d");x.add("e");
        return x;
    }

    public static List<Sinhvien> lstSVfinish(List<Sinhvien> _lstSV, List<String> ngaythi, int sosv, List<Integer> cathi) {
        for (int i = 0; 0 < _lstSV.size(); i++) {
            if (i<sosv) {
                _lstSV.get(i).setCathi(cathi.get(0));
                _lstSV.get(i).setNgaythi(ngaythi.get(0));
            }
        }
        return _lstSV;
    }

    public static List<Sinhvien> fake() {
        List<Sinhvien> a = new ArrayList<>();
        for (int i = 1; i < 41; i++) {
            Sinhvien x = new Sinhvien();
            x.setTensv("m" + i);
            a.add(x);
        }
        return a;
    }



    public static void main(String[] args) {

    }
    
    public static int countsv(List<Sinhvien> lst){
        int count = 0;
        for (Sinhvien sinhvien : lst) {
            if (sinhvien.isCheckfalse()) {
                count++;
            }
        }
        return count;
    }
}
