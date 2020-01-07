package tastat;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class PantallaClients {

	public JFrame frame;	//private
	//private Magatzem magatzem = new Magatzem();
	private JTextField textIdClient;
	private JTextField textNom;
	private JTextField textCif;
	private JTextField textDireccio;
	private JTextField textPoblacio;
	private JTextField textPersonaContacte;
	private JTextField textNumero;
	private JTextField textLatitud;
	private JTextField textLongitud;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PantallaClients window = new PantallaClients();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaClients() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//magatzem = Programa.generaMagatzem();
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 591);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(223, 50, 162, 20);
		frame.getContentPane().add(comboBox);

		
		JLabel lblNewLabel = new JLabel("Clients:");
		lblNewLabel.setBounds(146, 53, 84, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIdclient = new JLabel("IdClient:");
		lblIdclient.setBounds(90, 132, 46, 14);
		frame.getContentPane().add(lblIdclient);
		
		textIdClient = new JTextField();
		textIdClient.setBounds(146, 126, 86, 20);
		frame.getContentPane().add(textIdClient);
		textIdClient.setColumns(10);
		textIdClient.setEnabled(false);
		
		textNom = new JTextField();
		textNom.setBounds(146, 186, 86, 20);
		frame.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setBounds(90, 189, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCif = new JLabel("CIF:");
		lblCif.setBounds(257, 189, 46, 14);
		frame.getContentPane().add(lblCif);
		
		textCif = new JTextField();
		textCif.setBounds(285, 186, 86, 20);
		frame.getContentPane().add(textCif);
		textCif.setColumns(10);
		
		JCheckBox chckbxActiu = new JCheckBox("Actiu");
		chckbxActiu.setBounds(285, 125, 97, 23);
		frame.getContentPane().add(chckbxActiu);
		
		textDireccio = new JTextField();
		textDireccio.setBounds(146, 245, 86, 20);
		frame.getContentPane().add(textDireccio);
		textDireccio.setColumns(10);
		
		JLabel lblDirrecio = new JLabel("Dirrecio:");
		lblDirrecio.setBounds(90, 248, 46, 14);
		frame.getContentPane().add(lblDirrecio);
		
		JLabel lblPoblacio = new JLabel("Poblacio:");
		lblPoblacio.setBounds(257, 248, 46, 14);
		frame.getContentPane().add(lblPoblacio);
		
		textPoblacio = new JTextField();
		textPoblacio.setColumns(10);
		textPoblacio.setBounds(308, 245, 86, 20);
		frame.getContentPane().add(textPoblacio);
		
		JLabel lblPersonacontacte = new JLabel("PersonaContacte:");
		lblPersonacontacte.setBounds(39, 301, 97, 14);
		frame.getContentPane().add(lblPersonacontacte);
		
		textPersonaContacte = new JTextField();
		textPersonaContacte.setColumns(10);
		textPersonaContacte.setBounds(146, 298, 86, 20);
		frame.getContentPane().add(textPersonaContacte);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(257, 301, 46, 14);
		frame.getContentPane().add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(308, 298, 86, 20);
		frame.getContentPane().add(textNumero);
		
		textLatitud = new JTextField();
		textLatitud.setColumns(10);
		textLatitud.setBounds(146, 357, 86, 20);
		frame.getContentPane().add(textLatitud);
		
		JLabel lblLatitud = new JLabel("Latitud:");
		lblLatitud.setBounds(90, 360, 46, 14);
		frame.getContentPane().add(lblLatitud);
		
		textLongitud = new JTextField();
		textLongitud.setColumns(10);
		textLongitud.setBounds(308, 357, 86, 20);
		frame.getContentPane().add(textLongitud);
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(257, 360, 46, 14);
		frame.getContentPane().add(lblLongitud);
		
		JButton btnNuevoClient = new JButton("Alta Clinet");
		btnNuevoClient.setBounds(39, 518, 125, 23);
		frame.getContentPane().add(btnNuevoClient);
		
		JButton btnBaixaClient = new JButton("Baixa Client");
		btnBaixaClient.setBounds(195, 518, 114, 23);
		frame.getContentPane().add(btnBaixaClient);
		btnBaixaClient.setEnabled(false);
		JButton btnModifcaClient = new JButton("Modificar Client");
		btnModifcaClient.setBounds(320, 518, 134, 23);
		frame.getContentPane().add(btnModifcaClient);
		btnModifcaClient.setEnabled(false);
		String[] clients = new String[PantallaMain.magatzem.getClients().size()];
		int i =0;
		for(Client c : PantallaMain.magatzem.getClients()) {
			
			clients[i]= c.nomClient;
			i++;
		}
		
		comboBox.setModel(new DefaultComboBoxModel(clients));
		
		JButton btnAcetpar = new JButton("Acetpar");
		btnAcetpar.setBounds(56, 484, 89, 23);
		frame.getContentPane().add(btnAcetpar);
		btnAcetpar.setVisible(false);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.setBounds(56, 450, 89, 23);
		frame.getContentPane().add(btnRechazar);
		btnRechazar.setVisible(false);
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textIdClient.setText(String.valueOf(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).idClient));
				textNom.setText(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).nomClient);
				textCif.setText(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).CIF);
				textDireccio.setText(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).direccio);
				textPoblacio.setText(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).poblacio);
				textPersonaContacte.setText(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).personaContacte);
				textNumero.setText(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).telefon);
				textLatitud.setText(String.valueOf(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).latitud));
				textLongitud.setText(String.valueOf(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).longitud));
				if(PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex()).actiu) {
					 chckbxActiu.setSelected(true);
				}else  chckbxActiu.setSelected(false);
				
				btnBaixaClient.setEnabled(true);
				btnModifcaClient.setEnabled(true);
			}
		});
		btnNuevoClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnAcetpar.setVisible(true);
				btnRechazar.setVisible(true);
				btnModifcaClient.setEnabled(false);
				btnBaixaClient.setEnabled(false);
				
				textIdClient.setText("");
				textNom.setText("");
				textCif.setText("");
				textDireccio.setText("");
				textPoblacio.setText("");
				textPersonaContacte.setText("");
				textNumero.setText("");
				textLatitud.setText("");
				textLongitud.setText("");
			    chckbxActiu.setSelected(false);
			    comboBox.setEnabled(false);
				
			}
		});
		
		btnAcetpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client c = null;
				double latitud = 0;
				double longitud = 0;
				 String nomClient = textNom.getText();
				 String CIF= textCif.getText();
				 boolean actiu =   chckbxActiu.isSelected();
				 String direccio = textDireccio.getText();;
				 String poblacio = textPoblacio.getText();;
				
				 String personaContacte = textPersonaContacte.getText();;
				 String telefon = textNumero.getText();;
				
				 
				 if(textLatitud.getText().isEmpty() == false) {
					 latitud = Double.valueOf(textLatitud.getText());
				 }
				 if(textLongitud.getText().isEmpty() == false) {
					 longitud = Double.valueOf(textLongitud.getText());
				 }
				 
				 
				 if(nomClient.isEmpty() == false) {
			    c = new Client(nomClient,latitud,longitud);

				c.setDireccio(direccio);
				c.setPoblacio(poblacio);
				c.setCIF(CIF);
				c.setPersonaContacte(personaContacte);
				c.setTelefon(telefon);
				c.setActiu(actiu);
				PantallaMain.magatzem.getClients().add(c);
				
				 int i = 0;
					String[] clients = new String[PantallaMain.magatzem.getClients().size()];
					for(Client cli : PantallaMain.magatzem.getClients()) {
						
						clients[i]= cli.nomClient;
						i++;
					}
					
					
					comboBox.setModel(new DefaultComboBoxModel(clients));
				 }
				
				
				btnAcetpar.setVisible(false);
				btnRechazar.setVisible(false);
				comboBox.setEnabled(true);
			}
		});
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btnAcetpar.setVisible(false);
				btnRechazar.setVisible(false);
				comboBox.setEnabled(true);
				
			}
		});
		
		
		btnBaixaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aborrar = comboBox.getSelectedIndex();
				int i = JOptionPane.showConfirmDialog(null, "Seguro que vol eliminiar el client?");
			
				if(i == 0) {
					textIdClient.setText("");
					textNom.setText("");
					textCif.setText("");
					textDireccio.setText("");
					textPoblacio.setText("");
					textPersonaContacte.setText("");
					textNumero.setText("");
					textLatitud.setText("");
					textLongitud.setText("");
				    chckbxActiu.setSelected(false);
				    btnBaixaClient.setEnabled(false);
				    PantallaMain.magatzem.getClients().remove(aborrar);
				    int h = 0;
					String[] clients = new String[PantallaMain.magatzem.getClients().size()];
					for(Client client : PantallaMain.magatzem.getClients()) {
						
						clients[h]= client.nomClient;
						h++;
					}
					
					
					comboBox.setModel(new DefaultComboBoxModel(clients));
					btnBaixaClient.setEnabled(false);
					btnModifcaClient.setEnabled(false);
				}
				
				
			}
		});
	
		btnModifcaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textIdClient.setEnabled(false);

				int i = JOptionPane.showConfirmDialog(null, "Seguro que vol modificar el client?");
				
				
				
				
				if(i == 0) {
				
				Client c = PantallaMain.magatzem.getClients().get(comboBox.getSelectedIndex());
				double latitud = 0;
				double longitud = 0;
				 String nomClient = textNom.getText();
				 String CIF= textCif.getText();
				 boolean actiu =   chckbxActiu.isSelected();
				 String direccio = textDireccio.getText();;
				 String poblacio = textPoblacio.getText();;
				
				 String personaContacte = textPersonaContacte.getText();;
				 String telefon = textNumero.getText();;
				
				 
				 if(textLatitud.getText().isEmpty() == false) {
					 latitud = Double.valueOf(textLatitud.getText());
				 }
				 if(textLongitud.getText().isEmpty() == false) {
					 longitud = Double.valueOf(textLongitud.getText());
				 }
				 
				 
		
			    c .setNomClient(nomClient);
			    c.longitud = longitud;
			    c.latitud = latitud;
				c.setDireccio(direccio);
				c.setPoblacio(poblacio);
				c.setCIF(CIF);
				c.setPersonaContacte(personaContacte);
				c.setTelefon(telefon);
				c.setActiu(actiu);
				
				}
				
				
				
			}
		});
				
		
		
	}
}
