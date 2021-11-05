package aplicacionCompleta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

/**
 * Clase que gestiona la base de datos
 * @author windows10
 *
 */
public class GestionBBDD {
//atributos de la clase
	Connection conex;
	
	
	/**
	 * Metodo para conectarnos a la base de datos
	 */
	public void conectarseBbdd() {
		try {
			conex=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/fJS6AVj4P2","fJS6AVj4P2","eQynFdaNIA");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para añadir un Alumno a la base de datos
	 * @param alu. Alumno a añadir
	 */
	public void anyadirAlumno(Alumno alu) {
		try(Statement stmt=conex.createStatement()){
			if(conex!=null) {
				stmt.execute("insert into alumnos(dni,nombre,apellidos,edad,curso) values('"+alu.getDni()+"','"+alu.getNombre()+"','"+alu.getApellidos()+"','"+alu.getEdad()+"','"+alu.getCurso()+"')");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para mostrar los datos de la base de datos al JTable
	 * @param dtm. Modelo de la tabla
	 * @param s. Condicion para mostrar los alumnos
	 */
	public void mostrarDatos(DefaultTableModel dtm,String s) {
		try(Statement stmt=conex.createStatement()){
			if(conex!=null) {
				ResultSet rs=stmt.executeQuery("select * from alumnos where "+s);
				while(rs.next()) {
					String [] datos=new String[dtm.getColumnCount()];
					for(int i=0;i<datos.length;i++) {
						datos[i]=rs.getString(i+1);
					}
					dtm.addRow(datos);
				}
				rs.close();
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para eliminar los datos de la tabla
	 * @param dtm. Modelo de la tabla
	 */
	public void limpiarTabla(DefaultTableModel dtm) {
		for(int i=dtm.getRowCount()-1;i>=0;i--) {
			dtm.removeRow(i);
		}
	}
	
	/**
	 * Metodo para cerrar la conexion con la base de datos
	 */
	public void cerrarConexion() {
		try {
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
