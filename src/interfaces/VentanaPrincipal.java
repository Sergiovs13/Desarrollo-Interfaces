package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	JLabel lblNombre=new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		
		JButton btnD = new JButton("Ir a dialogo");
		btnD.setBounds(146, 137, 124, 23);
		btnD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				crearVE();
			}
			
		});
		contentPane.add(btnD);
		
		lblNombre.setBounds(104, 89, 181, 37);
		contentPane.add(lblNombre);
	}
	//Metodo para añadir texto a la etiqueta con el nombre
	public void cambiarNombre(String nombre) {
		lblNombre.setText("Bienvenido "+nombre);
	}
	//metodo para crear la segunda ventana
	public void crearVE() {
		//le pasamos el parametro de la VP y el modal
		VentanaEmergente ve=new VentanaEmergente(this,true);
	}
	
}
