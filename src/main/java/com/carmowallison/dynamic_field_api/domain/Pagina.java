package com.carmowallison.dynamic_field_api.domain;


import com.carmowallison.dynamic_field_api.dto.PaginaDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Document
public class Pagina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String nome;
    private String action;
    @DBRef
    private List<Campo> campos;

    public Pagina(String id, String nome, String action, List<Campo> campos) {
        this.id = id;
        this.nome = nome;
        this.action = action;
        this.campos = campos;
    }

    public Pagina() {
    }

    public Pagina fromDTO(PaginaDTO objDTO) {
        return new Pagina(objDTO.getId(), objDTO.getNome(),objDTO.getAction(),objDTO.getCampo());
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

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagina pagina = (Pagina) o;
        return Objects.equals(id, pagina.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
