/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Formartday {

    public static String formatdateDD(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    public static String formatdateYYYY(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date formatdateDD(String date) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date formatdateYYYY(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertdaytoyear(String date) {
        return formatdateYYYY(formatdateDD(date));
    }

    public static String convertyeartoday(String date) {
        return formatdateDD(formatdateYYYY(date));
    }


}
