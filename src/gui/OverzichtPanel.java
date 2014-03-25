package gui;

import domein.domein.Student;
import domein.tableModel.StudentTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

public class OverzichtPanel extends javax.swing.JPanel implements ListSelectionListener 
{
    private JScrollPane jScrollPaneOvezicht;
    private JLabel lblTitel;
    private JTable jTableOverzicht;
    private Observer observer;
    
    public OverzichtPanel(TableModel jTableOverzichtModel, String titel) 
    {
        super();
        initGui(jTableOverzichtModel, titel);
    }

    private void initGui(TableModel jTableOverzichtModel, String titel) 
    {
        try {
            setPreferredSize(new Dimension(400, 300));
            BorderLayout thisLayout = new BorderLayout();
            this.setLayout(thisLayout);

            lblTitel = new JLabel();
            this.add(lblTitel, BorderLayout.NORTH);
            lblTitel.setText(titel);

            observer = (Observer) jTableOverzichtModel; /* ! */

            jTableOverzicht = new JTable();
            jTableOverzicht.setModel(jTableOverzichtModel);
            jTableOverzicht.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableOverzicht.getSelectionModel().addListSelectionListener(this);
            jScrollPaneOvezicht = new JScrollPane(jTableOverzicht);
            jScrollPaneOvezicht.createVerticalScrollBar().setVisible(true);
            this.add(jScrollPaneOvezicht, BorderLayout.CENTER);
            jScrollPaneOvezicht.setPreferredSize(new java.awt.Dimension(385, 284));
            jScrollPaneOvezicht.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);        
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) 
    {
        /* maar 1 event wordt uitgevoerd */
        if (event.getValueIsAdjusting())
            return;
        observer.update(null, jTableOverzicht.getSelectedRow());
    }
    
    public int getSelectedRowInt()
    {
        return this.jTableOverzicht.getSelectedRow();
    }
}
