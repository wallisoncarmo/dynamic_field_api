package com.carmowallison.dynamic_field_api.domain;


import com.carmowallison.dynamic_field_api.dto.CampoDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document
public class Campo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome_campo;
	private String titulo;
	@DBRef
	private TipoCampo tipo_campo;
	private boolean obrigatorio;
	private boolean dinamico;
	private Integer max;
	private Integer min;
	@DBRef
	private Campo depende;
	@DBRef
	private List<Valor> valores;

	public Campo(
			String id,
			String nome_campo,
			String titulo,
			TipoCampo tipo_campo,
			boolean obrigatorio,
			boolean dinamico,
			Integer max,
			Integer min,
			Campo depende,
			List<Valor> valores) {
		this.id = id;
		this.nome_campo = nome_campo;
		this.titulo = titulo;
		this.tipo_campo = tipo_campo;
		this.obrigatorio = obrigatorio;
		this.dinamico = dinamico;
		this.max = max;
		this.min = min;
		this.depende = depende;
		this.valores = valores;
	}

	public Campo() {}

	public Campo fromDTO(CampoDTO objDTO) {
		return new Campo(
				objDTO.getId(),
				objDTO.getNome_campo(),
				objDTO.getTitulo(),
				objDTO.getTipo_campo(),
				objDTO.isObrigatorio(),
				objDTO.isDinamico(),
				objDTO.getMax(),
				objDTO.getMin(),
				objDTO.getDepende(),
				objDTO.getValores()
		);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome_campo() {
		return nome_campo;
	}

	public void setNome_campo(String nome_campo) {
		this.nome_campo = nome_campo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoCampo getTipo_campo() {
		return tipo_campo;
	}

	public void setTipo_campo(TipoCampo tipo_campo) {
		this.tipo_campo = tipo_campo;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public boolean isDinamico() {
		return dinamico;
	}

	public void setDinamico(boolean dinamico) {
		this.dinamico = dinamico;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Campo getDepende() {
		return depende;
	}

	public void setDepende(Campo depende) {
		this.depende = depende;
	}

	public List<Valor> getValores() {
		return valores;
	}

	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Campo campo = (Campo) o;
		return Objects.equals(id, campo.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
