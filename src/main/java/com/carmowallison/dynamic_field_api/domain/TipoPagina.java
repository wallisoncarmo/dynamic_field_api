package com.carmowallison.dynamic_field_api.domain;


import com.carmowallison.dynamic_field_api.dto.TipoPaginaDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class TipoPagina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;

	public TipoPagina(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public TipoPagina() {	}

	public TipoPagina fromDTO(TipoPaginaDTO objDTO) {
		return new TipoPagina(
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
		TipoPagina that = (TipoPagina) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
