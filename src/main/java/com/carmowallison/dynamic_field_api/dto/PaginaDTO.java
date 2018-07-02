package com.carmowallison.dynamic_field_api.dto;


import com.carmowallison.dynamic_field_api.domain.Campo;
import com.carmowallison.dynamic_field_api.domain.Pagina;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Document
public class PaginaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
	private String action;
	@DBRef
	private List<Campo> campo;

	public PaginaDTO() {
	}

	public PaginaDTO(Pagina obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.action = obj.getAction();
		this.campo = obj.getCampos();
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Campo> getCampo() {
		return campo;
	}

	public void setCampo(List<Campo> campo) {
		this.campo = campo;
	}
}
