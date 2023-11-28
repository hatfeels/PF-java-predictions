package models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="EQUIPO")

public @Data class Equipo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NAME",length=80,nullable=false)
	private String nombre;
	private String descripcion;
	
	
	public Equipo (String nombre) {
		this.setNombre(nombre);
	}
}
