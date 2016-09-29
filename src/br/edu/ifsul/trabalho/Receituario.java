
package br.edu.ifsul.trabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
@Entity
@Table(name = "receituario")
public class Receituario implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_receituario", sequenceName = "seq_receituario_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A posologia não pode ser nula")
    @Length(max = 40, message = "A posologia não pode ter mais que {max} caracteres")
    @NotBlank(message = "A posologia não pode ser em branca")
    @Column(name = "posologia", length = 40, nullable = false)
    private String posologia;
    @NotNull(message = "A validade deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    @NotNull(message = "A consulta não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    private Consulta consulta;
    @ManyToMany
    @JoinTable(name = "medicamentos_receituario",
            joinColumns = 
            @JoinColumn(name = "receituario", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "medicamento", referencedColumnName = "id",
                    nullable = false))    
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Receituario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    
}
