/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein.domein;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.persistence.*;

/**
 *
 * @author Brent
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Presentatie.findAll", query = "SELECT d FROM Presentatie d ")})
public class Presentatie implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Student student;
    private String Onderzoeksdomein;
    @Temporal(TemporalType.TIMESTAMP)
    private GregorianCalendar tijdSlot;
    private String lokaal;
    private String campus;
    private String titel;

    public String getPromotor() {
        return student.getPromotor().getNaam() + " " + student.getPromotor().getVoornaam();
    }

    public String getStudent() {
        return student.getNaam() + " " + student.getVoornaam();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getOnderzoeksdomein() {
        return Onderzoeksdomein;
    }

    public void setOnderzoeksdomein(String Onderzoeksdomein) {
        this.Onderzoeksdomein = Onderzoeksdomein;
    }

    public String getTijdSlot() {
        return"placeholder date"/* DateFormat.getDateInstance(DateFormat.SHORT).format(tijdSlot.getTime())*/;
    }

    public void setTijdSlot(GregorianCalendar tijdSlot) {
        this.tijdSlot = tijdSlot;
    }

    public String getLokaal() {
        return lokaal;
    }

    public void setLokaal(String lokaal) {
        this.lokaal = lokaal;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getTitel() {
        return titel;
    }

    public Presentatie() {
    }

    public Presentatie(Student student, String Onderzoeksdomein, String titel) {
        this.student = student;
        this.Onderzoeksdomein = Onderzoeksdomein;
        this.titel = titel;
        tijdSlot = new GregorianCalendar();
        tijdSlot.setTimeInMillis(0x13880);
    }
    

    
    

}
