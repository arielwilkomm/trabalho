package br.edu.ifsul.teste.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import br.edu.ifsul.trabalho.Medico;
//import br.edu.ifsul.trabalho.Consulta;
import br.edu.ifsul.trabalho.Especialidade;
import br.edu.ifsul.trabalho.Medico;
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
public class TestePersistirMedico {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMedico() {
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
    public void teste(){
        boolean exception = false;
        try {
            Medico c = new Medico();
            c.setNascimento(Calendar.getInstance());
            c.setAtura(1.11);
            c.setCrm("111");
            c.setEspecialidade(em.find(Especialidade.class, 1));
            c.setHistorico("sss");
            c.setNome("A");
            c.setPeso(12.33);
            c.setSexo("M");
            c.setTelefone("00000000");
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
