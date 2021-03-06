package com.carmowallison.dynamic_field_api.dto;


import com.carmowallison.dynamic_field_api.domain.Valor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Document
public class ValorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
	private String nome;
	@DBRef
	private Valor depende;

	public ValorDTO() {
	}

	public ValorDTO(Valor obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.depende = obj.getDepende();
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
}
