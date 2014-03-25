package testen;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import domein.domein.CampusController;
import domein.domein.Promotor;
import domein.domein.Student;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gebruiker
 */
public class PromotorToekennenTest {
    
   private CampusController cc;
   private Student geselecteerdeStudent;
   private Student geselecteerdeStudent2;
   private Promotor geselecteerdePromotor;
   private String studentnr1 = "1", studentnr2="2", promnr = "2";
   private int maxStudenten;
   
   
   
   
    @Before
    public void before() {
        cc = new CampusController();
        geselecteerdeStudent = new Student("Jan","Janssens",studentnr1);
        geselecteerdePromotor= new Promotor("Tom","Tomson",promnr,1);
        geselecteerdeStudent = new Student("Sam","Janssens",studentnr2);
    }
    
    @Test
    public void ToewijzenPromotorTest()  // wijst een promotor toe aan de student
    {
//        cc.setGeselecteerdeStudent(geselecteerdeStudent);
//        cc.setGeselecteerdePromotor(geselecteerdePromotor);
//        
//        assertEquals(geselecteerdePromotor, cc.geefPromotor(0));
//        assertEquals(geselecteerdeStudent, cc.geefStudent(0));
        
        cc.update(cc, geselecteerdeStudent);
        
        cc.koppelPromotorEnGeselecteerdeStudenten(geselecteerdePromotor);
    }   
  
  @Test
  public void controleerPromotorBijLeerling()
  {
      assertFalse(cc.checkHeeftStudentEenPromotor(geselecteerdeStudent));
  }
  
  @Test
  public void ontkoppelStudentPromotor()
  {
//      
      cc.ontkoppelStudentEnPromotor(geselecteerdeStudent, geselecteerdePromotor);
      assertFalse(cc.checkHeeftStudentEenPromotor(geselecteerdeStudent));
  }
  
//    @Test
//    public void controleerGeselecteerdeStudentNietLeeg()
//    {
//        cc.update(cc, geselecteerdeStudent2);
//        assertNotNull(cc.getGeslecteerdeStudent());
//    }
//  
//  @Test
//  public void controleerGeselecteerdePromotorNietLeeg()
//  {
//      assertNotNull(cc.geefGeselecteerdePromotor());
//  }
//  
  @Test(expected=IllegalArgumentException.class)
  public void controleerKanMaxStudentenNietOverschrijden()
  {
//      maxStudenten = cc.geefMaxStudentenPromotor();
//      cc.voegStudentToeNaMax(geselecteerdeStudent);
      cc.update(cc, geselecteerdeStudent);
      cc.koppelPromotorEnGeselecteerdeStudenten(geselecteerdePromotor);
      cc.update(cc, geselecteerdeStudent2);
      cc.koppelPromotorEnGeselecteerdeStudenten(geselecteerdePromotor);
  }
  
}
