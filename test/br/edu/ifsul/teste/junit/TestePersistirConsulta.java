package br.edu.ifsul.teste.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import br.edu.ifsul.trabalho.Medico;
//import br.edu.ifsul.trabalho.Consulta;
import br.edu.ifsul.trabalho.Consulta;
import br.edu.ifsul.trabalho.Especialidade;
import br.edu.ifsul.trabalho.Exame;
import br.edu.ifsul.trabalho.Medicamento;
import br.edu.ifsul.trabalho.Medico;
import br.edu.ifsul.trabalho.Paciente;
import br.edu.ifsul.trabalho.Receituario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ariel
 */
public class TestePersistirConsulta {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirConsulta() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-TrabalhoPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Consulta c = em.find(Consulta.class, 2);
            c.setData(Calendar.getInstance());
            c.setHora(Calendar.getInstance());
            c.setPosconsulta("a");
            c.setPreconsulta("b");
            c.setPaciente(em.find(Paciente.class, 1));
            c.setMedico(em.find(Medico.class, 1));
            Exame e = new Exame();
            e.setConsulta(c);
            e.setDescricao("b");
            e.setNome("nao");
            c.adicionarExame(e);
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
