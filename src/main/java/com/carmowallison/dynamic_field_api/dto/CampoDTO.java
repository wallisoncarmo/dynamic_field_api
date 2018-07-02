package com.carmowallison.dynamic_field_api.dto;


import com.carmowallison.dynamic_field_api.domain.Campo;
import com.carmowallison.dynamic_field_api.domain.TipoCampo;
import com.carmowallison.dynamic_field_api.domain.Valor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Document
public class CampoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @NotEmpty(message = "Preenchimento Obrigatório!")
    @Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
    private String nome_campo;

    @NotEmpty(message = "Preenchimento Obrigatório!")
    @Length(min = 5, max = 255, message = "O tamanho precisa ser de 5 a 255 caracter!")
    private String titulo;

    private boolean obrigatorio;

    private boolean dinamico;

    private Integer max;
    private Integer min;

    private Campo depende;
    private TipoCampo tipo_campo;
    private List<Valor> valores;

    public CampoDTO() {}

    public CampoDTO(Campo obj) {
        this.id = obj.getId();
        this.nome_campo = obj.getNome_campo();
        this.titulo = obj.getTitulo();
        this.obrigatorio = obj.isObrigatorio();
        this.dinamico = obj.isDinamico();
        this.max = obj.getMax();
        this.min = obj.getMin();
        this.depende = obj.getDepende();
        this.tipo_campo =obj.getTipo_campo();
        this.valores = obj.getValores();
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

    public TipoCampo getTipo_campo() {
        return tipo_campo;
    }

    public void setTipo_campo(TipoCampo tipo_campo) {
        this.tipo_campo = tipo_campo;
    }

    public List<Valor> getValores() {
        return valores;
    }

    public void setValores(List<Valor> valores) {
        this.valores = valores;
    }
}
