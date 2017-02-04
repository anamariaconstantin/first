/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

/**
 *
 * @author ana-maria.constantin
 */
public class CnpValidator {

    private static int[] getArray(String cnp) {
        int[] cnpArray = new int[13];

        for (int i = 0; i < cnp.length(); i++) {
            cnpArray[i] = Integer.parseInt(String.valueOf(cnp.charAt(i)));
        }

        return cnpArray;
    }

    public static boolean is_valid(String cnp) {
        if (cnp.length() == 13) {
            int[] cnpArray = getArray(cnp);

            long sum = cnpArray[0] * 2 + cnpArray[1] * 7 + cnpArray[2] * 9 + cnpArray[3] * 1 + cnpArray[4] * 4 + cnpArray[5] * 6
                    + cnpArray[6] * 3 + cnpArray[7] * 5 + cnpArray[8] * 8 + cnpArray[9] * 2 + cnpArray[10] * 7 + cnpArray[11] * 9;

            long rest = sum % 11;

            if (((rest < 10) && (rest == cnpArray[12])) || ((rest == 10) && (cnpArray[12] == 1))) {
                return true;
            }
        }

        return false;
    }

}
