
package br.edu.ifsul.trabalho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "consulta")
public class Consulta implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_consulta", sequenceName = "sequence_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "A hora deve ser informada")
    @Column(name = "hora", nullable = false, columnDefinition = "time")
    private Calendar hora;
    @Length(max = 100, message = "A posconsulta nao pode ter mais que {max} caracteres")
    @NotNull(message = "A posconsulta não pode ser nula")
    @NotBlank(message = "A posconsulta não pode estar em Branca")
    @Column(name = "posconsulta", length = 100, nullable = false)
    private String posconsulta;
    @Length(max = 100, message = "A preconsulta nao pode ter mais que {max} caracteres")
    @NotNull(message = "A preconsulta não pode ser nula")
    @NotBlank(message = "A preconsulta não pode estar em Branca")
    @Column(name = "preconsulta", length = 100, nullable = false)
    private String preconsulta;
    @NotNull(message = "O paciente não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)    
    private Paciente paciente;
    @NotNull(message = "O medico não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false)    
    private Medico medico;
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Exame> exame = new ArrayList<>();
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituario = new ArrayList<>();

    public Consulta() {
    }
    
    public void adicionarExame(Exame obj){
        obj.setConsulta(this);
        this.exame.add(obj);
    }
    
    public void removerExame(int index){
        this.exame.remove(index);
    }
    public void adicionarReceituario(Receituario obj){
        obj.setConsulta(this);
        this.receituario.add(obj);
    }
    
    public void removerReceituario(int index){
        this.exame.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public List<Exame> getExame() {
        return exame;
    }

    public void setExame(List<Exame> exame) {
        this.exame = exame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Receituario> getReceituario() {
        return receituario;
    }

    public void setReceituario(List<Receituario> receituario) {
        this.receituario = receituario;
    }
    
    
}
