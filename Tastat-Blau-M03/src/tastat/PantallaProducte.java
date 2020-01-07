package tastat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PantallaProducte {

	public JFrame frame; //private
	private JTextField txtidProducte;
	private JTextField txtNom;
	private JTextField txtStock;
	private JLabel lblStock;
	private JLabel lblStockMinim;
	private JTextField txtStockMinim;
	private JLabel lblPreuVenda;
	private JTextField txtPreuVenda;
	private JLabel lblProveidor;
	private JTextField txtProveidor;
	private JPanel ptipusProducte;
	private JRadioButton bLlitre;
	private JRadioButton bGram;
	private JRadioButton bUnitat;
	private JPanel pUnitatMesura;
	private JButton bConfirmar;
	private JButton bCrear;
	private JButton bBuscar;
	private JLabel lblExisteix;
	private JButton bModificar;
	private JButton bEliminar;
	private JLabel lblComposicio;
	private JLabel lblLots;
	private JRadioButton bVendible;
	private JButton bPrev;
	private JLabel lblidProducte;
	private JButton bNext;
	private JLabel lblNom;
	private JRadioButton bIngredient;
	private JButton bCancelar;
	private JComboBox<String> cbProducteC;
	private JButton bAfegirC;
	private JButton bEliminarC;
	private JComboBox<String> cbEliminarC;
	private JTable tableComposicio;
	private JTable tableLots;
	private JTextField txtProducteQC;
	private JButton bEliminarL;
	private JComboBox<String> cbEliminarL;
	private JTextField txtNumLots;
	private JTextField txtQuantitatPerLot;
	private JButton bAfegirL;
	
	//-----------------
	ButtonGroup tipus;
	ButtonGroup mesura;
	DefaultTableModel taulaComposicio;
	DefaultTableModel taulaLots;
	
	/*VARIABLES*/
	//int posicio = 0;	//Posicion del arraylist del producto que buscamos
	int idNP; //ID Producte para Next y Previous
	int idMax;
	int idMin;
	
	boolean crear = false;
	boolean modificar = false;
	
	//private Magatzem magatzem = new Magatzem();
	
	//Producte Pbackup = null;
	Producte Pcrear = null;
	Producte Pmodificar = null;
	Producte Pbackup = null;
	//List<Producte> Pbackup = null;
	Map<Producte, Integer> Pcomposicio = null;	
	List <LotDesglossat> Plots = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaProducte window = new PantallaProducte();
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
	public PantallaProducte() {
		initialize();
	}
	
	//PANTALLA PRODUCTE CON UN VALOR INICIAL
	public PantallaProducte(Producte p)
	{
		initialize();
		informacioProducte(p);
		getIdMaxMin();
		idNP = p.getCodiProducte();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*magatzem = Programa.generaMagatzem();
		System.out.println(magatzem);*/
		
		//-----------------------------
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//JFrame.EXIT_ON_CLOSE
		frame.getContentPane().setLayout(null);
		
		lblidProducte = new JLabel("ID Producte:");
		lblidProducte.setBounds(10, 11, 79, 14);
		frame.getContentPane().add(lblidProducte);
		
		txtidProducte = new JTextField();
		txtidProducte.setHorizontalAlignment(SwingConstants.LEFT);
		txtidProducte.setBounds(86, 8, 127, 20);
		frame.getContentPane().add(txtidProducte);
		txtidProducte.setColumns(10);
		
		bPrev = new JButton("\u2190");
		//BOTON MOVIDO
		
		bBuscar = new JButton("Buscar");
		//BOTON MOVIDO
		
		bBuscar.setBounds(214, 7, 89, 21);
		frame.getContentPane().add(bBuscar);
		bPrev.setBounds(303, 7, 46, 21);
		frame.getContentPane().add(bPrev);
		
		bNext = new JButton("\u2192");
		//BOTON MOVIDO
		
		bNext.setBounds(347, 7, 46, 21);
		frame.getContentPane().add(bNext);
		
		lblNom = new JLabel("Nom:");
		lblNom.setBounds(10, 39, 79, 14);
		frame.getContentPane().add(lblNom);
		
		lblExisteix = new JLabel("");
		lblExisteix.setBounds(313, 39, 230, 14);
		frame.getContentPane().add(lblExisteix);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setBounds(86, 36, 215, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 80, 79, 14);
		frame.getContentPane().add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setHorizontalAlignment(SwingConstants.RIGHT);
		txtStock.setColumns(10);
		txtStock.setBounds(88, 77, 110, 20);
		frame.getContentPane().add(txtStock);
		
		lblStockMinim = new JLabel("Stock M\u00EDnim:");
		lblStockMinim.setBounds(10, 108, 79, 14);
		frame.getContentPane().add(lblStockMinim);
		
		txtStockMinim = new JTextField();
		txtStockMinim.setEditable(false);
		txtStockMinim.setHorizontalAlignment(SwingConstants.RIGHT);
		txtStockMinim.setColumns(10);
		txtStockMinim.setBounds(88, 105, 110, 20);
		frame.getContentPane().add(txtStockMinim);
		
		lblPreuVenda = new JLabel("Preu Venda:");
		lblPreuVenda.setBounds(207, 80, 79, 14);
		frame.getContentPane().add(lblPreuVenda);
		
		txtPreuVenda = new JTextField();
		txtPreuVenda.setEditable(false);
		txtPreuVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPreuVenda.setColumns(10);
		txtPreuVenda.setBounds(283, 77, 110, 20);
		frame.getContentPane().add(txtPreuVenda);
		
		lblProveidor = new JLabel("Proveidor:");
		lblProveidor.setBounds(208, 108, 79, 14);
		frame.getContentPane().add(lblProveidor);
		
		txtProveidor = new JTextField();
		txtProveidor.setEditable(false);
		txtProveidor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtProveidor.setColumns(10);
		txtProveidor.setBounds(283, 105, 110, 20);
		frame.getContentPane().add(txtProveidor);
		
		ptipusProducte = new JPanel();
		ptipusProducte.setToolTipText("");
		ptipusProducte.setBorder(new TitledBorder(null, "Tipus de producte:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ptipusProducte.setBounds(10, 147, 121, 72);
		frame.getContentPane().add(ptipusProducte);
		ptipusProducte.setLayout(null);
		
		bVendible = new JRadioButton("Vendible");
		bVendible.setEnabled(false);
		bVendible.setBounds(6, 16, 109, 23);
		ptipusProducte.add(bVendible);
		
		bIngredient = new JRadioButton("Ingredient");
		bIngredient.setBounds(6, 42, 109, 23);
		ptipusProducte.add(bIngredient);
		
		pUnitatMesura = new JPanel();
		pUnitatMesura.setBorder(new TitledBorder(null, "Unitat de mesura:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pUnitatMesura.setBounds(141, 147, 121, 98);
		frame.getContentPane().add(pUnitatMesura);
		pUnitatMesura.setLayout(null);
		
		bLlitre = new JRadioButton("Llitre");
		bLlitre.setBounds(6, 16, 109, 23);
		pUnitatMesura.add(bLlitre);
		
		bGram = new JRadioButton("Gram");
		bGram.setBounds(6, 42, 109, 23);
		pUnitatMesura.add(bGram);
		
		bUnitat = new JRadioButton("Unitat");
		bUnitat.setBounds(6, 68, 109, 23);
		pUnitatMesura.add(bUnitat);
		
		bCrear = new JButton("Crear");
		//BOTON MOVIDO
		
		bCrear.setBounds(10, 280, 91, 23);
		frame.getContentPane().add(bCrear);
		
		bModificar = new JButton("Modificar");
		//BOTON MOVIDO
		
		bModificar.setBounds(109, 280, 91, 23);
		frame.getContentPane().add(bModificar);
		
		bEliminar = new JButton("Eliminar");
		//BOTON MOVIDO
		
		bEliminar.setBounds(206, 280, 91, 23);
		frame.getContentPane().add(bEliminar);
		
		bConfirmar = new JButton("Confirmar");
		//BOTON MOVIDO
		
		bConfirmar.setBounds(10, 310, 91, 23);
		frame.getContentPane().add(bConfirmar);
		
		bCancelar = new JButton("Cancelar");
		//BOTON MOVIDO
		bCancelar.setBounds(206, 314, 91, 23);
		frame.getContentPane().add(bCancelar);
		
		lblComposicio = new JLabel("Composici\u00F3:");
		lblComposicio.setBounds(553, 11, 193, 14);
		frame.getContentPane().add(lblComposicio);
		
		lblLots = new JLabel("Lots:");
		lblLots.setBounds(553, 321, 193, 14);
		frame.getContentPane().add(lblLots);
		
		//BUTTONGROUP TIPUS
		tipus = new ButtonGroup();
		tipus.add(bVendible);
		tipus.add(bIngredient);
		
		//BUTTONGROUP MESURA
		mesura = new ButtonGroup();
		mesura.add(bLlitre);
		mesura.add(bGram);
		mesura.add(bUnitat);
		
		JScrollPane scrollComposicio = new JScrollPane();
		scrollComposicio.setBounds(553, 39, 626, 234);
		frame.getContentPane().add(scrollComposicio);
		
		tableComposicio = new JTable();
		tableComposicio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Component", "Nom Producte", "Quantitat"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableComposicio.getColumnModel().getColumn(0).setPreferredWidth(101);
		tableComposicio.getColumnModel().getColumn(1).setPreferredWidth(216);
		tableComposicio.getColumnModel().getColumn(2).setPreferredWidth(116);
		scrollComposicio.setViewportView(tableComposicio);
		
		JScrollPane scrollLots = new JScrollPane();
		scrollLots.setBounds(553, 351, 626, 241);
		frame.getContentPane().add(scrollLots);
		
		tableLots = new JTable();
		tableLots.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Lot", "Data Entrada", "Data caducitat", "Quantitat"
			}
		));
		tableLots.getColumnModel().getColumn(1).setPreferredWidth(124);
		tableLots.getColumnModel().getColumn(2).setPreferredWidth(127);
		tableLots.getColumnModel().getColumn(3).setPreferredWidth(123);
		scrollLots.setViewportView(tableLots);
		
		cbProducteC = new JComboBox<>();
		cbProducteC.setBounds(553, 286, 143, 22);
		frame.getContentPane().add(cbProducteC);
		
		txtProducteQC = new JTextField();
		txtProducteQC.setBounds(708, 286, 116, 22);
		frame.getContentPane().add(txtProducteQC);
		txtProducteQC.setColumns(10);
		
		bAfegirC = new JButton("Afegir");
		//BOTON MOVIDO
		bAfegirC.setBounds(835, 286, 91, 23);
		frame.getContentPane().add(bAfegirC);
		
		bEliminarC = new JButton("Eliminar");
		//BOTON MOVIDO
		bEliminarC.setBounds(936, 286, 91, 23);
		frame.getContentPane().add(bEliminarC);
		
		cbEliminarC = new JComboBox<>();
		cbEliminarC.setBounds(1036, 286, 143, 22);
		frame.getContentPane().add(cbEliminarC);
		
		bEliminarL = new JButton("Eliminar");
		//BOTON MOVIDO
		bEliminarL.setBounds(936, 605, 91, 23);
		frame.getContentPane().add(bEliminarL);
		
		cbEliminarL = new JComboBox<String>();
		cbEliminarL.setBounds(1036, 605, 143, 22);
		frame.getContentPane().add(cbEliminarL);
		
		txtNumLots = new JTextField();
		txtNumLots.setColumns(10);
		txtNumLots.setBounds(553, 605, 116, 22);
		frame.getContentPane().add(txtNumLots);
		
		txtQuantitatPerLot = new JTextField();
		txtQuantitatPerLot.setColumns(10);
		txtQuantitatPerLot.setBounds(681, 605, 116, 22);
		frame.getContentPane().add(txtQuantitatPerLot);
		
		bAfegirL = new JButton("Afegir");
		//BOTON MOVIDO
		bAfegirL.setBounds(809, 605, 91, 23);
		frame.getContentPane().add(bAfegirL);
		
		//EDITABLE FALSE
		editableFalse();
		
		//ESCONDEMOS BOTONES INNECESARIOS AL INICIO
		/*bCrear.setEnabled(true);
		bConfirmar.setEnabled(false);
		bModificar.setEnabled(false);
		bEliminar.setEnabled(false);
		bCancelar.setEnabled(false);*/
		
		//Pbackup = PantallaMain.magatzem.getProductes();	//
		
		//BOTONES
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trobat = false;
				Producte paux = null;
				
				//VACIAR
				vaciar();
				
				//COGEMOS ID MAXIMO Y MINIMO
				getIdMaxMin();
				
				if(txtidProducte.getText().isEmpty())
				{
					//lblExisteix.setText("Valor incorrecte");
				}
				else
				{
					for(Producte p : PantallaMain.magatzem.getProductes())
					{
						if(txtidProducte.getText().equals(String.valueOf(p.getCodiProducte())))
						{
							trobat = true;
							paux = p;
							
							idNP = paux.getCodiProducte();
							//posicio arraylist
							//posicio = magatzem.getProductes().indexOf(p);
						}
						
					}
					
					if(trobat == true)
					{
						informacioProducte(paux);
					}
					else
					{
						lblExisteix.setText("No existeix");
					}
				}
			}
		});
		
		
		bPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtidProducte.getText().isEmpty() || !lblExisteix.getText().isEmpty() || idNP == idMin)
				{
					getIdMaxMin();
					
					idNP = idMax;
					idNP++;
				}
				
				if(idNP >= idMin)
				{	
					Producte paux = null;
					
					do
					{
						idNP--;
						
						for(Producte pr : PantallaMain.magatzem.getProductes())
						{
							if(pr.getCodiProducte() == idNP)
							{
								vaciar();
								informacioProducte(pr);
								
								//PRUEBA
								paux = pr;
							}
						}
					}while(paux == null);
					
					/*idNP--;
					
					for(Producte pr : magatzem.getProductes())
					{
						if(pr.getCodiProducte() == idNP)
						{
							informacioProducte(pr);
						}
					}*/
				}
				
				/*if(posicio - 1 >= 0)
				{
					Producte p = magatzem.getProductes().get(posicio - 1);
					
					informacioProducte(p);
					
					posicio--;
				}*/
			}
		});
		
		bNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtidProducte.getText().isEmpty() || !lblExisteix.getText().isEmpty() || idNP == idMax)
				{
					getIdMaxMin();
					
					idNP = idMin;
					idNP--;
				}
				
				if(idNP <= idMax)
				{	
					Producte paux = null;
					
					do
					{
						idNP++;
						
						for(Producte pr : PantallaMain.magatzem.getProductes())
						{
							if(pr.getCodiProducte() == idNP)
							{
								vaciar();
								informacioProducte(pr);
								
								//PRUEBA
								paux = pr;
							}
						}
					}while(paux == null);
					
					/*idNP++;
					
					for(Producte pr : magatzem.getProductes())
					{
						if(pr.getCodiProducte() == idNP)
						{
							informacioProducte(pr);
						}
					}*/
				}
				
				/*if(posicio == 0)
				{
					Producte p = magatzem.getProductes().get(posicio);
					
					informacioProducte(p);
					
					posicio++;
				}
				else
				{
					if(posicio + 1 < magatzem.getProductes().size())
					{
						Producte p = magatzem.getProductes().get(posicio + 1);
						
						informacioProducte(p);
						
						posicio++;
					}
				}*/
			}
		});
		
		bCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VACIAR
				vaciar();
				
				//EDITABLE TRUE
				editableTrue();
				
				//txtidProducte.setText("");
				txtidProducte.setEditable(false);
				
				//crear = true;	//
				Pcrear = new Producte();
				txtidProducte.setText(String.valueOf(Pcrear.getCodiProducte()));
				
				//TABLE COMPOSICIO COMPONENTS
				for(Producte p : PantallaMain.magatzem.getProductes())
				{
					if(p.getTipus() == Tipus.INGREDIENT)
					{
						cbProducteC.addItem(p.getNomProducte());
					}
				}
			}
		});
		
		bModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtidProducte.getText().isEmpty())
				{
					editableTrue();
					
					txtidProducte.setEditable(false);
					
					//modificar = true;	//
					//Pmodificar = new Producte();
					for(Producte p : PantallaMain.magatzem.getProductes())
					{
						if(p.getCodiProducte() == Integer.parseInt(txtidProducte.getText()))
						{
							//Pmodificar = p;
							Pmodificar = new Producte(p);
							//Pbackup = p;	//
							
							Pbackup = new Producte(p);
							Pcomposicio = new HashMap<>(Pbackup.getComposicio());
							//Pcomposicio = Pbackup.getComposicio();
							Plots = new ArrayList<>(Pbackup.lots);
							//Plots = Pbackup.lots;
							System.out.println(Pbackup.getComposicio() + " //////" + Pbackup.lots);
							System.out.println(Pmodificar.getComposicio() + " //////" + Pmodificar.lots);
							System.out.println(Pmodificar.equals(Pbackup));
						}
					}
				}
			}
		});
		
		bEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtidProducte.getText().isEmpty())
				{
					Producte paux = new Producte();
					
					for(Producte p : PantallaMain.magatzem.getProductes())
					{
						if(p.getCodiProducte() == Integer.parseInt(txtidProducte.getText()))
						{
							paux = p;
						}
					}
					
					PantallaMain.magatzem.getProductes().remove(paux);
					
					vaciar();
					
					lblExisteix.setText(paux.getNomProducte() + " eliminat");
					txtidProducte.setText("");
					//System.out.println(magatzem.toString());
					
					//PRUEBA
					idNP = 0;
					getIdMaxMin();	//
				}
			}
		});
		
		bConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Pcrear != null && Pmodificar == null)	//CREAR
				{
					if(!txtNom.getText().isEmpty() && !txtStock.getText().isEmpty() && !txtStockMinim.getText().isEmpty() && !txtPreuVenda.getText().isEmpty() && /*!txtProveidor.getText().isEmpty() &&*/ (bVendible.isSelected() || bIngredient.isSelected()) && (bLlitre.isSelected() || bGram.isSelected() || bUnitat.isSelected()))
						{
							Pcrear.setNomProducte(txtNom.getText());
							Pcrear.setStock(Integer.parseInt(txtStock.getText()));
							Pcrear.setStockMinim(Integer.parseInt(txtStockMinim.getText()));
							Pcrear.setProveidor(new Proveidor(txtProveidor.getText()));
							Pcrear.setPreuVenda(Double.parseDouble(txtPreuVenda.getText()));
							
							if(bVendible.isSelected())
							{
								Pcrear.setTipus(Tipus.VENDIBLE);
							}
							else
							{
								Pcrear.setTipus(Tipus.INGREDIENT);
							}
							
							if(bLlitre.isSelected())
							{
								Pcrear.setUnitatMesura(UnitatMesura.LLITRE);
							}
							else
							{
								if(bGram.isSelected())
								{
									Pcrear.setUnitatMesura(UnitatMesura.GRAMS);
								}
								else
								{
									Pcrear.setUnitatMesura(UnitatMesura.UNITAT);
								}
							}
							
							//COMPOSICIO I LOTS S'AFEGEIXEN A Pcrear EN EL BOTONS
							
							PantallaMain.magatzem.add(Pcrear);
							
							vaciar();
							editableFalse();
							lblExisteix.setText(Pcrear.getNomProducte() + " creat");
							txtidProducte.setEditable(true);
							
							Pcrear = null;
							
							idNP = 0;
							getIdMaxMin();	//
							//Pbackup = PantallaMain.magatzem.getProductes();	//
						}
						else
						{
							lblExisteix.setText("Falten camps");
						}
						
						/*Pcrear = null;
						System.out.println("creado");*/
				}
				else
				{
					if(Pcrear == null && Pmodificar != null)	//MODIFICAR
					{
						if(!txtNom.getText().isEmpty() && !txtStock.getText().isEmpty() && !txtStockMinim.getText().isEmpty() && !txtPreuVenda.getText().isEmpty() && /*!txtProveidor.getText().isEmpty() &&*/ (bVendible.isSelected() || bIngredient.isSelected()) && (bLlitre.isSelected() || bGram.isSelected() || bUnitat.isSelected()))
						{
							Producte p = null;
							int codiProducte = 0;
							int index = 0;
							
							for(Producte pr : PantallaMain.magatzem.getProductes())
							{
								if(pr.getCodiProducte() == Integer.parseInt(txtidProducte.getText()))
								{
									p = pr;
									index = PantallaMain.magatzem.getProductes().indexOf(pr);
									codiProducte = pr.getCodiProducte();
								}
							}
							
							PantallaMain.magatzem.getProductes().remove(p);
							
							Pmodificar.codiProducte = codiProducte;
							
							Pmodificar.setNomProducte(txtNom.getText());
							Pmodificar.setStock(Integer.parseInt(txtStock.getText()));
							Pmodificar.setStockMinim(Integer.parseInt(txtStockMinim.getText()));
							Pmodificar.setProveidor(new Proveidor(txtProveidor.getText()));
							Pmodificar.setPreuVenda(Double.parseDouble(txtPreuVenda.getText()));
							
							
							if(bVendible.isSelected())
							{
								Pmodificar.setTipus(Tipus.VENDIBLE);
							}
							else
							{
								Pmodificar.setTipus(Tipus.INGREDIENT);
							}
							
							if(bLlitre.isSelected())
							{
								Pmodificar.setUnitatMesura(UnitatMesura.LLITRE);
							}
							else
							{
								if(bGram.isSelected())
								{
									Pmodificar.setUnitatMesura(UnitatMesura.GRAMS);
								}
								else
								{
									Pmodificar.setUnitatMesura(UnitatMesura.UNITAT);
								}
							}
							
							//COMPOSICIO I LOTS S'AFEGEIXEN A Pmodificar EN EL BOTONS
							
							//magatzem.add(p);
							PantallaMain.magatzem.getProductes().add(index, Pmodificar);
							
							//vaciar();
							editableFalse();
							lblExisteix.setText(p.getNomProducte() + " modificat");
							txtidProducte.setEditable(true);
							
							Pmodificar = null;
							
							idNP = 0;
							getIdMaxMin();	//
							//Pbackup = PantallaMain.magatzem.getProductes();	//
						}
						else
						{
							lblExisteix.setText("Falten camps");
						}
						
						//modificar = false;
						/*Pmodificar = null;
						System.out.println("modificado");*/
					}
				}
				
				/*if(crear == true && modificar == false)
				{
					if(!txtNom.getText().isEmpty() && !txtStock.getText().isEmpty() && !txtStockMinim.getText().isEmpty() && !txtPreuVenda.getText().isEmpty() && /*!txtProveidor.getText().isEmpty() && (bVendible.isSelected() || bIngredient.isSelected()) && (bLlitre.isSelected() || bGram.isSelected() || bUnitat.isSelected()))
					{
						Producte p = new Producte();
						
						p.setNomProducte(txtNom.getText());
						p.setStock(Integer.parseInt(txtStock.getText()));
						p.setStockMinim(Integer.parseInt(txtStockMinim.getText()));
						p.setProveidor(new Proveidor(txtProveidor.getText()));
						p.setPreuVenda(Double.parseDouble(txtPreuVenda.getText()));
						
						if(bVendible.isSelected())
						{
							p.setTipus(Tipus.VENDIBLE);
						}
						else
						{
							p.setTipus(Tipus.INGREDIENT);
						}
						
						if(bLlitre.isSelected())
						{
							p.setUnitatMesura(UnitatMesura.LLITRE);
						}
						else
						{
							if(bGram.isSelected())
							{
								p.setUnitatMesura(UnitatMesura.GRAMS);
							}
							else
							{
								p.setUnitatMesura(UnitatMesura.UNITAT);
							}
						}
						
						magatzem.add(p);
						
						vaciar();
						editableFalse();
						lblExisteix.setText(p.getNomProducte() + " creat");
						txtidProducte.setEditable(true);
					}
					else
					{
						lblExisteix.setText("Falten camps");
					}
					
					//crear = false;
				}
				
				if(modificar = true && crear == false)
				{
					if(!txtNom.getText().isEmpty() && !txtStock.getText().isEmpty() && !txtStockMinim.getText().isEmpty() && !txtPreuVenda.getText().isEmpty() && /*!txtProveidor.getText().isEmpty() && (bVendible.isSelected() || bIngredient.isSelected()) && (bLlitre.isSelected() || bGram.isSelected() || bUnitat.isSelected()))
					{
						Producte p = null;
						int codiProducte = 0;
						
						for(Producte pr : magatzem.getProductes())
						{
							if(pr.getCodiProducte() == Integer.parseInt(txtidProducte.getText()))
							{
								p = pr;
								codiProducte = pr.getCodiProducte();
							}
						}
						
						magatzem.getProductes().remove(p);
						
						p = new Producte();
						
						p.codiProducte = codiProducte;
						
						p.setNomProducte(txtNom.getText());
						p.setStock(Integer.parseInt(txtStock.getText()));
						p.setStockMinim(Integer.parseInt(txtStockMinim.getText()));
						p.setProveidor(new Proveidor(txtProveidor.getText()));
						p.setPreuVenda(Double.parseDouble(txtPreuVenda.getText()));
						
						
						if(bVendible.isSelected())
						{
							p.setTipus(Tipus.VENDIBLE);
						}
						else
						{
							p.setTipus(Tipus.INGREDIENT);
						}
						
						if(bLlitre.isSelected())
						{
							p.setUnitatMesura(UnitatMesura.LLITRE);
						}
						else
						{
							if(bGram.isSelected())
							{
								p.setUnitatMesura(UnitatMesura.GRAMS);
							}
							else
							{
								p.setUnitatMesura(UnitatMesura.UNITAT);
							}
						}
						
						magatzem.add(p);
						
						//vaciar();
						editableFalse();
						//lblExisteix.setText(p.getNomProducte() + " creat");
						txtidProducte.setEditable(true);
					}
					else
					{
						lblExisteix.setText("Falten camps");
					}
					
					//modificar = false;
				}*/
			}
		});
		
		bCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vaciar();
				vaciarTaules();	//
				editableFalse();
				
				txtidProducte.setText("");
				txtidProducte.setEditable(true);
				
				//
				if(Pbackup != null && Pmodificar != null && Pcrear == null)
				{
					//System.out.println(Pbackup.getComposicio() + " //////" + Pbackup.lots);
					//System.out.println(Pmodificar.getComposicio() + " //////" + Pmodificar.lots);
					PantallaMain.magatzem.getProductes().remove(Pmodificar);
					/*Producte eliminar = null;
					
					for(Producte p : PantallaMain.magatzem.getProductes())
					{
						if(p.getCodiProducte() == Pmodificar.getCodiProducte())
						{
							eliminar = p;
						}
					}
					PantallaMain.magatzem.getProductes().remove(eliminar);*/
					Pbackup.composicio = Pcomposicio;
					Pbackup.lots = Plots;
					
					PantallaMain.magatzem.getProductes().add(Pbackup);
				}
				
				Pbackup = null;
				
				/*Producte eliminar = null;
				Producte afegir = null;
				
				if(Pmodificar != null && Pcrear == null)	//MODIFICANDO
				{
					for(Producte p : PantallaMain.magatzem.getProductes())
					{
						if(p.getCodiProducte() == Pmodificar.getCodiProducte())
						{
							eliminar = p;
						}
					}
					
					for(Producte p : Pbackup)
					{
						if(p.getCodiProducte() == eliminar.getCodiProducte())
						{
							afegir = p;
						}
					}
					
					if(eliminar != null)
					{
						PantallaMain.magatzem.getProductes().remove(eliminar);
						PantallaMain.magatzem.getProductes().add(afegir);
					}
				}*/
				
				//VACIAR PRODUCTES AUXILIARS
				Pcrear = null;
				Pmodificar = null;
				
				idNP = 0;
				getIdMaxMin();	//
			}
		});
		
		bAfegirC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Pcrear != null && Pmodificar == null)	//CREAR
				{
					Producte afegir = null;
					
					String nom = (String) cbProducteC.getSelectedItem();
					
					for(Producte producte : PantallaMain.magatzem.getProductes())
					{
						if(producte.getNomProducte().equals(nom))
						{
							afegir = producte;
						}
					}
					
					Pcrear.getComposicio().put(afegir, Integer.valueOf(txtProducteQC.getText()));
					
					//vaciar();
					//informacioProducte(Pcrear);
					vaciarTaules();
					informacioTaules(Pcrear);
					
					txtProducteQC.setText("");
				}
				else
				{
					if(Pcrear == null && Pmodificar != null)	//MODIFICAR
					{
						Producte afegir = null;
						
						String nom = (String) cbProducteC.getSelectedItem();
						
						for(Producte producte : PantallaMain.magatzem.getProductes())
						{
							if(producte.getNomProducte().equals(nom))
							{
								afegir = producte;
							}
						}
						
						Pmodificar.getComposicio().put(afegir, Integer.valueOf(txtProducteQC.getText()));
						
						//vaciar();
						//informacioProducte(Pmodificar);
						vaciarTaules();
						informacioTaules(Pmodificar);
						
						txtProducteQC.setText("");
						
						//System.out.println(Pbackup.getComposicio() + " //////" + Pbackup.lots);
					}
				}
				
				/*if(!txtProducteQC.getText().isEmpty())
				{
					Producte buscado = null;
					Producte afegir = null;
					
					String nom = (String) cbProducteC.getSelectedItem();
					
					for(Producte producte : magatzem.getProductes())
					{
						if(producte.getNomProducte().equals(nom))
						{
							afegir = producte;
						}
						
						if(producte.getNomProducte().equals(txtNom.getText()))
						{
							buscado = producte;
						}
					}
					
					buscado.getComposicio().put(afegir, Integer.valueOf(txtProducteQC.getText()));
										
					/*System.out.println(afegir.toString());
					System.out.println(txtProducteQC.getText());
					System.out.println(buscado.toString());
					
					vaciar();
					informacioProducte(buscado);
				}*/
			}
		});
		
		bEliminarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Pcrear != null && Pmodificar == null)	//CREAR
				{
					Producte eliminar = null;
					
					String nom = (String) cbEliminarC.getSelectedItem();
					
					for(Producte producte : PantallaMain.magatzem.getProductes())
					{
						if(producte.getNomProducte().equals(nom))
						{
							eliminar = producte;
						}
					}
					
					Pcrear.getComposicio().remove(eliminar);
					
					//vaciar();
					//informacioProducte(Pcrear);
					vaciarTaules();
					informacioTaules(Pcrear);
				}
				else
				{
					if(Pcrear == null && Pmodificar != null)	//MODIFICAR
					{
						Producte eliminar = null;
						
						String nom = (String) cbEliminarC.getSelectedItem();
						
						for(Producte producte : PantallaMain.magatzem.getProductes())
						{
							if(producte.getNomProducte().equals(nom))
							{
								eliminar = producte;
							}
						}
						
						Pmodificar.getComposicio().remove(eliminar);
						
						//vaciar();
						//informacioProducte(Pmodificar);
						vaciarTaules();
						informacioTaules(Pmodificar);
						
						//System.out.println(Pbackup.getComposicio() + " //////" + Pbackup.lots);
					}
				}
				
				/*Producte eliminar = null;
				Producte buscado = null;
				
				String nom = (String) cbEliminarC.getSelectedItem();
				
				for(Producte producte : magatzem.getProductes())
				{
					if(producte.getNomProducte().equals(nom))
					{
						eliminar = producte;
					}
					
					if(producte.getNomProducte().equals(txtNom.getText()))
					{
						buscado = producte;
					}
				}
				
				/*if(buscado.getComposicio().remove(eliminar) != null)
				{
					vaciar();
					informacioProducte(buscado);
				}
				buscado.getComposicio().remove(eliminar);
				
				vaciar();
				informacioProducte(buscado);*/
			}
		});
		
		bAfegirL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Pcrear != null && Pmodificar == null)	//CREAR
				{
					Random R = new Random();
					Date dataCaducitat;
					
					/*for(Producte producte : magatzem.getProductes())
					{
						if(producte.getNomProducte().equals(txtNom.getText()))
						{
							Pcrear = producte;
						}
					}*/
					
					for(int i = 0; i < Integer.parseInt(txtNumLots.getText()); i++)
					{
						dataCaducitat = Tools.sumarDies(new Date(), R.nextInt(30 - 10) + 10); //DE 10 a 30
						
						Pcrear.afegirLot(Integer.valueOf(txtQuantitatPerLot.getText()), dataCaducitat);
					}
					
					//vaciar();
					//informacioProducte(Pcrear);
					vaciarTaules();
					informacioTaules(Pcrear);
					
					txtNumLots.setText("");
					txtQuantitatPerLot.setText("");
				}
				else
				{
					if(Pcrear == null && Pmodificar != null)	//MODIFICAR
					{
						Random R = new Random();
						Date dataCaducitat;
						
						/*for(Producte producte : magatzem.getProductes())
						{
							if(producte.getNomProducte().equals(txtNom.getText()))
							{
								Pcrear = producte;
							}
						}*/
						
						for(int i = 0; i < Integer.parseInt(txtNumLots.getText()); i++)
						{
							dataCaducitat = Tools.sumarDies(new Date(), R.nextInt(30 - 10) + 10); //DE 10 a 30
							
							Pmodificar.afegirLot(Integer.valueOf(txtQuantitatPerLot.getText()), dataCaducitat);
						}
						
						//vaciar();
						//informacioProducte(Pmodificar);
						vaciarTaules();
						informacioTaules(Pmodificar);
						
						//System.out.println(Pbackup.getComposicio() + " //////" + Pbackup.lots);
					}
				}
				
				/*Random R = new Random();
				Date dataCaducitat;
				
				Producte buscado = null;
				
				for(Producte producte : magatzem.getProductes())
				{
					if(producte.getNomProducte().equals(txtNom.getText()))
					{
						buscado = producte;
					}
				}
				
				for(int i = 0; i < Integer.parseInt(txtNumLots.getText()); i++)
				{
					dataCaducitat = Tools.sumarDies(new Date(), R.nextInt(30 - 10) + 10); //DE 10 a 30
					
					buscado.afegirLot(Integer.valueOf(txtQuantitatPerLot.getText()), dataCaducitat);
				}
				
				vaciar();
				informacioProducte(buscado);*/
				
				//TOOLTIP TEXT - POR HACER - EN EL INITIALIZE
			}
		});

		bEliminarL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Pcrear != null && Pmodificar == null)	//CREAR
				{
					LotDesglossat ld = null;
					
					String eliminar = (String) cbEliminarL.getSelectedItem();
					
					for(LotDesglossat lotd : Pcrear.lots)
					{
						if(lotd.lot == Integer.parseInt(eliminar))
						{
							ld = lotd;
						}
					}
					
					Pcrear.lots.remove(ld);
					
					//vaciar();
					//informacioProducte(Pcrear);
					vaciarTaules();
					informacioTaules(Pcrear);
				}
				else
				{
					if(Pcrear == null && Pmodificar != null)	//MODIFICAR
					{
						LotDesglossat ld = null;
						
						String eliminar = (String) cbEliminarL.getSelectedItem();
						
						for(LotDesglossat lotd : Pmodificar.lots)
						{
							if(lotd.lot == Integer.parseInt(eliminar))
							{
								ld = lotd;
							}
						}
						
						Pmodificar.lots.remove(ld);
						
						//vaciar();
						//informacioProducte(Pmodificar);
						vaciarTaules();
						informacioTaules(Pmodificar);
						
						//System.out.println(Pbackup.getComposicio() + " //////" + Pbackup.lots);
					}
				}
				
				/*Producte buscado = null;
				LotDesglossat ld = null;
				
				String eliminar = (String) cbEliminarL.getSelectedItem();
				
				for(Producte producte : magatzem.getProductes())
				{
					if(producte.getNomProducte().equals(txtNom.getText()))
					{
						buscado = producte;
					}
				}
				
				for(LotDesglossat lotd : buscado.lots)
				{
					if(lotd.lot == Integer.parseInt(eliminar))
					{
						ld = lotd;
					}
				}
				
				buscado.lots.remove(ld);
				
				vaciar();
				informacioProducte(buscado);*/
			}
		});
	}

	//FUNCIONES
	public void informacioProducte(Producte paux)
	{
		lblExisteix.setText("");	//Existeix vacio
	
		txtidProducte.setText(String.valueOf(paux.getCodiProducte()));
		txtNom.setText(paux.getNomProducte());
		//lblDescripcio.setText();
		txtStock.setText(Integer.toString(paux.getStock()));
		txtStockMinim.setText(Integer.toString(paux.getStockMinim()));
		if(paux.getProveidor() != null)
		{
			txtProveidor.setText(paux.getProveidor().getNomProveidor());
		}
		txtPreuVenda.setText(Double.toString(paux.getPreuVenda()));
		
		if(paux.getTipus() == Tipus.VENDIBLE)
		{
			bVendible.setSelected(true);
			
			bVendible.setEnabled(false);
			bIngredient.setEnabled(false);
		}
		else
		{
			bIngredient.setSelected(true);
			
			bVendible.setEnabled(false);
			bIngredient.setEnabled(false);
		}
		
		if(paux.getUnitatMesura() == UnitatMesura.LLITRE)
		{
			bLlitre.setSelected(true);
			
			bLlitre.setEnabled(false);
			bGram.setEnabled(false);
			bUnitat.setEnabled(false);
		}
		else
		{
			if(paux.getUnitatMesura() == UnitatMesura.GRAMS)
			{
				bGram.setSelected(true);
				
				bLlitre.setEnabled(false);
				bGram.setEnabled(false);
				bUnitat.setEnabled(false);
			}
			else
			{
				bUnitat.setSelected(true);
				
				bLlitre.setEnabled(false);
				bGram.setEnabled(false);
				bUnitat.setEnabled(false);
			}
		}
		
		cbProducteC.removeAllItems();
		cbEliminarC.removeAllItems();
		cbEliminarL.removeAllItems();
		
		//Table Composicio
		taulaComposicio = (DefaultTableModel) tableComposicio.getModel();
		taulaComposicio.setRowCount(0);
		
		ArrayList<Producte> productes = new ArrayList<>(paux.getComposicio().keySet());
		ArrayList<Integer> quantitats = new ArrayList<>(paux.getComposicio().values());
		
		for (int i = 0; i < productes.size(); i++)
		{
			taulaComposicio.addRow(new Object[] {productes.get(i).getCodiProducte(), productes.get(i).getNomProducte(), quantitats.get(i)});
			
			//COMBOBOX PRODUCTES COMPOSICIO A ELIMINAR
			cbEliminarC.addItem(productes.get(i).getNomProducte());
		}
		
		//COMBOBOX PRODUCTES COMPOSICIO
		for(Producte p : PantallaMain.magatzem.getProductes())
		{
			if((p.getTipus() == Tipus.INGREDIENT && (!paux.getComposicio().containsKey(p)) || paux.getComposicio().isEmpty()))
			{
				cbProducteC.addItem(p.getNomProducte());
			}
		}
		
		//Table Lots
		taulaLots = (DefaultTableModel) tableLots.getModel();
		taulaLots.setRowCount(0);
		
		//int x = 0;
		
		for(LotDesglossat l : paux.lots)
		{
			//x++;
			taulaLots.addRow(new Object[] {l.getIdLot(), l.getDataEntrada(), l.getDataCaducitat(), l.getQuantitat()});
			
			//COMBOBOX LOTS A ELIMINAR
			cbEliminarL.addItem(String.valueOf(l.getIdLot()));
		}
	}
	
	public void informacioTaules(Producte paux)
	{
		cbProducteC.removeAllItems();
		cbEliminarC.removeAllItems();
		cbEliminarL.removeAllItems();
		
		//Table Composicio
		taulaComposicio = (DefaultTableModel) tableComposicio.getModel();
		taulaComposicio.setRowCount(0);
		
		ArrayList<Producte> productes = new ArrayList<>(paux.getComposicio().keySet());
		ArrayList<Integer> quantitats = new ArrayList<>(paux.getComposicio().values());
		
		/*System.out.println("Productes: " + productes.size());
		System.out.println("Quantitats" + quantitats.size());*/
		
		for (int i = 0; i < productes.size(); i++)
		{
			taulaComposicio.addRow(new Object[] {productes.get(i).getCodiProducte(), productes.get(i).getNomProducte(), quantitats.get(i)});
			
			//COMBOBOX PRODUCTES COMPOSICIO A ELIMINAR
			cbEliminarC.addItem(productes.get(i).getNomProducte());
		}
		
		//COMBOBOX PRODUCTES COMPOSICIO
		for(Producte p : PantallaMain.magatzem.getProductes())
		{
			if((p.getTipus() == Tipus.INGREDIENT && (!paux.getComposicio().containsKey(p)) || paux.getComposicio().isEmpty()))
			{
				cbProducteC.addItem(p.getNomProducte());
			}
		}
		
		//Table Lots
		taulaLots = (DefaultTableModel) tableLots.getModel();
		taulaLots.setRowCount(0);
		
		//int x = 0;
		
		for(LotDesglossat l : paux.lots)
		{
			//x++;
			taulaLots.addRow(new Object[] {l.getIdLot(), l.getDataEntrada(), l.getDataCaducitat(), l.getQuantitat()});
			
			//COMBOBOX LOTS A ELIMINAR
			cbEliminarL.addItem(String.valueOf(l.getIdLot()));
		}
	}
	
	public void vaciarTaules()
	{
		//Table Composicio
		taulaComposicio = (DefaultTableModel) tableComposicio.getModel();
		taulaComposicio.setRowCount(0);
		
		//Table Lots
		taulaLots = (DefaultTableModel) tableLots.getModel();
		taulaLots.setRowCount(0);
	}
	
	public void editableFalse()
	{
		txtNom.setEditable(false);
		//txtDescripcio.setEditable(false);
		txtStock.setEditable(false);
		txtStockMinim.setEditable(false);
		txtPreuVenda.setEditable(false);
		txtProveidor.setEditable(false);
		bVendible.setEnabled(false);
		bIngredient.setEnabled(false);
		bLlitre.setEnabled(false);
		bGram.setEnabled(false);
		bUnitat.setEnabled(false);
		
		//Table Composicio
		cbProducteC.setEnabled(false);
		txtProducteQC.setEditable(false);
		bAfegirC.setEnabled(false);
		bEliminarC.setEnabled(false);
		cbEliminarC.setEnabled(false);
		
		//Table Lot
		txtNumLots.setEditable(false);
		txtQuantitatPerLot.setEditable(false);
		bAfegirL.setEnabled(false);
		bEliminarL.setEnabled(false);
		cbEliminarL.setEnabled(false);
	}
	
	public void editableTrue()
	{
		txtNom.setEditable(true);
		//txtDescripcio.setEditable(true);
		txtStock.setEditable(true);
		txtStockMinim.setEditable(true);
		txtPreuVenda.setEditable(true);
		txtProveidor.setEditable(true);
		bVendible.setEnabled(true);
		bIngredient.setEnabled(true);
		bLlitre.setEnabled(true);
		bGram.setEnabled(true);
		bUnitat.setEnabled(true);

		//Table Composicio
		cbProducteC.setEnabled(true);
		txtProducteQC.setEditable(true);
		bAfegirC.setEnabled(true);
		bEliminarC.setEnabled(true);
		cbEliminarC.setEnabled(true);
		
		//Table Lot
		txtNumLots.setEditable(true);
		txtQuantitatPerLot.setEditable(true);
		bAfegirL.setEnabled(true);
		bEliminarL.setEnabled(true);
		cbEliminarL.setEnabled(true);
	}
	
	public void vaciar()
	{
		txtNom.setText("");
		//lblDescripcio.setText("");
		txtStock.setText("");
		txtStockMinim.setText("");
		txtPreuVenda.setText("");
		txtProveidor.setText("");
		/*bVendible.setSelected(false);
		bIngredient.setSelected(false);
		bLlitre.setSelected(false);
		bGram.setSelected(false);
		bUnitat.setSelected(false);*/
		tipus.clearSelection();
		mesura.clearSelection();
		
		if(taulaComposicio != null)
		{
			taulaComposicio.setRowCount(0);
		}
		
		if(taulaLots != null)
		{
			taulaLots.setRowCount(0);			
		}
		
		lblExisteix.setText("");	//Existeix vacio
		
		//txt TABLAS
		txtProducteQC.setText("");
		txtNumLots.setText("");
		txtQuantitatPerLot.setText("");
		
		cbProducteC.removeAllItems();
		cbEliminarC.removeAllItems();
		cbEliminarL.removeAllItems();
	}

	/*public Magatzem getMagatzem() {
		return magatzem;
	}

	public void setMagatzem(Magatzem magatzem) {
		this.magatzem = magatzem;
	}*/
	
	public void getIdMaxMin()
	{
		idMax = 0;
		idMin = Integer.MAX_VALUE;
		
		for(Producte p : PantallaMain.magatzem.getProductes())
		{
			if(p.getCodiProducte() > idMax)
			{
				idMax = p.getCodiProducte();
			}
			
			if(p.getCodiProducte() < idMin)
			{
				idMin = p.getCodiProducte();
			}
		}
	}
}
