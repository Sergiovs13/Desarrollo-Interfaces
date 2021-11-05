package aplicacionSencilla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class GestionBD {

	Connection conex;
	
	public GestionBD() {
		conectarseBbdd();
	}
	
	//metodo para conectarse a la base de datos
	public void conectarseBbdd() {
		try {
			conex=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/fJS6AVj4P2","fJS6AVj4P2","eQynFdaNIA");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//metodo para anyadir los datos de la tabla a la base de datos
	public void anyadirDatos(Cliente cl) {
		try(Statement stmt=conex.createStatement()){
			if(conex!=null) {
				stmt.execute("insert into clientes(nombre,apellidos,fecha_alta,provincia) values('"+cl.getNombre()+"','"+cl.getApellido()+"','"+cl.getFechaAlta()+"','"+cl.getProvincia()+"')");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//metodo para mostrar los datos de la base de datos en la tabla
	public void mostrarDatos(DefaultTableModel dtm) {
		try(Statement stmt=conex.createStatement()){
			if(conex!=null) {
				ResultSet rs=stmt.executeQuery("select * from clientes");
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
	
	//metodo para cerrar la conexion con la base de datos
	public void cerrarConexion() {
		try {
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
