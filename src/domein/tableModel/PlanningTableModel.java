/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein.tableModel;

import domein.domein.Campus;
import domein.domein.Gebruiker;
import domein.domein.Planning;
import domein.domein.Presentatie;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brent
 */
public class PlanningTableModel extends AbstractTableModel {

    private Planning planning;

    private static final int MAX_KOLOMMEN = 5;
    private static final String[] KOLOMNAMEN
            = {"DATUM", "ONDERZOEKSDOMEIN", "PRESENTATIE", "STUDENT", "PROMOTOR"};

    public PlanningTableModel(Planning planning) {
        this.planning = planning;
    }

    @Override
    public int getRowCount() {
        return planning.geefAantalPresentaties();

    }

    @Override
    public int getColumnCount() {
        return MAX_KOLOMMEN;
    }

    @Override
    public String getValueAt(int rij, int kolom
    ) {
        Presentatie presentatie = planning.geefPresentatie(rij);
        switch (kolom) {
            case 0:
                return presentatie.getTijdSlot();
            case 1:
                return presentatie.getOnderzoeksdomein();
            case 2:
                return presentatie.getTitel();
            case 3:
                return presentatie.getStudent();
            case 4:
                return presentatie.getPromotor();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int kolom
    ) {
        return KOLOMNAMEN[kolom];
    }


}
