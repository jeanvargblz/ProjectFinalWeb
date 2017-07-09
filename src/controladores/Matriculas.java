package controladores;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Matriculas {
	@PrimaryKey
	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	//@hace que la variable sea un identificador ID
	
	@Persistent
	private boolean mat = true;
	
	@Persistent
	private String turno;
	
	@Persistent
	private String grupo;

	@Persistent
	private String colegio;
	
	@Persistent
	private String tipoColegio;

	@Persistent
	private String telefono;
	
	@Persistent
	private String carrera;

	@Persistent
	private String universidad;
	
	@Persistent
	private String area;

	@Persistent
	private String direccion;
	
	@Persistent
	private String ciudad;

	public Matriculas(boolean mat, String turno, String grupo,
			String colegio, String tipoColegio, String telefono,
			String carrera, String universidad, String area, String direccion, String ciudad) {
		super();
		this.mat = mat;
		this.turno = turno;
		this.grupo = grupo;
		this.colegio = colegio;
		this.tipoColegio = tipoColegio;
		this.telefono = telefono;
		this.carrera = carrera;
		this.universidad = universidad;
		this.area = area;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}

	public boolean getMat() {
		return mat;
	}
	
	public void setMat(boolean mat) {
		this.mat = mat;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	public String getTipoColegio() {
		return tipoColegio;
	}

	public void setTipoColegio(String tipoColegio) {
		this.tipoColegio = tipoColegio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Matriculas [mat=" + mat + ", usuario=" + ", turno="
				+ turno + ", grupo=" + grupo + ", colegio=" + colegio
				+ ", tipoColegio=" + tipoColegio + ", telefono=" + telefono
				+ ", carrera=" + carrera + ", universidad=" + universidad
				+ ", area=" + area + ", direccion=" + direccion + "]";
	}
	
}
