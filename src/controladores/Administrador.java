package controladores;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Administrador {
	@PrimaryKey
	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	//@hace que la variable sea un identificador ID
	
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	@Persistent
	private String name;
	
	@Persistent
	private String lastname;
	
	@Persistent
	private String user;

	@Persistent
	private String email;
	
	@Persistent
	private String cargo;

	@Persistent
	private String pass;
	

	public Administrador(String name, String lastname, String user, String cargo, String email, String pass) {
		//super();
		this.name = name;
		this.lastname = lastname;
		this.user = user;
		this.cargo = cargo;
		this.email = email;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "<ul>.::Registro::.<li>" + name  +" "+ lastname + "</li><li>Sexo: "
				+ "</li><li>Cargo "+ cargo + "</l1><li>E-mail: " + email
				+"</li></ul>";
	}
	
}

