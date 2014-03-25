package domein.domein;

import domein.tableModel.SoortTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.table.AbstractTableModel;


public class CampusController extends Controller 
{
        private Campus campus;
	private Student geselecteerdeStudent;
        private List<Student> geselecteerdeStudenten;
	
        private Promotor geselecteerdePromotor;
        
	public CampusController() {
		campus = new Campus();
        }
        
	// Deze methode geeft een tableModel door naar de view.
	public AbstractTableModel geefTableModel(SoortTableModel soort)	{
		return TableModelFactory.createTableModel(soort, this);
	}
	
	protected Campus getCampus() {
		return campus;
	}
	
	protected Student getGeslecteerdeStudent() {
		return geselecteerdeStudent;
	}
        
	protected Promotor getGeslecteerdePromotor() {
		return geselecteerdePromotor;
	}

	@Override
	public void update(Observable o, Object object) 
        {
            if(object instanceof Student)
            {            
		geselecteerdeStudent = (Student) object; 
		setChanged();
		notifyObservers(geselecteerdeStudent);
            } else { 
                geselecteerdePromotor = (Promotor) object;
                setChanged();
		notifyObservers(geselecteerdePromotor);
            }
	}
        
        public void voegGeselecteerdeStudentToe() {
            campus.addGeselecteerdeStudent(geselecteerdeStudent);
        }
        
        public void verwijderStudentUitLijst(){
            campus.verwijderStudentUitLijst(geselecteerdeStudent);
        } 
        
        public void maakGeselecteerdeStudentenLeeg(){
            campus.maakGeselecteerdeStudentenLeeg();
        } 
        
        public void koppelPromotorEnGeselecteerdeStudenten(){
            System.out.println("Koppel promotor oke 1");
            campus.koppelPromotorEnGeselecteerdeStudenten(geselecteerdePromotor);
        }
        
        public void ontkoppelStudentEnPromotor(){
            System.out.println("Ontkoppel promotor oke 1");
            campus.ontkoppelStudentEnPromotor(geselecteerdeStudent, geselecteerdePromotor);
        }
        
        
        public boolean checkHeeftStudentEenPromotor(Student student){
            return campus.checkHeeftStudentEenPromotor(student);
        }  
        
        public boolean heeftPromotorNogPlaatsVoorStudenten(Promotor promotor){
            return campus.heeftPromotorNogPlaatsVoorStudenten(promotor);
        }
}
