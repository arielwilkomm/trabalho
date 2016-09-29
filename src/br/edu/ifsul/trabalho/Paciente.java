/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.trabalho;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ariel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "paciente")
public class Paciente implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 100, message = "O nome nao pode ter mais que {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em Branco")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @NotNull(message = "O Nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    @Length(max = 11, message = "O telefone não pode ter mais de {max} caracteres")
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Column(name = "telefone", nullable = false, length = 11) 
    private String telefone;
    @Length(max = 1, message = "O sexo não pode ter mais de {max} caracteres")
    @NotNull(message = "O sexo não pode ser nulo")
    @NotBlank(message = "O sexo não pode ser em branco")
    @Column(name = "sexo", nullable = false, length = 1) 
    private String sexo;
    @NotBlank(message = "O sexo não pode ser em branco")
    @Column(name = "historico", columnDefinition = "text") 
    private String historico;
    @NotNull(message = "O peso não pode ser nulo")
    @Min(value = 0, message = "O peso não pode ser negativo")
    @Column(name = "peso", nullable = false, columnDefinition = "numeric(12,2)")
    private Double peso;
    @NotNull(message = "A altura não pode ser nula")
    @Min(value = 0, message = "A altura não pode ser negativa")
    @Column(name = "altura", nullable = false, columnDefinition = "numeric(12,2)")
    private Double altura;

    public Paciente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAtura() {
        return altura;
    }

    public void setAtura(Double altura) {
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
}
