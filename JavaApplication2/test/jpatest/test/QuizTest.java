/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpatest.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpatest.entity.Joueur;
import jpatest.entity.NumSecu;
import jpatest.entity.Question;
import jpatest.entity.Quiz;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author admin
 */
public class QuizTest {
    
    @Before
    public void avant() {
        
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        
        em.getTransaction().begin();

        // supprime tous les questions
        Query query3 = em.createQuery("DELETE FROM Question");
        query3.executeUpdate();
        // supprime tous les quizz
        Query query = em.createQuery("DELETE FROM Quiz");
        query.executeUpdate();
        // supprime tous les joueur
        Query query2 = em.createQuery("DELETE FROM Joueur");
        query2.executeUpdate();
        // supprime tous les NumSecu
        Query query4 = em.createQuery("DELETE FROM NumSecu");
        query4.executeUpdate();
        
        NumSecu numSecu1 = new NumSecu();
        numSecu1.setNumSecu("2123165454647");
        em.persist(numSecu1);
        
        NumSecu numSecu2 = new NumSecu();
        numSecu2.setNumSecu("165458489748979");
        em.persist(numSecu2);
        
        //persiste joueur 1 
        Joueur joueur1 = new Joueur();
        joueur1.setId(1L);
        joueur1.setLogin("david");
        joueur1.setMdp("hh");
        joueur1.setEmail("ufufabafabefub");
        joueur1.setNumSecu(numSecu1);
        numSecu1.setJoueur(joueur1);
        em.persist(joueur1);

        //persiste joueur 2
        Joueur joueur2 = new Joueur();
        joueur2.setId(2L);
        joueur2.setLogin("tom");
        joueur2.setMdp("hhh");
        joueur2.setEmail("ufufabafabefuhehhjehjb");
        joueur2.setNumSecu(numSecu2);
        numSecu2.setJoueur(joueur2);
        em.persist(joueur2);

        //persiste quiz 1
        Quiz quiz1 = new Quiz();
        quiz1.setId(1L);
        quiz1.setJoueur(joueur1);
        em.persist(quiz1);

        //persiste quiz 2
        Quiz quiz2 = new Quiz();
        quiz2.setId(2L);
        quiz2.setJoueur(joueur2);
        em.persist(quiz2);

        //persiste question 1
        Question question1 = new Question();
        question1.setQuiz(quiz1);
        question1.setId(1L);
        em.persist(question1);

        //persiste question 2
        Question question2 = new Question();        
        question2.setQuiz(quiz2);
        question2.setId(2L);
        em.persist(question2);
        
        
        
        
        
        em.getTransaction().commit();
    }
    
    
    @Test
    public void questionAssocieeQuiz1(){
    
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        
        Quiz quiz = em.find(Quiz.class, 1L);
        Assert.assertEquals(0, quiz.getQuestions().size());
    }
    
    @Test
    public void bonNumSecu(){
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        joueur j = em.find(j, em)
        Assert.assertEquals(numSecu, this);
        
    }
}

