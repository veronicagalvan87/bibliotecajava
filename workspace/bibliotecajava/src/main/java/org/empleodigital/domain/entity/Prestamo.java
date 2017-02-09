package org.empleodigital.domain.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private boolean entregado;
	
	@NotNull
	@NotEmpty
	private Date fechaentrega;
	
	@NotNull
	@NotEmpty
	private Date fecharecogida;
	
	@ManyToOne
	@JoinColumn (name = "usuario")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public Date getFechaentrega() {
		return fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public Date getFecharecogida() {
		return fecharecogida;
	}

	public void setFecharecogida(Date fecharecogida) {
		this.fecharecogida = fecharecogida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (entregado ? 1231 : 1237);
		result = prime * result + ((fechaentrega == null) ? 0 : fechaentrega.hashCode());
		result = prime * result + ((fecharecogida == null) ? 0 : fecharecogida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (entregado != other.entregado)
			return false;
		if (fechaentrega == null) {
			if (other.fechaentrega != null)
				return false;
		} else if (!fechaentrega.equals(other.fechaentrega))
			return false;
		if (fecharecogida == null) {
			if (other.fecharecogida != null)
				return false;
		} else if (!fecharecogida.equals(other.fecharecogida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public static Prestamo getOne(Long id2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
