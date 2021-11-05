package aplicacionSencilla;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaClientes extends JDialog{
	private JTextField tfNombre;
	private JTextField tfApellido;
	private VentanaPrincipalAS vp;

	public AltaClientes(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		vp=(VentanaPrincipalAS)parent;
		setTitle("Alta usuario");
		setBounds(100, 100, 470, 351);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(61, 46, 55, 14);
		getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(152, 43, 156, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(61, 85, 55, 14);
		getContentPane().add(lblApellidos);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(152, 82, 156, 20);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha Alta:");
		lblFecha.setBounds(52, 128, 64, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(52, 170, 64, 14);
		getContentPane().add(lblProvincia);
		
		
		
		JSpinner spinnerFA = new JSpinner();
		spinnerFA.setModel(new SpinnerDateModel(new Date(1632607200000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerFA.setBounds(152, 126, 156, 17);
		getContentPane().add(spinnerFA);
		
		JComboBox cbProvincia = new JComboBox();
		cbProvincia.setModel(new DefaultComboBoxModel(new String[] {"Alicante", "Murcia", "Valencia", "Granada"}));
		cbProvincia.setBounds(152, 166, 156, 22);
		getContentPane().add(cbProvincia);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=tfNombre.getText();
				String apellido=tfApellido.getText();
				Date fecha=(Date) spinnerFA.getValue();
				String provincia=(String) cbProvincia.getSelectedItem();
				Cliente cl=new Cliente(nombre,apellido,fecha,provincia);
				vp.anyadirCliente(cl);
				dispose();
			}
		});
		btnEnviar.setBounds(303, 253, 89, 23);
		getContentPane().add(btnEnviar);
		
		setVisible(true);
	}
}
