package tastat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.html.HTMLEditorKit.Parser;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class PantallaComandes {

	public JFrame frame;	//private
	private JTextField txtComanda;

	/* VARIABLES */
	//private Magatzem magatzem = new Magatzem();
	private JTextField txtIdclient;
	private JTextField txtData;
	private JTextField txtLliurament;
	private JTextField txtPorts;
	private JTable table;
	private JTable table_1;
	private int pos = 0; // indcicamos la posicion exacta donde se encuentrar la comanda
	JComboBox combo = null;
	private JTextField textTotal;
	JLabel lblComanda ;
	JPanel panel;
	JLabel lblClient;
	JComboBox comboBoxClient ;
	JLabel lblData;
	JLabel lblLliurament;
	JLabel lblPorts;
	JPanel panel_1;
	JRadioButton rdbtnPendent;
	JRadioButton rdbtnPreparada;
	JRadioButton rdbtnTransport;
	JRadioButton rdbtnLliurada;
	JButton btnNovaComanda;
	JButton btnEsborrarComanda;
	JButton btnEditarComanda;
	JButton btnPrimeraComanda;
	JButton btnComandaAnterior;
	JButton btnComandaSeguent;
	JButton btnUltimaComanda;
	JButton btnBuscar;
	JLabel lblResBuscar;
	JLabel lblNewLabel;
	JScrollPane scrollPane;
	SimpleDateFormat sdf;
	DefaultTableModel tabla;
	JButton btnAcept;
	JButton btnRechazar;
	JButton btnMas;
	JButton btnMenos;
	JButton btnAcceptar;
	JButton btnRechazarEdit;
	JButton btnAceptar;
	JButton btnRechazarL;
	JLabel  lblTotal;
	
	int contes = 0;
	
	
	//
	int idMax;
	int idMin;
	int idActual = 0;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaComandes window = new PantallaComandes();
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
	public PantallaComandes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//magatzem = Programa.generaMagatzem();
		//System.out.println(magatzem);
		// -----------------------------
		sdf = new SimpleDateFormat("dd/MM/yyyy"); // formato fechas

		/// ----Declaramos en panel que contendra infomacion comanda

		frame = new JFrame();
		frame.setBounds(100, 100, 851, 733);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblComanda = new JLabel("Comanda: ");
		lblComanda.setBounds(53, 99, 65, 14);
		frame.getContentPane().add(lblComanda);

		txtComanda = new JTextField();
		txtComanda.setBounds(128, 96, 86, 20);
		frame.getContentPane().add(txtComanda);
		txtComanda.setColumns(10);

		panel = new JPanel();
		panel.setBounds(47, 140, 463, 130);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblClient = new JLabel("Client: ");
		lblClient.setBounds(41, 19, 46, 14);
		panel.add(lblClient);

		comboBoxClient = new JComboBox();
		comboBoxClient.setBounds(81, 16, 144, 20);
		panel.add(comboBoxClient);

		txtIdclient = new JTextField();
		txtIdclient.setBounds(235, 16, 32, 20);
		panel.add(txtIdclient);
		txtIdclient.setColumns(10);

		lblData = new JLabel("dataComanda: ");
		lblData.setBounds(6, 67, 74, 14);
		panel.add(lblData);

		txtData = new JTextField();
		txtData.setBounds(81, 64, 144, 20);
		panel.add(txtData);
		txtData.setColumns(10);

		lblLliurament = new JLabel("dataLliurament: ");
		lblLliurament.setBounds(251, 67, 97, 14);
		panel.add(lblLliurament);

		txtLliurament = new JTextField();
		txtLliurament.setBounds(346, 64, 111, 20);
		panel.add(txtLliurament);
		txtLliurament.setColumns(10);

		lblPorts = new JLabel("Ports:");
		lblPorts.setBounds(294, 106, 46, 14);
		panel.add(lblPorts);

		txtPorts = new JTextField();
		txtPorts.setBounds(346, 103, 111, 20);
		panel.add(txtPorts);
		txtPorts.setColumns(10);
		/// ----Fin declaracion en panel que contendra info comandas

		/// ----Declaramos en panel que contendra rdnbuttonns
		panel_1 = new JPanel();
		panel_1.setBounds(540, 140, 111, 124);
		panel_1.setBorder(new TitledBorder(null, "Estat Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		rdbtnPendent = new JRadioButton("Pendent");
		rdbtnPendent.setBounds(6, 16, 109, 23);
		panel_1.add(rdbtnPendent);

		rdbtnPreparada = new JRadioButton("Preparada");
		rdbtnPreparada.setBounds(6, 42, 109, 23);
		panel_1.add(rdbtnPreparada);

		rdbtnTransport = new JRadioButton("Transport");
		rdbtnTransport.setBounds(6, 68, 109, 23);
		panel_1.add(rdbtnTransport);

		rdbtnLliurada = new JRadioButton("Lliurada");
		rdbtnLliurada.setBounds(6, 94, 109, 23);
		panel_1.add(rdbtnLliurada);
		/// ----Fin declaracion en panel que contendra rdnbuttonns

		/// ---Inicio declaracion en Parete inferiro ventana, novaComanda,
		/// esborrarComanda...
		btnNovaComanda = new JButton("Nova Comanda");

		btnNovaComanda.setBounds(121, 643, 124, 23);
		frame.getContentPane().add(btnNovaComanda);

		btnEsborrarComanda = new JButton("Esborrar Comanda");
		btnEsborrarComanda.setBounds(255, 643, 124, 23);
		frame.getContentPane().add(btnEsborrarComanda);
		btnEsborrarComanda.setEnabled(false);
		
		btnEditarComanda = new JButton("Editar Comanda");
		btnEditarComanda.setBounds(389, 643, 124, 23);
		frame.getContentPane().add(btnEditarComanda);
		btnEditarComanda.setEnabled(false);
		
		btnPrimeraComanda = new JButton("<<");
		btnPrimeraComanda.setBounds(523, 643, 49, 23);
		frame.getContentPane().add(btnPrimeraComanda);

		btnComandaAnterior = new JButton("<");
		btnComandaAnterior.setBounds(582, 643, 49, 23);
		frame.getContentPane().add(btnComandaAnterior);

		btnComandaSeguent = new JButton(">");
		btnComandaSeguent.setBounds(641, 643, 49, 23);
		frame.getContentPane().add(btnComandaSeguent);

		btnUltimaComanda = new JButton(">>");
		btnUltimaComanda.setBounds(700, 643, 49, 23);
		frame.getContentPane().add(btnUltimaComanda);

		/// ----Fin declaracion Parete inferiro ventana, novaComanda, esborrarComanda...

		/// ----Inicio declaracion Parete Superior, buscar.
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(244, 95, 89, 23);
		frame.getContentPane().add(btnBuscar);

		lblResBuscar = new JLabel("");
		lblResBuscar.setBounds(343, 99, 46, 14);
		frame.getContentPane().add(lblResBuscar);

		// Titulo
		lblNewLabel = new JLabel("Consulta Comandes");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 455, 42);
		frame.getContentPane().add(lblNewLabel);
		// fin titulo

		/// ----Fin declaracion Parete Superior, buscar.

		/// ----Generamos CombobOX CON CLIENTES
		String[] clients = new String[PantallaMain.magatzem.getClients().size()];
		int contcli = 0;
		for (Client c : PantallaMain.magatzem.getClients()) {
			clients[contcli] = c.nomClient;
			contcli++;
		}
		comboBoxClient.setModel(new DefaultComboBoxModel(clients));
		/// ----Fin Generacion CombobOX CON CLIENTES

		/// ---Generamos tabla
		scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 298, 526, 256);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Linia", "IdProducte", "NomProducte", "Quantitat", "Preu venda", "Import" }) {
			Class[] columnTypes = new Class[] { Integer.class, Integer.class, Object.class, Object.class, Object.class,
					Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);

		tabla = (DefaultTableModel) table_1.getModel();
		/// ---Fin generar tabla

		// Boton aceptar i rrechazar nova comanda
		btnAcept = new JButton("Aceptar");
		btnAcept.setEnabled(true);
		btnAcept.setBounds(133, 609, 89, 23);
		frame.getContentPane().add(btnAcept);
		btnAcept.setVisible(false);

		btnRechazar = new JButton("Rechazar");
		btnRechazar.setBounds(133, 575, 89, 23);
		frame.getContentPane().add(btnRechazar);
		btnRechazar.setVisible(false);
		// Fin Boton aceptar nova comanda

		// Botonoes agregar y quitar linea de comanda
		btnMas = new JButton("+");
		btnMas.setBounds(69, 463, 49, 23);
		frame.getContentPane().add(btnMas);

		btnMenos = new JButton("-");
		btnMenos.setBounds(69, 497, 49, 23);
		frame.getContentPane().add(btnMenos);
		
		btnMas.setVisible(false);
		btnMenos.setVisible(false);
		// FInBotonoes agregar y quitar linea de comanda

		// boton acept edit comanda
		btnAcceptar = new JButton("Aceptar");
		btnAcceptar.setBounds(402, 609, 89, 23);
		frame.getContentPane().add(btnAcceptar);
		
		btnRechazarEdit = new JButton("Rechazar");
		btnRechazarEdit.setBounds(402, 575, 89, 23);
		frame.getContentPane().add(btnRechazarEdit);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(29, 416, 89, 23);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.setVisible(false);
		
		
		btnRechazarL = new JButton("Salir");
		btnRechazarL.setBounds(29, 376, 89, 23);
		frame.getContentPane().add(btnRechazarL);
		
		textTotal = new JTextField();
		textTotal.setBounds(577, 565, 74, 20);
		frame.getContentPane().add(textTotal);
		textTotal.setColumns(10);
		
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(523, 565, 46, 14);
		frame.getContentPane().add(lblTotal);
		btnRechazarL.setVisible(false);
		
		btnRechazarEdit.setVisible(false);
		btnAcceptar.setVisible(false);
		// Boton acpet edit comanda

		// agrupacion rdnbutton
		/*
		 * JPanel panel21 = new JPanel(); ButtonGroup grupo = new ButtonGroup();
		 * grupo.add(rdbtnPendent);
		 * 
		 * grupo.add(rdbtnLliurada); grupo.add(rdbtnPreparada);
		 * grupo.add(rdbtnTransport);
		 * 
		 * panel21.add(rdbtnPendent);
		 * 
		 * panel21.add(rdbtnLliurada); panel21.add(rdbtnPreparada);
		 * panel21.add(rdbtnTransport);
		 * 
		 * frame.getContentPane().add(panel21);
		 */
		
		//
		getIdMaxMin();
		
		/*System.out.println(idActual);
		System.out.println(idMax);
		System.out.println(idMin);*/

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar();
			}

		});
		
		btnNovaComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAcept.setVisible(true);
				btnRechazar.setVisible(true);
				btnBuscar.setEnabled(false);
				btnEditarComanda.setEnabled(false);
				btnMas.setEnabled(false);
				btnMenos.setEnabled(false);
				lblResBuscar.setText("");
				txtData.setText("");
				txtData.setEnabled(false);
				txtLliurament.setText("");
				txtPorts.setText("");
				txtIdclient.setText("");
				txtIdclient.setEnabled(false);
				
				
				txtComanda.setText("");
				txtComanda.setEnabled(false);
				tabla.setRowCount(0);
				comboBoxClient.setEnabled(true);

				// desbloqueo comanda
				txtLliurament.setEnabled(true);
				txtPorts.setEnabled(true);
				
				btnEsborrarComanda.setEnabled(false);
				
				
				rdbtnLliurada.setSelected(false);
				rdbtnTransport.setSelected(false);
				rdbtnPreparada.setSelected(false);
				rdbtnPendent.setSelected(true);

				rdbtnLliurada.setEnabled(false);
				rdbtnTransport.setEnabled(false);
				rdbtnPreparada.setEnabled(false);
				rdbtnPendent.setEnabled(false);
				
			}

		});

		/*
		 * comboBoxClient.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) {
		 * txtIdclient.setText(String.valueOf(comboBoxClient.getSelectedIndex()+1));
		 * 
		 * }
		 * 
		 * });
		 */
		
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtData.setText("");
				txtData.setEnabled(true);
				
				txtLliurament.setText("");
				
				txtPorts.setText("");
				
				txtIdclient.setText("");
				txtIdclient.setEnabled(true);
				
				
				txtComanda.setText("");
				txtComanda.setEnabled(true);
				tabla.setRowCount(0);
				comboBoxClient.setEnabled(true);
				
				btnAcept.setVisible(false);
				btnRechazar.setVisible(false);
				
				
				btnEditarComanda.setEnabled(false);
				btnBuscar.setEnabled(true);
				btnMas.setEnabled(true);
				btnMenos.setEnabled(true);
				
				rdbtnLliurada.setSelected(false);
				rdbtnTransport.setSelected(false);
				rdbtnPreparada.setSelected(false);
				rdbtnPendent.setSelected(false);

				rdbtnLliurada.setEnabled(true);
				rdbtnTransport.setEnabled(true);
				rdbtnPreparada.setEnabled(true);
				rdbtnPendent.setEnabled(true);
				btnMas.setVisible(false);
				btnMenos.setVisible(false);
			
			}
		});
		btnAcept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ok = true;
				Comanda nCom =null;
				Double as = 0.0;
				try {
					 as = Double.valueOf(txtPorts.getText());
					Date fecha = sdf.parse(txtLliurament.getText());
					nCom = new Comanda(PantallaMain.magatzem.getClients().get(comboBoxClient.getSelectedIndex()));
					nCom.dataLliurament = fecha;
					nCom.setDataLliurament(fecha);
					ok = true;
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Algun dato introducido incorrecto" );
					ok = false;
					e.printStackTrace();
				}
				nCom.setPortes(as);
				
				
				if (ok) {
					btnAcept.setVisible(false);
					btnRechazar.setVisible(false);
					PantallaMain.magatzem.getComandes().add(nCom)	;	
					contes--;
					txtData.setText("");
					txtData.setEnabled(true);
					
					txtLliurament.setText("");
					
					txtPorts.setText("");
					
					txtIdclient.setText("");
					txtIdclient.setEnabled(true);
					
					
					txtComanda.setText("");
					txtComanda.setEnabled(true);
					
					
					rdbtnLliurada.setSelected(false);
					rdbtnTransport.setSelected(false);
					rdbtnPreparada.setSelected(false);
					rdbtnPendent.setSelected(false);

					rdbtnLliurada.setEnabled(true);
					rdbtnTransport.setEnabled(true);
					rdbtnPreparada.setEnabled(true);
					rdbtnPendent.setEnabled(true);
					btnEditarComanda.setEnabled(true);
					btnBuscar.setEnabled(true);
					btnMas.setVisible(false);
					btnMenos.setVisible(false);
					
					
					//
					getIdMaxMin();
				};
				
			}
		});
		
		btnEsborrarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aborrar = pos; 
				
				int i = JOptionPane.showConfirmDialog(null, "Seguro que desea elimnar la comanda?");
			
				
				if(i == 0) {
					PantallaMain.magatzem.getComandes().remove(aborrar);
					contes++;
					txtData.setText("");
					txtLliurament.setText("");
					txtPorts.setText("");
					txtIdclient.setText("");
					txtComanda.setText("");
					
					txtData.setEnabled(true);
					
		
					
	
					txtIdclient.setEnabled(true);
					
		
					txtComanda.setEnabled(true);
					
					
					
					rdbtnLliurada.setSelected(false);
					rdbtnTransport.setSelected(false);
					rdbtnPreparada.setSelected(false);
					rdbtnPendent.setSelected(false);

					rdbtnLliurada.setEnabled(true);
					rdbtnTransport.setEnabled(true);
					rdbtnPreparada.setEnabled(true);
					rdbtnPendent.setEnabled(true);
					comboBoxClient.setEnabled(true);
					tabla.setRowCount(0);
					btnEsborrarComanda.setEnabled(false);
					
					//
					getIdMaxMin();
				}
	
				
			}
		});
		

		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int conta = table_1.getRowCount() +1;
				tabla.addRow(new Object[] { conta, null, null, null, null, null });
				
				String[] productes = new String[PantallaMain.magatzem.getProductes().size()];
				int cont = 0;
				for (Producte p : PantallaMain.magatzem.getProductes()) {

					productes[cont] = p.nomProducte;
					cont++;
				}
				combo = new JComboBox<String>(productes);

				combo.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, combo.getSelectedItem());
						
					}
					
				});

				TableColumn col = table_1.getColumnModel().getColumn(2);
				col.setCellEditor(new DefaultCellEditor(combo));

				
				
				btnRechazarL.setVisible(true);
				btnAceptar.setVisible(true);
				btnBuscar.setEnabled(false);	
				btnNovaComanda.setEnabled(false);
				btnEditarComanda.setEnabled(false);
				btnEsborrarComanda.setEnabled(false);
				btnMas.setEnabled(false);
			}
		});
		
		
		
		

		btnEditarComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtLliurament.setEnabled(true);
				txtPorts.setEnabled(true);
				txtIdclient.setEnabled(true);
				txtData.setEnabled(true);
				btnAcceptar.setVisible(true);
				btnNovaComanda.setEnabled(false);
				btnRechazarEdit.setVisible(true);
				comboBoxClient.setEnabled(true);
				btnBuscar.setEnabled(false);
				

				rdbtnLliurada.setEnabled(true);
				rdbtnTransport.setEnabled(true);
				rdbtnPreparada.setEnabled(true);
				rdbtnPendent.setEnabled(true);

			}
		});
		btnAcceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean trobat = false;
				
				int i = 0;
				btnAcceptar.setVisible(false);
				for (Comanda c : PantallaMain.magatzem.getComandes()) {

					if (c.idComanda == Integer.valueOf(txtComanda.getText())) {

						System.out.println("Hola que tal");
						pos = i;
						
					String nom = comboBoxClient.getSelectedItem().toString();
						try {
							
							Date fecha1 = sdf.parse(txtLliurament.getText());
							c.dataLliurament = fecha1;
							c.setPortes(Double.valueOf(txtPorts.getText())); 
							c.getClient().setNomClient(nom);;
							c.setClient(PantallaMain.magatzem.getClients().get(comboBoxClient.getSelectedIndex()));
						} catch (ParseException e) {
							JOptionPane.showMessageDialog(null, "Algun dato introducido incorrecto" );
							e.printStackTrace();
						}
						trobat = true;
						if (rdbtnPendent.isSelected() == true) {
							c.setEstat(ComandaEstat.PENDENT);
						}
						if (rdbtnLliurada.isSelected() == true) {
							c.setEstat(ComandaEstat.LLIURADA);
						}
						if (rdbtnTransport.isSelected() == true) {
							c.setEstat(ComandaEstat.TRANSPORT);

						}
						if (rdbtnPreparada.isSelected() == true) {
							c.setEstat(ComandaEstat.PREPARADA);
						}
					}
					
					
					
					i++;
				}
				if(trobat) {
					txtData.setText("");
					txtLliurament.setText("");
					txtPorts.setText("");
					txtIdclient.setText("");
					txtComanda.setText("");
					tabla.setRowCount(0);
					btnRechazarEdit.setVisible(false);
					btnAcceptar.setVisible(false);
					btnBuscar.setEnabled(true);
					btnNovaComanda.setEnabled(true);
					btnEsborrarComanda.setEnabled(false);
					btnEditarComanda.setEnabled(false);
				
				}
				
				

			}
		});
		
		
	
		
		btnRechazarEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtData.setText("");
				txtLliurament.setText("");
				txtPorts.setText("");
				txtIdclient.setText("");
				txtComanda.setText("");
				tabla.setRowCount(0);
				btnRechazarEdit.setVisible(false);
				btnAcceptar.setVisible(false);
				btnBuscar.setEnabled(true);
				btnNovaComanda.setEnabled(true);
				btnEsborrarComanda.setEnabled(false);
				btnEditarComanda.setEnabled(false);
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int conta = tabla.getRowCount();
				 
				 Double as = Double.valueOf((String) tabla.getValueAt(conta-1, 4)); 
				int can = Integer.valueOf((String) tabla.getValueAt(conta-1, 3)) ; 
				 
	             Producte az= PantallaMain.magatzem.getProductes().get(combo.getSelectedIndex());
				

				ComandaLinia a = new ComandaLinia(az, can ,as );
			
				PantallaMain.magatzem.getComandes().get(pos).getLinies().add(a);
				
				btnMas.setEnabled(true);
				
			}
		});
		
		btnRechazarL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				tabla.setRowCount(0);
				btnBuscar.setEnabled(true);
				btnNovaComanda.setEnabled(true);
				btnMas.setVisible(false);
				btnMenos.setVisible(false);
				btnAceptar.setVisible(false);
				btnRechazarL.setVisible(false);
				btnMas.setEnabled(true);
				
			}
		});
		btnComandaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//int i = Integer.valueOf(txtComanda.getText());
				
				/*switch(i){
				case 1:
					i = PantallaMain.magatzem.getComandes().size();
				break;
				default:
					if(i < PantallaMain.magatzem.getComandes().get(pos).idComanda) {
						i = PantallaMain.magatzem.getComandes().get(pos).idComanda;
					}else
					i--;
				break;
				
				}*/
				
				if(idActual == idMin || txtComanda.getText().isEmpty())
				{
					getIdMaxMin();
					
					idActual = idMax;
					idActual++;
				}
				
				if(idActual >= idMin)
				{	
					Comanda aux = null;
					
					do
					{
						idActual--;
						
						for(Comanda c : PantallaMain.magatzem.getComandes())
						{
							if(c.idComanda == idActual)
							{
								//vaciar();
								//informacioProducte(pr);
								txtComanda.setText(String.valueOf(c.idComanda));
								
								//PRUEBA
								aux = c;
							}
						}
					}while(aux == null);
				}
				
				
				//txtComanda.setText(String.valueOf(i));
				
				
				Buscar();
			}

		});
		btnComandaSeguent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//int i = Integer.valueOf(txtComanda.getText());
				
				/*if(i == PantallaMain.magatzem.getComandes().size()+contes) {
					System.out.println("Primero");
					i = 1;
				}else
					if(i > PantallaMain.magatzem.getComandes().get(pos).idComanda) {
					i = PantallaMain.magatzem.getComandes().get(pos).idComanda;
					System.out.println("tercero");
				} else {
					System.out.println("Segundo");
					i++;
				}*/
				
				System.out.println(idMax);
				
				if(idActual == idMax || txtComanda.getText().isEmpty())
				{
					getIdMaxMin();
					
					idActual = idMin;
					idActual--;
				}
				
				if(idActual <= idMax)
				{	
					Comanda aux = null;
					
					do
					{
						idActual++;
						
						for(Comanda c : PantallaMain.magatzem.getComandes())
						{
							if(c.idComanda == idActual)
							{
								//vaciar();
								//informacioProducte(pr);
								txtComanda.setText(String.valueOf(c.idComanda));
								
								//PRUEBA
								aux = c;
							}
						}
					}while(aux == null);
				}
				
			
				
				//txtComanda.setText(String.valueOf(i));
				
				
				Buscar();
			}

		});
		btnPrimeraComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				getIdMaxMin();
				
				//txtComanda.setText(String.valueOf(1));
				txtComanda.setText(String.valueOf(idMin));

				Buscar();
			}

		});
		btnUltimaComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtComanda.setText(String.valueOf(PantallaMain.magatzem.getComandes().size()));
				//
				getIdMaxMin();
				txtComanda.setText(String.valueOf(idMax));
				Buscar();
			}

		});
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				if(PantallaMain.magatzem.getComandes().get(pos).getLinies().isEmpty()== false){
					int i = JOptionPane.showConfirmDialog(null, "Seguro que desea elimnar la comanda?");
				if(i == 0) {
					
					tabla.removeRow(PantallaMain.magatzem.getComandes().get(pos).getLinies().size()-1);
					PantallaMain.magatzem.getComandes().get(pos).getLinies().remove(PantallaMain.magatzem.getComandes().get(pos).getLinies().size()-1);
				}
	
				}				
			
			}

		});
		
		
		
		
	}
	public void Buscar()
	{
		tabla.setRowCount(0); // ponemos a 0 la tabla
		boolean trobat = false;

		
		if (txtComanda.getText().isEmpty()) {
			lblResBuscar.setText("");
			txtData.setText("");
			txtLliurament.setText("");
			txtPorts.setText("");
			txtIdclient.setText("");
			// habilito
			rdbtnLliurada.setEnabled(true);
			rdbtnTransport.setEnabled(true);
			rdbtnPreparada.setEnabled(true);
			rdbtnPendent.setEnabled(true);

			// desmarco
			rdbtnPendent.setSelected(false);
			rdbtnLliurada.setSelected(false);
			rdbtnTransport.setSelected(false);
			rdbtnPreparada.setSelected(false);
			txtLliurament.setEnabled(true);
			txtPorts.setEnabled(true);
			txtIdclient.setEnabled(true);
			txtData.setEnabled(true);
			btnEditarComanda.setEnabled(false);
			btnEsborrarComanda.setEnabled(false);
			comboBoxClient.setEnabled(true);
			btnMas.setVisible(false);
			btnMenos.setVisible(false);

		} else {
			int i = 0;//contador bucle comadna
			for (Comanda c : PantallaMain.magatzem.getComandes()) {
				

				if (c.idComanda == Integer.valueOf(txtComanda.getText())) {

					trobat = true;
					pos = i;

				}
				i++;
			}
			if (trobat) {
				btnMas.setVisible(true);
				btnMenos.setVisible(true);
				btnEditarComanda.setEnabled(true);
				btnEsborrarComanda.setEnabled(true);
				comboBoxClient.setEnabled(false);
				int a = 1;
				for (ComandaLinia cl : PantallaMain.magatzem.getComandes().get(pos).getLinies()) {

					int idProducte = cl.getProducte().getCodiProducte();
					String nomPrducte = cl.getProducte().getNomProducte();
					int quantitat = cl.getQuantitat();
					double preu_venda = cl.preuVenda;
					double preufinal = preu_venda * quantitat;

					tabla.addRow(new Object[] { a, idProducte, nomPrducte, quantitat, preu_venda, preufinal });

					a++;

				}
				double total = 0;
				for(int h=0;h<tabla.getRowCount();h++) {
					
					total = total + (Double)(tabla.getValueAt(h, 5));
					
				}
				
				textTotal.setText(String.valueOf(total) + "€");
				
				
				//Ponemos valores en los txt
				comboBoxClient.setSelectedIndex(PantallaMain.magatzem.getComandes().get(pos).client.idClient - 1);
				lblResBuscar.setText("Trobat");

				txtData.setText(sdf.format(PantallaMain.magatzem.getComandes().get(pos).dataComanda));
				txtLliurament.setText(sdf.format(PantallaMain.magatzem.getComandes().get(pos).dataLliurament));
				txtPorts.setText(Double.toString(PantallaMain.magatzem.getComandes().get(pos).portes));
				txtIdclient.setText(String.valueOf(PantallaMain.magatzem.getComandes().get(pos).client.idClient));
				//Marcamos el estado de la comanda
				if (PantallaMain.magatzem.getComandes().get(pos).estat == ComandaEstat.PENDENT) {
					// desmarco
					rdbtnLliurada.setSelected(false);
					rdbtnTransport.setSelected(false);
					rdbtnPreparada.setSelected(false);
					rdbtnPendent.setSelected(false);

					rdbtnLliurada.setEnabled(true);
					rdbtnTransport.setEnabled(true);
					rdbtnPreparada.setEnabled(true);
					rdbtnPreparada.setEnabled(true);

					rdbtnPendent.setSelected(true);
					rdbtnPendent.setEnabled(false);
					rdbtnLliurada.setEnabled(false);
					rdbtnTransport.setEnabled(false);
					rdbtnPreparada.setEnabled(false);
				}
				if (PantallaMain.magatzem.getComandes().get(pos).estat == ComandaEstat.LLIURADA) {
					// desmarco
					rdbtnLliurada.setSelected(false);
					rdbtnTransport.setSelected(false);
					rdbtnPreparada.setSelected(false);
					rdbtnPendent.setSelected(false);

					rdbtnLliurada.setEnabled(true);
					rdbtnTransport.setEnabled(true);
					rdbtnPreparada.setEnabled(true);
					rdbtnPreparada.setEnabled(true);

					rdbtnLliurada.setSelected(true);
					rdbtnLliurada.setEnabled(false);
					rdbtnPendent.setEnabled(false);
					rdbtnTransport.setEnabled(false);
					rdbtnPreparada.setEnabled(false);
				}
				if (PantallaMain.magatzem.getComandes().get(pos).estat == ComandaEstat.TRANSPORT) {
					// desmarco
					rdbtnLliurada.setSelected(false);
					rdbtnTransport.setSelected(false);
					rdbtnPreparada.setSelected(false);
					rdbtnPendent.setSelected(false);

					rdbtnLliurada.setEnabled(true);
					rdbtnTransport.setEnabled(true);
					rdbtnPreparada.setEnabled(true);
					rdbtnPreparada.setEnabled(true);

					rdbtnTransport.setSelected(true);
					rdbtnTransport.setEnabled(false);
					rdbtnLliurada.setEnabled(false);
					rdbtnPendent.setEnabled(false);
					rdbtnPreparada.setEnabled(false);
				}
				if (PantallaMain.magatzem.getComandes().get(pos).estat == ComandaEstat.PREPARADA) {
					// desmarco
					rdbtnLliurada.setSelected(false);
					rdbtnTransport.setSelected(false);
					rdbtnPreparada.setSelected(false);
					rdbtnPendent.setSelected(false);

					// habilito
					rdbtnLliurada.setEnabled(true);
					rdbtnTransport.setEnabled(true);
					rdbtnPreparada.setEnabled(true);
					rdbtnPendent.setEnabled(true);

					rdbtnPreparada.setSelected(true);
					rdbtnLliurada.setEnabled(false);
					rdbtnTransport.setEnabled(false);
					rdbtnPreparada.setEnabled(false);
					rdbtnPendent.setEnabled(false);
				}

				// bloqueo comanda
				txtLliurament.setEnabled(false);
				txtPorts.setEnabled(false);
				txtIdclient.setEnabled(false);
				txtData.setEnabled(false);
			} else {
				//Dejamos todo vacio en caso de no encontrar nada
				lblResBuscar.setText("No trobat");
				txtData.setText("");
				txtLliurament.setText("");
				txtPorts.setText("");
				txtIdclient.setText("");
				btnEsborrarComanda.setEnabled(false);
				btnEditarComanda.setEnabled(false);
				btnMas.setVisible(false);
				btnMenos.setVisible(false);
			}
		}

	

	}
	
	public void getIdMaxMin()
	{
		idMax = 0;
		idMin = Integer.MAX_VALUE;
		
		for(Comanda c : PantallaMain.magatzem.getComandes())
		{
			if(c.idComanda > idMax)
			{
				idMax = c.idComanda;
			}
			
			if(c.idComanda < idMin)
			{
				idMin = c.idComanda;
			}
		}
	}
}
