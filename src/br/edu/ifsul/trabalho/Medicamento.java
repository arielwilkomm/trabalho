/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.trabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_medicamento", sequenceName = "seq_medicamento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_medicamento", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 40, message = "O nome nao pode ter mais que {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em Branco")
    @Column(name = "nome", length = 2, nullable = false)
    private String nome;
    @ManyToMany
    @JoinTable(name = "medicamentos_receituario",
            joinColumns = 
            @JoinColumn(name = "medicamento", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "receituario", referencedColumnName = "id",
                    nullable = false))    
    private List<Receituario> receituario = new ArrayList<>();

    public Medicamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicamento other = (Medicamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }

 
    
    
}
