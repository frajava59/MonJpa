/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import monjpa.Film;
import monjpa.Genre;
import org.junit.Test;

/**
 *
 * @author Formation
 */
public class TestJPA {

    @Test
    public void testJpa1() {

        Film film1, film2;
        Genre genre1, genre2, genre3;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        film1 = new Film("Ratatouille", 120);
        genre1 = new Genre("Animé");

        em.persist(genre1);
        film1.getGenres().add(genre1);
        em.persist(film1);

        film2 = new Film("Hobbit", 200);
        genre2 = new Genre("Fantastique");
        em.persist(genre2);
        genre3 = new Genre("Avgroirtoure");
        em.persist(genre3);
//        genre3 = new Genre("Aventure");
        genre3 = em.merge(genre3);
        genre3.setTypeGenre("Aventure");

        film2.getGenres().add(genre2);
        film2.getGenres().add(genre3);
        em.persist(film2);
        
        genre1 = em.find(Genre.class,3l); 
        System.out.println("genre avec find "+genre1);

        em.getTransaction().commit();

        System.out.println(genre1);
        System.out.println(film1);
        System.out.println(genre2);
        System.out.println(film2);
        for (Genre genre : film2.getGenres()) {
            System.out.println(genre.getTypeGenre());
        }
        


    }

    //@Test
    public void testJpaDelete() {

        Film film1, film2;
        Genre genre1, genre2, genre3;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        genre1 = em.find(Genre.class,3); 
        System.out.println(genre1);

     
    }

}
