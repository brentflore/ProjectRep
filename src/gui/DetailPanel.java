package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTextField;

import domein.domein.CampusController;
import domein.domein.Promotor;
import domein.tableModel.PromotorTableModel;
import domein.tableModel.SoortTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

public class DetailPanel extends javax.swing.JPanel
{
        private static final String KOPPEL_BUTTON_LABEL =    "Koppel promotor";
        private static final String ONTKOPPEL_BUTTON_LABEL = "Ontkoppel promotor";
        
	private OverzichtPanel overzichtPromotorenPanel; // hergebruik ! 
        
        private JButton addButton;
        private JButton removeButton;
        
        private JLabel jlblStatus;
        
	private CampusController controller;
        
        private TableModel pmModel;
        private PromotorTableModel promModel;

	public DetailPanel(CampusController controller) 
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
                                pmModel = controller.geefTableModel(SoortTableModel.PROMOTOR);
				overzichtPromotorenPanel = new OverzichtPanel(pmModel, "Beschikbare promotoren");
				// Zo wordt het overzichtPanel herbruikt, we geven hem een algemene tableModel
				this.add(overzichtPromotorenPanel);
				overzichtPromotorenPanel.setBounds(20, 20, 500, 115);
			}
                        {
                                addButton = new JButton(KOPPEL_BUTTON_LABEL);
                                this.add(addButton);
                                addButton.setBounds(530, 35, 200, 25);
                                addButton.addActionListener(new DetailPanel.KoppelListener());
                                
                                removeButton = new JButton(ONTKOPPEL_BUTTON_LABEL);
                                this.add(removeButton);
                                removeButton.setBounds(530, 80, 200, 25);
                                removeButton.addActionListener(new DetailPanel.OntkoppelListener());
                
                                jlblStatus = new JLabel(" ");
                                jlblStatus.setBounds(530, 110, 220, 25);
                                jlblStatus.setHorizontalAlignment(SwingConstants.LEFT);
                                this.add(jlblStatus, BorderLayout.NORTH);
                        }
		} catch (Exception e) {	e.printStackTrace(); }
	}
        
        // Werkt!
        private class KoppelListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent e) 
            {   if(e.getSource() == addButton) 
                {  if(selecteerPromotor(overzichtPromotorenPanel.getSelectedRowInt()))
                    try{ controller.koppelPromotorEnGeselecteerdeStudenten(); 
                         jlblStatus.setForeground(Color.BLUE); jlblStatus.setText("Koppeling succesvol"); }
                    catch( ArrayIndexOutOfBoundsException ex){ jlblStatus.setText(ex.getMessage()); };
                }
            }
        }

        // TODO: vanuit domein ontkoppeling registreren - Observer?
        private class OntkoppelListener implements ActionListener 
        {    public void actionPerformed(ActionEvent e) {
                if(e.getSource() == removeButton) 
                {  if(selecteerPromotor(overzichtPromotorenPanel.getSelectedRowInt()))
                    try{ controller.ontkoppelStudentEnPromotor();
                         jlblStatus.setForeground(Color.BLUE); jlblStatus.setText("Ontkoppeling succesvol"); }
                    catch( ArrayIndexOutOfBoundsException ex){ jlblStatus.setText(ex.getMessage()); };
                }
            }
        }
        
        private boolean selecteerPromotor(int x)
        {
            if(x == -1) {
                jlblStatus.setForeground(Color.RED);
                jlblStatus.setText("Gelieve een promotor te selecteren");
                return false; } return true;
        }
}