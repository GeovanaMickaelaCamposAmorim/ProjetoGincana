package br.edu.ifba.back.gincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "equipe")
public class EquipeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Equipe")
	private long id_Equipe;
	
	@Column(name = "nome_Equipe", nullable = false)
	private String nome_Equipe;
	
	@Column(name = "curso_Equipe", nullable = false)
	private String curso_Equipe;
	
	@Column(name = "representante_Equipe", nullable = false)
	private String representante_Equipe;
	
	@Column(name = "id_Gincana ", nullable = true)
	private Gincana id_Gincana ;

	
	public EquipeModel() {
		super();
	}
	

	public EquipeModel(long id_Equipe, String nome_Equipe, String curso_Equipe, String representante_Equipe,
			Gincana id_Gincana) {
		super();
		this.id_Equipe = id_Equipe;
		this.nome_Equipe = nome_Equipe;
		this.curso_Equipe = curso_Equipe;
		this.representante_Equipe = representante_Equipe;
		this.id_Gincana = id_Gincana;
	}



	public long getId_Equipe() {
		return id_Equipe;
	}



	public void setId_Equipe(long id_Equipe) {
		this.id_Equipe = id_Equipe;
	}



	public String getNome_Equipe() {
		return nome_Equipe;
	}



	public void setNome_Equipe(String nome_Equipe) {
		this.nome_Equipe = nome_Equipe;
	}



	public String getCurso_Equipe() {
		return curso_Equipe;
	}



	public void setCurso_Equipe(String curso_Equipe) {
		this.curso_Equipe = curso_Equipe;
	}



	public String getRepresentante_Equipe() {
		return representante_Equipe;
	}



	public void setRepresentante_Equipe(String representante_Equipe) {
		this.representante_Equipe = representante_Equipe;
	}



	public Gincana getId_Gincana() {
		return id_Gincana;
	}



	public void setIdGincana(Gincana id_Gincana) {
		this.id_Gincana = id_Gincana;
	}



	@Override
	public String toString() {
		return "GincanaModel [id_Equipe=" + id_Equipe + ", nome_Equipe=" + nome_Equipe + ", curso_Equipe=" + curso_Equipe
				+ ", representante_Equipe=" + representante_Equipe + "]";
	}
}