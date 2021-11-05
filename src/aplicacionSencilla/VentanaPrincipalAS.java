package aplicacionSencilla;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipalAS extends JFrame{
	private JTable table;
	private DefaultTableModel dtm=new DefaultTableModel();
	private GestionBD gestbd=new GestionBD();

	public VentanaPrincipalAS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestion Clientes");
		setBounds(100, 100, 400, 400);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JMenuBar mb=new JMenuBar();
		setJMenuBar(mb);
		JMenu menu = new JMenu("Clientes");
		menu.setBounds(0, 0, 384, 361);
		mb.add(menu);
		JMenuItem clientes=new JMenuItem("Dar Alta Cliente");
		menu.add(clientes);
		
		clientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				crearAltaCliente();
				
			}
		});
		
		
		dtm.setColumnIdentifiers(new String [] {"Nombre","Apellidos","Fecha Alta","Provincia"});
		table = new JTable(dtm);
		table.setBounds(0, 25, 384, 274);
		table.setBackground(Color.WHITE);
		getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 384, 339);
		getContentPane().add(scrollPane);
		
		//mostramos los datos que tenga la base de datos para que haya sincronizacion
		gestbd.mostrarDatos(dtm);
		
		setVisible(true);
		//cerramos la conexion con la base de datos al cerrar la ventana principal
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				gestbd.cerrarConexion();
			}
		});
		
		
	}
	private void crearAltaCliente() {
		AltaClientes ac=new AltaClientes(this,true);
	}
	
	//pasamos la informacion que introduce el usuario a la tabla y la guardamos en la base de datos
	public void anyadirCliente(Cliente cl) {
		dtm.addRow(cl.arrayDatos());
		gestbd.anyadirDatos(cl);
	}
	
	
}
