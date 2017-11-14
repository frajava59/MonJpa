/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import monjpa.Film;
import org.junit.Test;

/**
 *
 * @author Formation
 */
public class TestJPA {

    @Test
    public void testJpa() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
//        EntityManager em = emf.createEntityManager();
//        
//        em.getTransaction().begin();
//        
//        Film film = new Film("Ratatouille", 0);
//        film.setDuree(120);
//        em.persist(film);
//        
//        em.getTransaction().commit();
//        System.out.println(film);
    }

}
