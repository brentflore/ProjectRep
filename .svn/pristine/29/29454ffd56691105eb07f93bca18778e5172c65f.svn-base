/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein.listModel;

/**
 *
 * @author Kristine
 */
public final class WachtwoordControle 
{
    private static final int MIN_LENGHE = 6;
    private static final int MAX_LENGTE = 20;
    private static final int MIN_VEREISTEN = 3;
    private static final String HOOFDLETTER = ".*[A-Z].*";
    private static final String LETTER = ".*[a-z].*";
    private static final String CIJFER = ".*\\d.*";
    private static final String SYMBOOL = ".*[^a-zA-Z\\d].*";
    
     public static boolean isCorrectWachtwoord(String wachtwoord) 
     {
        if (isCorrecteLengte(wachtwoord)) {
            int req = 0;
            if (containsHoofdletter(wachtwoord)) {
                req++;
            }
            if (containsLetter(wachtwoord)) {
                req++;
            }
            if (containsCijfer(wachtwoord)) {
                req++;
            }
            if (containsSymbool(wachtwoord)) {
                req++;
            }
            return req >= MIN_VEREISTEN;
        } else {
            return false;
        }
    }
     
    private static boolean isCorrecteLengte(String wachtwoord) {
        return wachtwoord.length() >= MIN_LENGHE && wachtwoord.length() <= MAX_LENGTE;
    }
    
    private static boolean containsHoofdletter(String wachtwoord) {
        return wachtwoord.matches(HOOFDLETTER);
    }
    
    private static boolean containsLetter(String wachtwoord) {
        return wachtwoord.matches(LETTER);
    }
    
    private static boolean containsCijfer(String wachtwoord) {
        return wachtwoord.matches(CIJFER);
    }
    
    private static boolean containsSymbool(String wachtwoord) {
        return wachtwoord.matches(SYMBOOL);
    }
    
}
