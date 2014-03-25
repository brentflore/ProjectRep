package domein.domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persistance.Mapper;
import persistance.MapperFactory;
import persistance.SoortMapper;

public class Campus {

    private List<Student> studentenlijst;
    private Set<Student> geselecteerdeStudenten;
    private List<Promotor> promotorenlijst;
    private Mapper mapper;//tijdelijk tot juist structuur voor jpa gezien is

    public Campus() {
        vraagPromotorenOp();
        vraagStudentenOp();
        geselecteerdeStudenten = new HashSet<>(); // Geeft nog problemen met verwijderen van studenten (index is verschillend)
    }

    public Student geefStudent(int rij) {
        return (Student) studentenlijst.get(rij);
    }

    public Promotor geefPromotor(int rij) {
        return (Promotor) promotorenlijst.get(rij);
    }

    public List<Student> getGeselecteerdeStudenten() {
        return new ArrayList(geselecteerdeStudenten);
    }

    public void addGeselecteerdeStudent(Student geselecteerdeStudent) {
        if(geselecteerdeStudenten.contains(geselecteerdeStudent))
           throw new ArrayIndexOutOfBoundsException("Student is reeds geselecteerd");
        geselecteerdeStudenten.add(geselecteerdeStudent);
    }

    public void koppelStudentEnPromotor(Student student, Promotor promotor) {
        student.setPromotor(promotor);
        promotor.addStudent(student);
    }

    public boolean checkHeeftStudentEenPromotor(Student student) {
        if (student.getPromotor() != null)
            return true;
        return false;
    }

    public boolean heeftPromotorNogPlaatsVoorStudenten(Promotor promotor) {
        if (promotor.getMaxStudenten() > promotor.geefAantalStudenten())
            return true;
        return false;
    }

    public void ontkoppelStudentEnPromotor(Student student, Promotor promotor) {
        if(student == null)
            throw new ArrayIndexOutOfBoundsException("Er zijn geen studenten geselecteerd");
        System.out.println("Koppel promotor oke 2");
        student.setPromotor(null);
        promotor.verwijderStudent(student);
    }

    public void verwijderStudentUitLijst(Student student) {
        geselecteerdeStudenten.remove(student);
    }

    public void koppelPromotorEnGeselecteerdeStudenten(Promotor promotor) {
        if(geselecteerdeStudenten.isEmpty())
            throw new ArrayIndexOutOfBoundsException("Er zijn geen studenten geselecteerd");
        else{
            System.out.println("Koppel promotor oke 2");
        for (Student s : geselecteerdeStudenten) {
            if (heeftPromotorNogPlaatsVoorStudenten(promotor)) {
                koppelStudentEnPromotor(s, promotor);
            } else {
                throw new IllegalArgumentException("maximum aantal studenten van deze promotor is bereikt, "
                        + "selecteer een andere promotor");
            }
        }   }

    }

    public void maakGeselecteerdeStudentenLeeg() {
        geselecteerdeStudenten.clear();
    }

    private void vraagStudentenOp() {
        if (mapper == null || !mapper.getClass().equals(Student.class)) {
            mapper = MapperFactory.geefMapper(SoortMapper.STUDENT);
        }
        studentenlijst = (List<Student>) mapper.geefLijst();
    }

    private void vraagPromotorenOp() {
        if (mapper == null || !mapper.getClass().equals(Promotor.class)) {
            mapper = MapperFactory.geefMapper(SoortMapper.PROMOTOR);
        }
        promotorenlijst = (List<Promotor>) mapper.geefLijst();
    }

    public int geefAantalStudenten() {
        return studentenlijst.size();
    }

    public int geefAantalPromotoren() {
        return promotorenlijst.size();
    }

    public int geefAantalGeselecteerdeStudenten() {
        if (geselecteerdeStudenten == null) {
            return 0;
        }
        return geselecteerdeStudenten.size();
    }

    public Student geefGeselecteerdeStudent(int rij) {
        return studentenlijst.get(rij);
    }
}
