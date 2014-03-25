/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein.listModel;

import java.security.SecureRandom;

/**
 *
 * @author Kristine
 */
public class WachtwoordGenerator 
{
    private static int MIN_LENGTE = 6;
    private static int MAX_LENGTE = 20;
    
    private static SecureRandom SRG;
    
    private static SecureRandom getSRG() {
        if (SRG == null) {
            synchronized (WachtwoordGenerator.class) {
                if (SRG == null) {
                    SRG = new SecureRandom();
                }
            }
        }
        return SRG;
    }
    
    public static String genereerWachtwoord(int lengte) {
        String wachtwoord = "";
        // todo exception throwen bij error, bv als length te groot is
        // anders blijft hij in een eeuwige loop
        do {
            wachtwoord = maakWachtwoord(lengte);
        } while (!WachtwoordControle.isCorrectWachtwoord(wachtwoord));
        return wachtwoord;
    }
    
    private static String maakWachtwoord(int lengte) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengte; i++) 
        {
            int AsciiPos = (Math.abs(getSRG().nextInt()) % 93) + 33;
            char c = (char) AsciiPos;
            sb.append(c);
        }
        return sb.toString();
    }
    
    public static boolean controleerWachtwoord(String wachtwoord)
    {
        return true;
    }
}
