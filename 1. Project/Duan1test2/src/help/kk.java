/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class kk {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            lst.add(i);
        }
        List<Integer> lstc = new ArrayList<>();
        for (Integer x : lst) {
            if (x%2==0) {
                lstc.add(x);
            }
        }
        for (Integer v : lstc) {
            System.out.println(v);
        }
    }
    
}
