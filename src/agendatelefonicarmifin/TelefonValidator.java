/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ana-maria.constantin
 */
public class TelefonValidator {

    @SuppressWarnings("empty-statement")
    public static boolean is_patern(String tlfArray) {
        //String paternString = "\\+\\d{10}";
        String paternString = "^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$";
        //ex format bun (111)123-4567 or 111-123-4567  1111234567 

        Pattern patern = Pattern.compile(paternString);

        Matcher matcher = patern.matcher(tlfArray);

        boolean result = matcher.matches();

        //System.out.println( result);
        return result;

    }

    private static int[] getArray(String telefon) {
        int[] tlfArray = new int[10];

        for (int i = 0; i < telefon.length(); i++) {
            tlfArray[i] = Integer.parseInt(String.valueOf(telefon.charAt(i)));
        }

        return tlfArray;
    }

}
