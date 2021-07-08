package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @GenericGenerator(name = "native",strategy = "native")
	@Column(name="ID_Usuario")
	private Long id;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	
	
	public void usuario() {
		
	}
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
