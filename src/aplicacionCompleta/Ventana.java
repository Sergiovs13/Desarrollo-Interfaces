package aplicacionCompleta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Clase principal del programa
 * @author windows10
 *
 */

public class Ventana extends JFrame{
	//atributos de la clase
	private JLabel lblVentana,lblNombre,lblApellido,lblEdad,lblCurso,lblDni;
	private JTextField tfNombre,tfApellidos,tfEdad,tfDNI;
	private JComboBox comboBoxCursos;
	private JButton btnAceptar,btnCancelar;
	private JMenuBar menuBar;
	private JMenu menuBBDD;
	private JMenuItem listados;
	private Alumno alu;
	private Tabla miTabla=new Tabla(this,true);
	
	
	/**
	 * Constructor de la Clase
	 */
	public Ventana() {
		
		iniciarComponentes();
	}

	/**
	 * Metodo que iniciar los componentes y les da funcionalidad
	 */
	private void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestion Alumnado");
		setSize(450,450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblVentana = new JLabel("Inscripcion alumnos");
		lblVentana.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVentana.setBounds(75, 27, 334, 34);
		getContentPane().add(lblVentana);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(25, 161, 82, 14);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellidos: ");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setBounds(25, 201, 82, 14);
		getContentPane().add(lblApellido);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdad.setBounds(25, 241, 46, 14);
		getContentPane().add(lblEdad);
		
		lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurso.setBounds(25, 281, 66, 14);
		getContentPane().add(lblCurso);
		
		comboBoxCursos = new JComboBox();
		comboBoxCursos.setModel(new DefaultComboBoxModel(new String[] {"1\u00BA E.S.O", "2\u00BA E.S.O", "3\u00BA E.S.O", "4\u00BA E.S.O"
				, "--------", "1\u00BA BACH", "2\u00BA BACH", "--------", "1\u00BA FPB", "2\u00AA FPB", "--------", 
				"1\u00BA CGM", "2\u00BA CGM", "--------", "1\u00BA CGS", "2\u00BA CGS"}));
		comboBoxCursos.setBounds(117, 279, 82, 22);
		getContentPane().add(comboBoxCursos);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(117, 160, 184, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(117, 200, 184, 20);
		getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		tfEdad = new JTextField();
		tfEdad.setBounds(115, 240, 186, 20);
		getContentPane().add(tfEdad);
		tfEdad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(75, 344, 89, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				aceptar();
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(212, 344, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
			
		});
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		getContentPane().add(menuBar);
		
		menuBBDD = new JMenu("Gestionar");
		menuBar.add(menuBBDD);
		
		listados = new JMenuItem("Listados");
		menuBBDD.add(listados);
		
		 lblDni= new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(25, 119, 46, 14);
		getContentPane().add(lblDni);
		
		tfDNI = new JTextField();
		tfDNI.setBounds(113, 118, 188, 20);
		getContentPane().add(tfDNI);
		tfDNI.setColumns(10);
		listados.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miTabla.visualizarTabla();
				
			}
		});
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				miTabla.cerrarConexion();
			}
		});
		setVisible(true);
	}
	
	/**
	 * Metodo para limpiar los campos de la ventana
	 */
	private void limpiarCampos() {
		tfDNI.setText("");
		tfNombre.setText("");
		tfApellidos.setText("");
		tfEdad.setText("");
		comboBoxCursos.setSelectedIndex(0);
	}
	
	/**
	 * Metodo para enviar los datos a la base de datos
	 */
	
	/*
	 * array de component para almacenar los JtextField
	 * llamamos al metodo arrayCompo pasandole el array de component que pintara el fondo
	 * si el metodo comprobarColores devuelve true, se guardan los valores en variables
	 * se controla que el curso, dni y la edad se han validas
	 * se crea el objeto alumno con los datos de las variables
	 * se llama al metodo insertarAlumno de la clase Tabla y se le pasa el alumno que hemos creado
	 * 
	 */
	private void aceptar() {
		Component[] compo=new Component[4];
		compo[0]=tfDNI;
		compo[1]=tfNombre;
		compo[2]=tfApellidos;
		compo[3]=tfEdad;
		arrayCompo(compo);
		try {
			if(comprobarColores(compo)) {
				String dni=tfDNI.getText();
				String nombre=tfNombre.getText();
				String apellidos=tfApellidos.getText();
				int edad=Integer.parseInt(tfEdad.getText());
				String curso=(String) comboBoxCursos.getSelectedItem();
				if(curso.equals("--------")) {
					JOptionPane.showMessageDialog(null, "El curso no es valido");
				}else if(edad<=10) {
					JOptionPane.showMessageDialog(null, "La edad no es valida");
				}else if(dni.length()<9||dni.length()>9){ 
					JOptionPane.showMessageDialog(null, "El DNI no es valido");
				}else{
					alu=new Alumno(dni,nombre,apellidos,edad,curso);
					miTabla.insertarAlumno(alu);
					JOptionPane.showMessageDialog(null, "Alumno matriculado correctamente", "Matriculacion",JOptionPane.INFORMATION_MESSAGE);
					
				}

			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No has introducido una edad valida");
		}
	}
	
	/**
	 * Metodo que comprueba que el componente esta vacio o no
	 * @param c. Componente a comprobar
	 * @return true o false. Dependiendo si esta vacio o no
	 */
	private boolean camposVacios(Component c) {
		if(c instanceof JTextField) {
			if(((JTextField) c).getText().equals(""))
				return true;
		}
		return false;
	}
	/**
	 * Metodo que cambia el fondo del componente
	 * @param c. Componente a comprobar
	 */
	
	/*
	 * si camposVacios devuelve true, pintamos el fondo en rojo
	 * si camposVacios devuelve false, pintamos el fondo en blanco
	 */
	private void arrayCompo(Component[] c) {
		for(int i=0;i<c.length;i++) {
			if(camposVacios(c[i])) {
				c[i].setBackground(Color.RED);
			}else {
				c[i].setBackground(Color.WHITE);
				
			}
		}
		
	}
	
	/**
	 * Metodo que comprueba que los componentes esten rellenos
	 * @param c. Componente a comprobar
	 * @return true o false. Dependiendo de si el fondo del componente es rojo
	 */
	private boolean comprobarColores(Component[] c) {
		for(int i=0;i<c.length;i++) {
			if(c[i].getBackground().equals(Color.RED)) {
				JOptionPane.showMessageDialog(null, "Debes de rellenar todos los campos");
				return false;
			}
		}
		return true;
	}
}
