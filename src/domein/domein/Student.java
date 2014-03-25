package domein.domein;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Stud.findAll", query = "SELECT d FROM Student d ")})
public class Student extends Gebruiker {

    @ManyToOne
    private Promotor promotor;
    @OneToOne
    private Presentatie presentatie;

    public Student()//default constructor voor JPA 
    {
    }

    public Student(String studentenNummer, String naam, String voornaam) {
        super(studentenNummer, naam, voornaam);
        presentatie = new Presentatie(this, "", "");

    }

    public Student(String studentenNummer, String naam, String voornaam, String onderzoeksdomein, String titel) {
        super(studentenNummer, naam, voornaam);
        presentatie = new Presentatie(this, onderzoeksdomein, titel);

    }

    //set & get
    public void setPromotor(Promotor promotor) {
        this.promotor = promotor;
    }

    public Promotor getPromotor() {
        return promotor;
    }

    public String getStudentenNummer() {
        return super.getIdNummer();
    }

    public void setStudentenNummer(String studentenNummer) {
        super.setIdNummer(studentenNummer);
    }

    public String getVoornaam() {
        return super.getVoornaam();
    }

    public void setVoornaam(String voornaam) {
        super.setVoornaam(voornaam);
    }

    public String getNaam() {
        return super.getNaam();
    }

    public void setNaam(String naam) {
        super.setNaam(naam);
    }

    public Presentatie getPresentatie() {
        return presentatie;
    }
    
    @Override
    public String toString() {
        return super.toString().concat("Student{" + "promotor=" + promotor + '}');
    }

}
