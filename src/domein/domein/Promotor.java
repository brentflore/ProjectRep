package domein.domein;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
@Entity
@NamedQueries({@NamedQuery(name="Prom.findAll", query = "SELECT d FROM Promotor d ")})
public class Promotor extends Gebruiker
{
        @OneToMany(mappedBy="promotor")
	private List<Student> studenten;
        
        private int maxStudenten;

        public Promotor()//default constructor voor JPA
        {}
        
                
        /**
         * @author Jelle
         * @param index
         * @return de student op de gevraagde index
         */
	public Student geefStudent(int index){
		try{
                    return studenten.get(index);
                }catch(IndexOutOfBoundsException e){
                    throw new IllegalArgumentException("er is geen student met deze index");
                }
	}
        
        
        /**
         * @author Jelle
         * @param student 
         * zoekt een student in de lijst met studenten, en verwijdert deze
         */
        public void verwijderStudent(Student student){
            studenten.remove(student);
        }
        
        
        
        public Promotor(String personeelsNummer, String naam, String voornaam, int maxStudenten)
        {
            super(personeelsNummer,naam, voornaam);
            this.maxStudenten = maxStudenten;
            studenten = new ArrayList<>();
        }
        
        
	public int geefAantalStudenten()
	{
		return studenten.size();
	}
	

        public int getMaxStudenten() {
            return maxStudenten;
        }

        public void addStudent(Student student) {
            this.studenten.add(student);
        }
        
    // get & set
        
    public List<Student> getStudenten() {
        return studenten;
    }
    
    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }
    
    public String getPersoneelsNummer() {
        return super.getIdNummer();
    }

    public void setPersoneelsNummer(String personeelsNummer) {
        super.setIdNummer(personeelsNummer);
    }

    public String getNaam() {
        return super.getNaam();
    }

    public void setNaam(String naam) {
        super.setNaam(naam);
    }
        
    public String getVoornaam() {
        return super.getVoornaam();
    }

    public void setVoornaam(String voornaam) {
        super.setVoornaam(voornaam);
    }  
}

