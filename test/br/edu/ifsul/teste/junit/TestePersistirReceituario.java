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
public class TestePersistirReceituario {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirReceituario() {
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
//            Receituario r = new Receituario();
//            r.setPosologia("a");
//            r.setValidade(Calendar.getInstance());
//            c.adicionarReceituario(r);
Receituario m = em.find(Receituario.class, 1);
Medicamento r = em.find(Medicamento.class, 5);
            r.getReceituario().add(m);

//            Receituario r = em.find(Receituario.class, 1);
//            Medicamento m = em.find(Medicamento.class, 1);
//            m.getMedicamentos().add(r);
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();

        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }

}
