package com.example.demo.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name="pr_cliente")
public class Cliente {

    // comentado por sidney

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer idCliente;
    @Column(name="nm_cliente")
    private String nome;
    @Column(name="nm_email")
    private String email;
    @Column(name="dm_situacao")
    private Boolean situacao;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

}
