package gui;

import domein.domein.CampusController;
import domein.tableModel.SoortTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

import domein.listModel.SortedListModel;
import domein.tableModel.StudentTableModel;
import domein.tableModel.TestTableModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

public class DualListBox extends javax.swing.JPanel
{
        private static final String ADD_BUTTON_LABEL =    "Selecteer student";
        private static final String REMOVE_BUTTON_LABEL = "Verwijder student";
        private static final String REMOVE_ALL_BUTTON_LABEL = "Verwijder alle studenten";

	private OverzichtPanel overzichtStudentenPanelSrc;
	private OverzichtPanel overzichtStudentenPanelDest;
        private JButton addButton;
        private JButton removeButton;
        private JButton removeAllButton;
        private JLabel jlblStatus;
        
	private CampusController controller;
                
        private TableModel stmodel;
        private TableModel tmodel;
        private TestTableModel testmodel;

        public DualListBox(CampusController controller)
        {
            super();
            this.controller = controller;
            initGui();
        }
        
        private void initGui() 
	{
		try 
		{
			this.setPreferredSize(new java.awt.Dimension(775, 300));
			this.setLayout(null);
			{
                                stmodel = controller.geefTableModel(SoortTableModel.STUDENT);                                
				overzichtStudentenPanelSrc = new OverzichtPanel(stmodel, "Overzicht Studenten");
				this.add(overzichtStudentenPanelSrc);
				overzichtStudentenPanelSrc.setBounds(20, 20, 500, 115);
			}
                        {
                                tmodel = controller.geefTableModel(SoortTableModel.TEST);
                                overzichtStudentenPanelDest = new OverzichtPanel(tmodel, "Geselecteerde Studenten");
                                this.add(overzichtStudentenPanelDest);
                                overzichtStudentenPanelDest.setBounds(20, 150, 500, 115);
			}
                        {
                                addButton = new JButton(ADD_BUTTON_LABEL);
                                this.add(addButton);
                                addButton.setBounds(530, 35, 200, 25);
                                addButton.addActionListener(new ButtonListener()); //voegstudententoeListener
                                
                                removeButton = new JButton(REMOVE_BUTTON_LABEL);
                                this.add(removeButton);
                                removeButton.setBounds(530, 80, 200, 25);
                                removeButton.addActionListener(new ButtonListener());
                                
                                jlblStatus = new JLabel(" ");
                                jlblStatus.setBounds(530, 110, 200, 25);
                                jlblStatus.setHorizontalAlignment(SwingConstants.LEFT);
                                this.add(jlblStatus, BorderLayout.NORTH);
                                
                                removeAllButton = new JButton(REMOVE_ALL_BUTTON_LABEL);
                                this.add(removeAllButton);
                                removeAllButton.setBounds(530, 165, 200, 25);
                                removeAllButton.addActionListener(new ButtonListener());
                        }
		} catch (Exception e) { e.printStackTrace(); }
	}
        
        private class ButtonListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e) 
            {   
                testmodel = (TestTableModel)tmodel;
                if(selecteerStudent(overzichtStudentenPanelSrc.getSelectedRowInt()))
                {   if(e.getSource() == addButton)
                    try{ controller.voegGeselecteerdeStudentToe(); jlblStatus.setText("");
                         testmodel.update(controller, e); }
                    catch( ArrayIndexOutOfBoundsException ex){ jlblStatus.setText(ex.getMessage()); };
                }
                
                if(selecteerStudent(overzichtStudentenPanelSrc.getSelectedRowInt()))
                {  if(e.getSource() == removeButton) 
                    {controller.verwijderStudentUitLijst(); jlblStatus.setText("");}
                   
                   if(e.getSource() == removeAllButton) 
                   controller.maakGeselecteerdeStudentenLeeg();
                   
                   testmodel.update(controller, e);
                }
            }
        }
        
        private boolean selecteerStudent(int x)
        {
            if(x == -1) {
                jlblStatus.setForeground(Color.RED);
                jlblStatus.setText("Gelieve een student te selecteren");
                return false; } return true;
        }
}