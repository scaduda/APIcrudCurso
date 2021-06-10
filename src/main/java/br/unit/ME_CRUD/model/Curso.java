package br.unit.ME_CRUD.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Curso {

    @ApiModelProperty(value="Código do curso")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(value="Nome do curso")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(value="Descrição do curso")
    private String descricao;

    @ApiModelProperty(value="Ementa do curso")
    private String ementa;

    @ApiModelProperty(value="Data de cadastro do curso")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_cadastro;

    @ApiModelProperty(value="Data de cadastro do curso")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_inicio;

    @ApiModelProperty(value="Preço do curso")
    private float valor;

    public Curso() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Date getDataCadastro() {
        return data_cadastro;
    }

    public void setDataCadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Date getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id == curso.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
