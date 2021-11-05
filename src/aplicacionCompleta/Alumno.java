package aplicacionCompleta;
/**
 * 
 * Clase que mueve los datos a la tabla
 *
 * @author windows10
 *
 */
public class Alumno {

	//atributos de la clase
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String curso;
	
	/**
	 * Constructor de la clase Alumno
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param curso
	 */
	public Alumno(String dni,String nombre, String apellidos, int edad, String curso) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.curso=curso;
	}
	/**
	 * Metodo que devuelve el dni del Alumno
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Metodo que devuelve el nombre del Alumno
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que devuelve el apellido del Alumno
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Metodo que devuelve la edad del Alumno
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Metodo que devuelve el curso del Alumno
	 * @return curso
	 */
	public String getCurso() {
		return curso;
	}
	
	/**
	 * Metodo que devuelve los datos del Alumno en un array para insertar en la JTable 
	 * @return datos
	 */
	public String[] arrayDatosAlu() {
		String[] datos=new String[5];
		datos[0]=dni;
		datos[1]=nombre;
		datos[2]=apellidos;
		datos[3]=Integer.toString(edad);
		datos[4]=curso;
		
		return datos;
	}
}
