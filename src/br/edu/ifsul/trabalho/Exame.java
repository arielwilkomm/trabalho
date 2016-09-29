
package br.edu.ifsul.trabalho;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "exame")
public class Exame implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_exame", sequenceName = "seq_exame_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @NotNull(message = "A descrição não pode ser nula")
    @Length(max = 20, message = "A descrição não pode ter mais que {max} caracteres")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", length = 20, nullable = false)    
    private String descricao;
    @NotNull(message = "A consulta não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    private Consulta consulta;

    public Exame() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        final Exame other = (Exame) obj;
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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    
}
