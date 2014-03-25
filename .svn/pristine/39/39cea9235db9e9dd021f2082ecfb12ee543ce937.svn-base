/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein.tableModel;

import domein.domein.Campus;
import domein.domein.Gebruiker;
import domein.domein.Subject;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristine
 */
public class GebruikerTableModel extends AbstractTableModel implements Observer, Subject
{
    private Campus campus;
    private Set<Observer> observers;
    
    private static final int MAX_KOLOMMEN = 4;
    private static final String[] KOLOMNAMEN = {"NAAM", "VOORNAAM", "PERSONEELSNR", "MAXSTUD"};
    
    public GebruikerTableModel(Campus campus) 
    {
        this.campus = campus;
        observers = new HashSet<>();
    }

    @Override
    public int getRowCount() {
        return campus.geefAantalPromotoren(); //geefAantalGebruikers();
    }

    @Override
    public int getColumnCount() {
        return MAX_KOLOMMEN;
    }
    
    @Override
    public String getColumnName(int kolom) {
        return KOLOMNAMEN[kolom];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addObserver(Observer observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
