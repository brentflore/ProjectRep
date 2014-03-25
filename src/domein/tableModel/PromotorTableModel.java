package domein.tableModel;

import domein.domein.Campus;
import domein.domein.Gebruiker;
import java.util.Observable;
import java.util.Observer;

import javax.swing.table.AbstractTableModel;

import domein.domein.Promotor;
import domein.domein.Subject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PromotorTableModel extends AbstractTableModel implements Observer, Subject 
{
    // is luisteraar van OverzichtPanel
    // en
    // is luisteraar van Controller
    private Campus campus;
    private Set<Observer> observers;
    
    private static final int MAX_KOLOMMEN = 4;
    private static final String[] KOLOMNAMEN
            = {"NAAM", "VOORNAAM", "PERSONEELSNR", "MAXSTUD"};

    public PromotorTableModel(Campus campus) 
    {
        this.campus = campus;
        observers = new HashSet<>();
    }

    @Override
    public int getColumnCount() 
    {
        return MAX_KOLOMMEN;
    }

    @Override
    public int getRowCount() 
    {
        return campus.geefAantalPromotoren();
    }

    @Override
    public String getColumnName(int kolom) 
    {
        return KOLOMNAMEN[kolom];
    }

    @Override
    public Object getValueAt(int rij, int kolom) 
    {
        Promotor promotor = campus.geefPromotor(rij);
        switch (kolom)
        {
            case 0:
                return promotor.getNaam();
            case 1:
                return promotor.getVoornaam();
            case 2:
                return promotor.getPersoneelsNummer();
            case 3:
                return promotor.getMaxStudenten();
            default:
                return "";
        }
    }

    @Override
    public void update(Observable arg0, Object object) 
    {
	Integer index = (Integer) object;
        notifyObserver(campus.geefPromotor(index));
    }

    @Override
    public void addObserver(Observer observer) 
    {
        observers.add(observer);
    }

    @Override
    public void notifyObserver(Object object) 
    {
        for (Observer observer : observers) {
            observer.update(null, object);
        }
    }
}