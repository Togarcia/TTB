package tastat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PantallaConsultas {

	public JFrame frame;	//private
	private JTable table;
	private JTextField campoID;
	private JTextField campoNombre;
	private JTextField campoPro;
	private ButtonGroup tipusProducte;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnVendible;
	private JRadioButton rdbtnIngredient;
	private JLabel lblNewLabel;
	private JLabel lblCodiProducte;
	private JLabel lblNewLabel_1;
	private JLabel lblProvedor;
	private JPanel panel;
	private JCheckBox chckbxNewCheckBox;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	
	//private Magatzem magatzem = new Magatzem();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaConsultas window = new PantallaConsultas();
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
	public PantallaConsultas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//magatzem = Programa.generaMagatzem();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//JFrame.EXIT_ON_CLOSE
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 1244, 331);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idProducte", "Nom Producte", "Descripcio Producte", "Preu Venda", "Stock Total", "Unitat Mesura", "Stock Min", "Prove\u00EFdor", "Tipus"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class, Integer.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(65);
		table.getColumnModel().getColumn(1).setPreferredWidth(189);
		table.getColumnModel().getColumn(2).setPreferredWidth(328);
		table.getColumnModel().getColumn(5).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Consulta de productes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(28, 11, 293, 44);
		frame.getContentPane().add(lblNewLabel);
		
		lblCodiProducte = new JLabel("Codi Producte:");
		lblCodiProducte.setBounds(38, 66, 98, 14);
		frame.getContentPane().add(lblCodiProducte);
		
		campoID = new JTextField();
		campoID.setBounds(135, 63, 86, 20);
		frame.getContentPane().add(campoID);
		campoID.setColumns(10);
		
		lblNewLabel_1 = new JLabel("nomProducte:");
		lblNewLabel_1.setBounds(260, 66, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(346, 63, 215, 20);
		frame.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);
		
		lblProvedor = new JLabel("Prove\u00EFdor:");
		lblProvedor.setBounds(38, 104, 80, 14);
		frame.getContentPane().add(lblProvedor);
		
		campoPro = new JTextField();
		campoPro.setBounds(105, 101, 196, 20);
		frame.getContentPane().add(campoPro);
		campoPro.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "TipusProducte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(613, 31, 121, 84);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Tots");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(6, 16, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnVendible = new JRadioButton("Vendibles");
		rdbtnVendible.setBounds(6, 35, 109, 23);
		panel.add(rdbtnVendible);
		
		rdbtnIngredient = new JRadioButton("Ingredients");
		rdbtnIngredient.setBounds(6, 54, 109, 23);
		panel.add(rdbtnIngredient);
		
		tipusProducte = new ButtonGroup();
		tipusProducte.add(rdbtnNewRadioButton);
		tipusProducte.add(rdbtnVendible);
		tipusProducte.add(rdbtnIngredient);
		
		chckbxNewCheckBox = new JCheckBox("Solament falta de Stock");
		chckbxNewCheckBox.setBounds(770, 32, 187, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		/*table.getModel().addTableModelListener(new TableModelListener(){
			
			DefaultTableModel tabla = (DefaultTableModel) table.getModel();
			
			@Override
				public void tableChanged(TableModelEvent arg0) {
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					
					if(row != -1 && column != -1)
					{
						String a = (String) tabla.getValueAt(row, column);
						
						tabla.setValueAt("0" + a, row, column);
						System.out.println(tabla.getValueAt(row, column));
					}
				}				
			}			
		);*/
		
		table.addMouseListener(new MouseAdapter() 
		{
		    public void mousePressed(MouseEvent mouseEvent) 
		    {
		    	DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		    	
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int row = table.rowAtPoint(point);
		        
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
		        {
		        	//JOptionPane.showMessageDialog(null, "Has clicado en el producto: " + tabla.getValueAt(row, 1));
		        	String s = (String) tabla.getValueAt(row, 1);
		        	//System.out.println(p);
		        	for(Producte p : PantallaMain.magatzem.getProductes())
		        	{
		        		if(p.getNomProducte().equals(s))
		        		{
		        			try {
		    					PantallaProducte pantallaProducte = new PantallaProducte(p);
		    					pantallaProducte.frame.setVisible(true);
		    				} catch (Exception e1) {
		    					e1.printStackTrace();
		    				}
		        		}
		        	}
		        }
		    }
		});
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Producte> lista = new ArrayList<Producte>();
				
				DefaultTableModel tabla = (DefaultTableModel) table.getModel();
				tabla.setRowCount(0);
				
				if(campoID.getText().length() > 0)
				{
					campoNombre.setText("");
					campoPro.setText("");
				}
				
				for(Producte p : PantallaMain.magatzem.getProductes())
				{
					int id = p.getCodiProducte();
					String nom = p.getNomProducte();
					String descripcio = "HUEVOS PAN";
					Double preu = p.getPreuVenda();
					int stockTotal = p.getStock();
					String unitat = p.getUnitatMesura().toString();
					int stockMinim = p.getStockMinim();
					Proveidor proveidor = p.getProveidor();
					String proveidor1 = "No té";
					
					if(proveidor != null)
					{
						proveidor1 = proveidor.getNomProveidor();
					}
					String tipus = p.getTipus().toString();
					
					boolean stock = calcularFaltaStock(p);
					
					if(chckbxNewCheckBox.isSelected())
					{
						if(stock)
						{
							if((campoID.getText().equals(String.valueOf(p.getCodiProducte()))) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))))
							{
								//Comprueba el codigo, boton todos y si es vendible
								tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
							}else
							{
								if(campoID.getText().equals(String.valueOf(p.getCodiProducte())) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))))
								{
									//Comprueba el codigo, boton todos y si es ingrediente
									tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
								}else
								{
									if(proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))) && campoNombre.getText().isEmpty() && campoID.getText().isEmpty())
									{
										//Comprueba el proveedor, boton todos y vendible, y que el nombre este vacio
										tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
									}else
									{
										if(proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) && campoNombre.getText().isEmpty() && campoID.getText().isEmpty())
										{
											//Comprueba el proveedor, boton todos y ingrediente, y que el nombre este vacio
											tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
										}else
										{
											if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))) && campoPro.getText().isEmpty() && campoID.getText().isEmpty())
											{
												//Comprueba nombre, boton todos y si es vendible, y campo proveidor este vacio
												tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
											}else
											{
												if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) && campoPro.getText().isEmpty() && campoID.getText().isEmpty())
												{
													//Comprueba nombre, boton todos y si es ingrediente, y campo proveidor este vacio
													tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
												}else
												{
													if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))) && campoID.getText().isEmpty())
													{
														//Comprueba nombre, proveidor, boton todos y si es vendible
														tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
													}else
													{
														if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) && campoID.getText().isEmpty())
														{
															//Comprueba nombre, proveidor, boton todos y si es ingredient
															tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
														}else
														{
															if(campoNombre.getText().isEmpty() && campoPro.getText().isEmpty() && campoID.getText().isEmpty() && (rdbtnNewRadioButton.isSelected() || ((rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) || ((rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE)))) && campoID.getText().isEmpty())
															{
																//Comprueba si todo esta vacio, por lo tanto solo hace caso a los botones
																tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
															}
														}													
													}
												}
											}
										}
									}
								}
							}
						}
					}else
					{
						if((campoID.getText().equals(String.valueOf(p.getCodiProducte()))) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))))
						{
							//Comprueba el codigo, boton todos y si es vendible
							tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
						}else
						{
							if(campoID.getText().equals(String.valueOf(p.getCodiProducte())) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))))
							{
								//Comprueba el codigo, boton todos y si es ingrediente
								tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
							}else
							{
								if(proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))) && campoNombre.getText().isEmpty() && campoID.getText().isEmpty())
								{
									//Comprueba el proveedor, boton todos y vendible, y que el nombre este vacio
									tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
								}else
								{
									if(proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) && campoNombre.getText().isEmpty() && campoID.getText().isEmpty())
									{
										//Comprueba el proveedor, boton todos y ingrediente, y que el nombre este vacio
										tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
									}else
									{
										if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))) && campoPro.getText().isEmpty() && campoID.getText().isEmpty())
										{
											//Comprueba nombre, boton todos y si es vendible, y campo proveidor este vacio
											tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
										}else
										{
											if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) && campoPro.getText().isEmpty() && campoID.getText().isEmpty())
											{
												//Comprueba nombre, boton todos y si es ingrediente, y campo proveidor este vacio
												tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
											}else
											{
												if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE))) && campoID.getText().isEmpty())
												{
													//Comprueba nombre, proveidor, boton todos y si es vendible
													tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
												}else
												{
													if(p.getNomProducte().toUpperCase().contains(campoNombre.getText().toUpperCase()) && proveidor1.toUpperCase().contains(campoPro.getText().toUpperCase()) && (rdbtnNewRadioButton.isSelected() || (rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) && campoID.getText().isEmpty())
													{
														//Comprueba nombre, proveidor, boton todos y si es ingredient
														tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
													}else
													{
														if(campoNombre.getText().isEmpty() && campoPro.getText().isEmpty() && campoID.getText().isEmpty() && (rdbtnNewRadioButton.isSelected() || ((rdbtnIngredient.isSelected() && p.getTipus().equals(Tipus.INGREDIENT))) || ((rdbtnVendible.isSelected() && p.getTipus().equals(Tipus.VENDIBLE)))) && campoID.getText().isEmpty())
														{
															//Comprueba si todo esta vacio, por lo tanto solo hace caso a los botones
															tabla.addRow(new Object[] {id, nom, descripcio, preu, stockTotal, unitat, stockMinim, proveidor1, tipus});
														}
													}													
												}
											}
										}
									}
								}
							}
						}
					}					
				}
			}
		});
		btnNewButton.setBounds(1001, 32, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
	public boolean calcularFaltaStock(Producte p)
	{
		if(p.getStock() < p.getStockMinim())
		{
			return true;
		}else
		{
			return false;
		}
		
		
	}
}
