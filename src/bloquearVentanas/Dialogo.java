package bloquearVentanas;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class Dialogo extends JDialog {

	private final JPanel panel = new JPanel();

	public Dialogo(VentanaPrincipal vp, boolean modal) {
		super(vp,modal);
		setBounds(100, 100, 350, 200);
		setTitle("Dialogo");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblDialg = new JLabel("Debes cerrarme para usar las ventanas");
		lblDialg.setBackground(Color.WHITE);
		lblDialg.setBounds(33, 23, 269, 27);
		getContentPane().add(lblDialg);
		setVisible(true);
	}
}
