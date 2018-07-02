package com.carmowallison.dynamic_field_api.domain;


import com.carmowallison.dynamic_field_api.dto.TipoCampoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class TipoCampo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;

	public TipoCampo(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public TipoCampo() {
	}

	public TipoCampo fromDTO(TipoCampoDTO objDTO) {
		return new TipoCampo(
				objDTO.getId(),
				objDTO.getNome()
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TipoCampo tipoCampo = (TipoCampo) o;
		return Objects.equals(id, tipoCampo.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
