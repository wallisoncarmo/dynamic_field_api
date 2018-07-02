package com.carmowallison.dynamic_field_api.domain;


import com.carmowallison.dynamic_field_api.dto.ValorDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class Valor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	@DBRef
	private Valor depende;


	public Valor(String id, String nome, Valor depende) {
		this.id = id;
		this.nome = nome;
		this.depende = depende;
	}
	public Valor() {	}

	public Valor fromDTO(ValorDTO objDTO) {
		return new Valor(
				objDTO.getId(),
				objDTO.getNome(),
				objDTO.getDepende()
		);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Valor getDepende() {
		return depende;
	}

	public void setDepende(Valor depende) {
		this.depende = depende;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Valor valor = (Valor) o;
		return Objects.equals(id, valor.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
