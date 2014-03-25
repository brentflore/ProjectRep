/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testen;

import domein.listModel.WachtwoordControle;
import domein.listModel.WachtwoordGenerator;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Kristine
 */
@RunWith(Parameterized.class)
public class WachtwoordControleTest 
{
    
    private String wachtwoord;
    private boolean expected;
    
    public WachtwoordControleTest(String wachtwoord, boolean expected)
    {
        this.wachtwoord = wachtwoord;
        this.expected = expected;
    }
    
    @Parameterized.Parameters
    @SuppressWarnings("empty-statement")
     public static Collection<Object[]> generateData()
     {
         Object [][] parameters = new Object[][] {{"Hallo123", true }, {"123Hallo", true}, {"Hallo!!!", true}, {"AbC!)+(&", true}, {"45bAlS!e",true}, {"§&gKsT",true},
                                                  {"123", false}, {"Hallo", false}, {"hallo", false}, {"HALLO", false}, {"Halo!", false}, {"Hi123", false}};
         return Arrays.asList(parameters);
     }
     
     @Test
     public void wachtwoordIsCorrect()
     {
         Assert.assertEquals(expected, WachtwoordControle.isCorrectWachtwoord(wachtwoord));
     }
     
     // Te lang, Te kort, Geen Hoofdletters, Geen Kleineletters, OneRequirement, TwoRequirements, ThreeRequirements, FourRequirements
}

