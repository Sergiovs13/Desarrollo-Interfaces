
package bloquearVentanas;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private JPanel panel;

	
	public VentanaPrincipal() {
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JOptionPane.showMessageDialog(panel, "Esto es un dialogo");
	}
	
	public void mostrarDialogo() {
		Dialogo dialg=new Dialogo(this,true);
	}

}
