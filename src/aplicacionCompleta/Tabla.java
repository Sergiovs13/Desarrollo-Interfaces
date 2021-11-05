package aplicacionCompleta;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Clase que gestiona la tabla
 * @author windows10
 *
 */
public class Tabla extends JDialog{
	//atributos de la clase
	private Ventana v;
	private JTable table;
	private DefaultTableModel dtm=new DefaultTableModel();
	private JScrollPane scrollPane;
	private GestionBBDD gestBD=new GestionBBDD();
	private JMenuBar menuBar;
	private JMenu menuFiltrar,menuEso,menuBach,menuFpb,menuGM,menuGS;
	private JMenuItem menuItem1Eso,menuItem2Eso,menuItem3Eso,menuItem4Eso,menuItem1Bach,menuItem2Bach;
	private JMenuItem menuItem1Fpb,menuItem2Fpb,menuItem1GM,menuItem2GM,menuItem1GS,menuItem2GS;
	
	/**
	 * Constructor de la clase
	 * @param parent. Ventana padre
	 * @param modal
	 */
	public Tabla(Frame parent, boolean modal) {
		super(parent,modal);
		v=(Ventana)parent;
		iniciarTabla();
		gestBD.conectarseBbdd();
	}
	
	/**
	 * Metodo que inicia la tabla y le da funcionalidad
	 */
	private void iniciarTabla() {
		setTitle("Listado Alumno");
		setBounds(100, 100, 400, 400);
		setLocationRelativeTo(null);
		
		dtm.setColumnIdentifiers(new String [] {"DNI","Nombre","Apellidos","Edad","Curso"});
		table = new JTable(dtm);
		table.setBounds(0, 25, 384, 274);
		table.setEnabled(false);
		getContentPane().add(table);
		
		 scrollPane= new JScrollPane(table);
		scrollPane.setBounds(0, 0, 384, 339);
		getContentPane().add(scrollPane);
		
		menuBar= new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFiltrar = new JMenu("Filtrar Por Curso");
		menuBar.add(menuFiltrar);
		
		menuEso = new JMenu("E.S.O");
		menuFiltrar.add(menuEso);
		
		menuItem1Eso = new JMenuItem("1\u00BA E.S.O");
		menuEso.add(menuItem1Eso);
		menuItem1Eso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '1º E.S.O'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
			
		});
		
		menuItem2Eso = new JMenuItem("2\u00BA E.S.O");
		menuEso.add(menuItem2Eso);
		menuItem2Eso.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '2º E.S.O'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
				
			}
			
		});
		
		menuItem3Eso = new JMenuItem("3\u00BA E.S.O");
		menuEso.add(menuItem3Eso);
		menuItem3Eso.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '3º E.S.O'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
				
			}
		});
		
		menuItem4Eso = new JMenuItem("4\u00BA E.S.O");
		menuEso.add(menuItem4Eso);
		menuItem4Eso.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '4º E.S.O'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}	
		});
		menuBach = new JMenu("Bachiller");
		menuFiltrar.add(menuBach);
		
		menuItem1Bach = new JMenuItem("1 BACH");
		menuBach.add(menuItem1Bach);
		menuItem1Bach.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '1º BACH'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
			
		});
		
		menuItem2Bach = new JMenuItem("2 BACH");
		menuBach.add(menuItem2Bach);
		menuItem2Bach.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '2º BACH'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
			
		});
		menuFpb = new JMenu("FPB");
		menuFiltrar.add(menuFpb);
		
		menuItem1Fpb = new JMenuItem("1 FPB");
		menuFpb.add(menuItem1Fpb);
		menuItem1Fpb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '1º FPB'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
		});
		
		menuItem2Fpb = new JMenuItem("2 FPB");
		menuFpb.add(menuItem2Fpb);
		menuItem2Fpb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '2º FPB'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
		});
		
		menuGM = new JMenu("CGM");
		menuFiltrar.add(menuGM);
		
		menuItem1GM = new JMenuItem("1 CGM");
		menuGM.add(menuItem1GM);
		menuItem1GM.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '1º CGM'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
		});
		
		menuItem2GM = new JMenuItem("2 CGM");
		menuGM.add(menuItem2GM);
		menuItem2GM.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '2º CGM'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
		});
		
		menuGS = new JMenu("CGS");
		menuFiltrar.add(menuGS);
		
		menuItem1GS = new JMenuItem("1 CGS");
		menuGS.add(menuItem1GS);
		menuItem1GS.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '1º CGS'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
		});

		menuItem2GS = new JMenuItem("2 CGS");
		menuGS.add(menuItem2GS);
		menuItem2GS.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gestBD.limpiarTabla(dtm);
				gestBD.mostrarDatos(dtm, "curso = '2º CGS'");
				if(dtm.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "No hay alumnos matriculados aun");
					dispose();
				}
			}
		});
	}
		
	/**
	 * Metodo que inserta el Alumno en la base de datos
	 * @param alu. Alumno a insertar
	 */
	public void insertarAlumno(Alumno alu) {
		gestBD.anyadirAlumno(alu);
	}
	
	/**
	 * Metodo que muestra los datos en la tabla
	 */
	
	/*
	 * borramos las filas de la tabla y mostramos los datos que queremos
	 * si la tabla no tiene contenido, se muestra un aviso
	 * si tiene contenido, se visualiza
	 */
	public void visualizarTabla() {
		
		if(gestBD.conex!=null) {
			gestBD.limpiarTabla(dtm);
			gestBD.mostrarDatos(dtm,"1");
			if(table.getRowCount()<=0) {
				JOptionPane.showMessageDialog(this, "La tabla esta vacia");
			}else {
				setVisible(true);
			}
		}
	}
	
	/**
	 * Metodo que cierra la conexion con la base de datos
	 */
	public void cerrarConexion() {
		gestBD.cerrarConexion();
	}
}
