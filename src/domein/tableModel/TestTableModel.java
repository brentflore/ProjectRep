package domein.tableModel;

import domein.domein.Campus;
import domein.domein.Gebruiker;
import domein.domein.Student;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;

public class TestTableModel extends AbstractTableModel implements Observer 
{
    private Campus campus;
    private static final int MAX_KOLOMMEN = 3;
    private static final String[] KOLOMNAMEN = {"STUDNR","NAAM","VOORNAAM"};

    public TestTableModel(Campus campus) { this.campus = campus; }

    @Override
    public int getRowCount() { return campus.geefAantalGeselecteerdeStudenten(); }

    @Override
    public String getColumnName(int kolom) { return KOLOMNAMEN[kolom]; }

    @Override
    public int getColumnCount() { return MAX_KOLOMMEN; }

    @Override
    public Object getValueAt(int rij, int kolom) 
    {
        Student student = campus.geefGeselecteerdeStudent(rij);
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
    { fireTableDataChanged(); }
}
