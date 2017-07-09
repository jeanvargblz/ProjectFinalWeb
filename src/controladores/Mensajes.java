package controladores;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Mensajes {
	@PrimaryKey
	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	//@hace que la variable sea un identificador ID
	
	@Persistent
	private int id = 0;
	
	@Persistent
	private String asunto;
	
	@Persistent
	private String to;
	
	@Persistent
	private String mensaje;

	@Persistent
	private String fecha;

	public Mensajes(String asunto, String to, String mensaje, String fecha) {
		super();
		this.asunto = asunto;
		this.to = to;
		this.mensaje = mensaje;
		this.fecha = fecha;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Mensajes [id=" + id + ", asunto=" + asunto + ", mensaje="
				+ mensaje + ", fecha=" + fecha + "]";
	}
	
}