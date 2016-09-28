package br.edu.ifsul.teste.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.trabalho.Especialidade;
import br.edu.ifsul.trabalho.Medico;
import br.edu.ifsul.trabalho.Paciente;
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
public class TestePersistirPaciente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPaciente() {
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
            Medico p = new Medico();
            p.setAtura(1.22);
            p.setHistorico("nem um");
            p.setNascimento(Calendar.getInstance());
            p.setNome("Ariel");
            p.setPeso(12.90);
            p.setSexo("M");
            p.setTelefone("6688998877");
            p.setCrm("123456");
            p.setEspecialidade(em.find(Especialidade.class, 1));
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
