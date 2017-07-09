package controladores;

import java.util.ArrayList;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Usuario {
	@PrimaryKey
	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	//@hace que la variable sea un identificador ID
	
	@Persistent
	private int id;
	
	@Persistent
	private String matr = "No";
	
	@Persistent
	public String mens = "No";
	
	@Persistent
	private Matriculas matricula;
	
	@Persistent
	public ArrayList<Mensajes> mensaje;

	@Persistent
	private String nombre;
	
	@Persistent
	private String apellido;

	@Persistent
	private String usuario;
	
	@Persistent
	private String sexo;
	
	@Persistent
	private String fechaN;

	@Persistent
	private String padre;

	@Persistent
	private String email;
	
	@Persistent
	private String contras;
	
	@Persistent
	private String interes;

	public Usuario(String nombre, String apellido, String usuario,String sexo, String fechaN, String padre, String email,String contraseña, String interes) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.sexo = sexo;
		this.fechaN = fechaN;
		this.padre = padre;
		this.email = email;
		this.contras = contraseña;
		this.interes = interes;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMatr() {
		return matr;
	}

	public void setMatr(String matr) {
		this.matr = matr;
	}

	public int getCont() {
		return mensaje.size();
	}

	public Matriculas getMatricula() {
		return matricula;
	}

	public void setMatricula(Matriculas matricula) {
		this.matricula = matricula;
	}
	
	public ArrayList <Mensajes> getMensaje() {
		return mensaje;
	}

	public void addMensaje(Mensajes mensaje) {
		this.mensaje.add(mensaje);
	}
	public void removeMensaje(int i) {
		this.mensaje.remove(i);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String lastname) {
		this.apellido = lastname;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaN() {
		return fechaN;
	}

	public void setFechaN(String fechaN) {
		this.fechaN = fechaN;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(String padre) {
		this.padre = padre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getContras() {
		return contras;
	}

	public void setContras(String contraseña) {
		this.contras= contraseña;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	@Override
	public String toString() {
		return "Alumno [Nombre=" + nombre + ", Apellidos=" + apellido + ", Usuario="
				+ usuario + ", idSchool=" + sexo + ", Fecha de Nacimiento=" + fechaN
				+ ", Padre=" + padre + ", e-mail=" + email + ", Matricula=" + matricula + ", Mensaje=" + mensaje +"]";
	}
	
	
	
}