package domein.tableModel;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import domein.domein.Campus;
import domein.domein.Gebruiker;
import domein.domein.Student;
import domein.domein.Subject;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel implements Observer, Subject
{
	private Campus campus;
	private Set<Observer> observers;

		
	private static final String[] KOLOMNAMEN = {"STUDNR","NAAM","VOORNAAM"};
	
	public StudentTableModel(Campus campus) 
	{
		this.campus = campus;
		observers = new HashSet<>();
	}

	@Override
	public int getColumnCount() 
	{
		return KOLOMNAMEN.length;
	}

	@Override
	public int getRowCount() 
	{
            return campus.geefAantalStudenten();
	}

	@Override
	public String getColumnName(int kolom)
	{
		return KOLOMNAMEN[kolom];
	}
	
	@Override
	public Object getValueAt(int rij, int kolom) 
	{
		Student student = campus.geefStudent(rij);
		switch (kolom) 
		{
		case 0: return student.getStudentenNummer();
		case 1: return student.getNaam();
		case 2: return student.getVoornaam();
		default:return "";
		}
	}

	@Override
	public void update(Observable o, Object object) 
	{       Integer index = (Integer) object;
                notifyObserver(campus.geefStudent(index));
	}
	
	@Override
	public void addObserver(Observer observer) 
	{
		observers.add(observer);	
	}
	
	@Override
	public void notifyObserver(Object object) 
	{
		for(Observer observer : observers)
		{
			observer.update(null, object);
		}
	}        
}