/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.trabalho;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ariel
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "medico")
public class Medico extends Paciente implements Serializable {
    @Length(max = 40, message = "O crm não pode passar de {max) caracteres")
    @NotNull(message = "O crm não pode ser nulo")
    @NotBlank(message = "O crm não pode estar em Branco")
    @Column(name = "crm", length = 40, nullable = false)
    private String crm;
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade;

    public Medico() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
