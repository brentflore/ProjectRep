package testen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import testen.*;
import domein.domein.Planning;
import domein.domein.PlanningController;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jelle
 */
public class PlanningAanmakenTest {
    PlanningController pc;
    Planning planning;
    
    
    @Before
    public void setUp() {
        pc = new PlanningController();
        planning = new Planning();
        
        pc.setPlanning(planning);
        pc.maakPlanningZichtbaar(3);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void planningIsNotNullNaIndienenTest(){
        pc.dienPlanningIn(planning);
        Assert.assertNotNull(pc.getPlanning());
    }
    
    /* VOOR LATER!
    @Test
    public void planningIsValideTest(){
        Assert.assertNotNull(planning.verifieer());
    }
    */
    
    @Test
    public void planningIsZichtbaarNaZichtbaarMakenTest(){
        Assert.assertTrue(planning.isZichtbaar());
    }
    
    @Test
    public void planningIsOnzichtbaarNaOnzichtbaarMakenTest(){
        planning.toggleZichtbaarheid(false, 0);
        Assert.assertFalse(planning.isZichtbaar());
    }
    
    @Test
    public void planningHeeftZichtbaarHeidsPeriodeTest(){
        Assert.assertNotNull(planning.geefZichtbaarheidsPeriodeString());
        Assert.assertTrue(planning.geefZichtbaarheidsPeriodeInMillis() != 0);
    }
    
    @Test
    public void planningIsGerigistreerdTest(){
        Assert.assertNotNull(pc.getPlanning());
    }
    
    @Test
    public void stakeholdersZijnGenotifieerd(){
        // nog te maken /
    }

    
}
