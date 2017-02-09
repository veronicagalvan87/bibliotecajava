package org.empleodigital.domain.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="libro")
	private Libro libro;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@NotNull @NotEmpty
	private boolean entregado;
	
	
	@NotNull @NotEmpty
	private Date fecha;
	
	@NotNull @NotEmpty
	private boolean fecha_recogida;
	
	@NotNull @NotEmpty
	private boolean fecha_entrega;
	
	public Prestamo(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Libro getLibros_id() {
		return libro;
	}

	public void setLibros(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario_id() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isFecha_recogida() {
		return fecha_recogida;
	}

	public void setFecha_recogida(boolean fecha_recogida) {
		this.fecha_recogida = fecha_recogida;
	}

	public boolean isFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(boolean fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
}
