package br.edu.ifsul.teste.junitmedico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.teste.junitespecialidade.*;
import br.edu.ifsul.trabalho.Especialidade;
import br.edu.ifsul.trabalho.Medico;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.hibernate.validator.ap.util.CollectionHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
            Especialidade e = em.find(Especialidade.class, 1);
            Medico m = new Medico();
            m.setEspecialidade(e);
            m.setCrm("nao sei o que é");
            
            em.getTransaction().begin();
            em.persist(e);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
