package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEmergente extends JDialog {

	private JPanel contentPane;
	private JTextField tfNombre;
	private VentanaPrincipal vp=new VentanaPrincipal();
	

	/**
	 * Create the frame.
	 */
	
	
	public VentanaEmergente(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		vp=(VentanaPrincipal)parent;
		setBounds(60, 60, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(153, 151, 89, 23);
		/*
		 * Accion del boton volver
		 * Obtenemos el nombre del TextField
		 * Se le pasa como argumento al metodo de vp
		 */
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre=tfNombre.getText();
				vp.cambiarNombre(nombre);
				dispose();
				
			}
			
		});
		contentPane.add(btnVolver);
		
		JLabel lblNombre = new JLabel("Escribe tu nombre");
		lblNombre.setBounds(92, 82, 112, 17);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(226, 80, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		setVisible(true);
		setTitle("Ventana Emergente");
	}
	
}
