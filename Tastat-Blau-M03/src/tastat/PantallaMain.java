package tastat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaMain
{
	private JFrame frame;
	private JButton bPantallaProducte;
	private JButton bConsultes;
	private JButton bComandes;
	private JButton bClients;
	
	//
	public static Magatzem magatzem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaMain window = new PantallaMain();
					window.frame.setVisible(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
					magatzem = Programa.generaMagatzem();
					System.out.println(magatzem);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		bPantallaProducte = new JButton("Productes");
		//BOTON MOVIDO
		menuBar.add(bPantallaProducte);
		
		bConsultes = new JButton("Consultes");
		//BOTON MOVIDO
		menuBar.add(bConsultes);
		
		bComandes = new JButton("Comandes");
		//BOTON MOVIDO
		menuBar.add(bComandes);
		
		bClients = new JButton("Clients");
		//BOTON MOVIDO
		menuBar.add(bClients);
		
		//BOTONES
		bPantallaProducte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PantallaProducte pantallaProducte = new PantallaProducte();
					pantallaProducte.frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		bConsultes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PantallaConsultas pantallaConsultas = new PantallaConsultas();
					pantallaConsultas.frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		bComandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PantallaComandes pantallaComandes = new PantallaComandes();
					pantallaComandes.frame.setVisible(true);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		
		bClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PantallaClients pantallaClients = new PantallaClients();
					pantallaClients.frame.setVisible(true);
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
	}
}
