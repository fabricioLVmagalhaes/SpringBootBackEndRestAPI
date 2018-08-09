package com.fabriciomagalhaes.cursomc.dto;

import java.io.Serializable;

import com.fabriciomagalhaes.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	//construtor que recebe um obj Categoria || constructor with a Category obj argument
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome =  obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
