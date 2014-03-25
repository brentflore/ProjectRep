/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import domein.domein.CampusController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.LineBorder;

/**
 *
 * @author Kristine
 */
public class LoginFrame extends JFrame
{
    private JLabel userLabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JLabel jlblStatus;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel schermLabel;
    private JComboBox cmbScherm;
    private SoortScherm scherm;
    
    private GuiController gController;
    
    public LoginFrame(GuiController gController) 
    {
        super();
        this.gController = gController;
        initGui();
    }
    
    private void initGui() 
	{
		try 
		{
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
		{
                        userLabel = new JLabel("Gebruiker");
                        userLabel.setBounds(10, 10, 80, 25);
                        getContentPane().add(userLabel);
                        
                        userText = userText = new JTextField(20);
                        userText.setBounds(100, 10, 160, 25);
                        getContentPane().add(userText);

        		passwordLabel = new JLabel("Paswoord");
                	passwordLabel.setBounds(10, 40, 80, 25);
                        getContentPane().add(passwordLabel);

        		passwordText = new JPasswordField(20);
                	passwordText.setBounds(100, 40, 160, 25);
                        getContentPane().add(passwordText);

        		loginButton = new JButton("Login");
                	loginButton.setBounds(10, 125, 80, 25);
                        getContentPane().add(loginButton);

            		cancelButton = new JButton("Cancel");
                	cancelButton.setBounds(180, 125, 80, 25);
                        getContentPane().add(cancelButton);
                
                        jlblStatus = new JLabel(" ");
                        jlblStatus.setBounds(40, 100, 210, 25);
                        jlblStatus.setHorizontalAlignment(SwingConstants.LEFT);
                        getContentPane().add(jlblStatus, BorderLayout.NORTH);
                        
                        schermLabel = new JLabel("Scherm:");
                        schermLabel.setBounds(10, 70, 80, 25);
                        schermLabel.setHorizontalAlignment(SwingConstants.LEFT);
                        getContentPane().add(schermLabel, BorderLayout.NORTH);
                        
                        cmbScherm = new javax.swing.JComboBox();
                        cmbScherm.setModel(new javax.swing.DefaultComboBoxModel(new String[] 
                        { SoortScherm.UNKOWN.toString(), SoortScherm.KOPPEL.toString(), SoortScherm.PLANNING.toString()}));
                        cmbScherm.setBounds(100, 70, 159, 25);
                        cmbScherm.setAlignmentX(LEFT_ALIGNMENT);
                        getContentPane().add(cmbScherm, BorderLayout.NORTH);
                        
                        cmbScherm.addActionListener(new ActionListener() 
                        {
                                   @Override
                                   public void actionPerformed(ActionEvent selScherm) 
                                   {
                                       switch(cmbScherm.getSelectedIndex())
                                       {
                                           case 1: scherm = SoortScherm.KOPPEL; break;
                                           case 2: scherm = SoortScherm.PLANNING; break;
                                           default: scherm = SoortScherm.KOPPEL; break;
                                       }
                                   }
                          });
                }
                {
                        loginButton.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent login) 
                            { if(login.getSource() == loginButton)
                                 login(); }
                        });
                        loginButton.addKeyListener(new KeyListener()
                        {
                            @Override
                            public void keyTyped(KeyEvent e) { }
                            @Override
                            public void keyReleased(KeyEvent e) { }

                            @Override
                            public void keyPressed(KeyEvent e) 
                            {  if (e.getKeyCode() == KeyEvent.VK_ENTER)
                                   login();
                            }
                        });
                        cancelButton.addActionListener(new ActionListener() 
                        {   @Override
                            public void actionPerformed(ActionEvent e) 
                            { System.exit(0); }
                        });
                }
			pack();
			this.setSize(280, 190);
			setLocationRelativeTo(null);
			this.setTitle("Login");
			this.setAlwaysOnTop(true);
			this.setResizable(false);
			this.setVisible(true);
		} catch (Exception e) { e.printStackTrace(); }
                
        }
                private boolean controleerLogin(String username, String password)
                {                                
                  if (username.equals("")) {
                      if (password.equals("")) {
                         jlblStatus.setForeground(Color.BLUE);
                         jlblStatus.setText("Login succesful");
                         return true;
                       } else { return false; }
                    } else {
                        jlblStatus.setForeground(Color.RED);
                        jlblStatus.setText("Invalid username or password");
                        return false;
                    }
                } 
                
                private void login()
                {
                    if (controleerLogin(userText.getText(), passwordText.getText()))
                    {   if(scherm == null)
                        {   jlblStatus.setForeground(Color.RED);
                            jlblStatus.setText("Gelieve een scherm te selecteren");
                        }else{gController.maakScherm(scherm);}
                    }
                }
}
