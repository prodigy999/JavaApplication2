package jpatest.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jpatest.entity.Joueur;
import jpatest.entity.Quiz;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpatest.entity.Question;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author admin
 */
public class TesJjunit {
    
    @Before
    public void avant() {
        
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        
        em.getTransaction().begin();

        // supprime tous les quizz
        Query query3 = em.createQuery("DELETE FROM Question");
        query3.executeUpdate();
        Query query = em.createQuery("DELETE FROM Quiz");
        query.executeUpdate();
        Query query2 = em.createQuery("DELETE FROM Joueur");
        query2.executeUpdate();
        

        //persiste joueur 1 
        Joueur joueur1 = new Joueur();
        joueur1.setId(1L);
        joueur1.setLogin("david");
        joueur1.setMdp("hh");
        joueur1.setEmail("ufufabafabefub");
        em.persist(joueur1);

        //persiste joueur 2
        Joueur joueur2 = new Joueur();
        joueur2.setId(2L);
        joueur2.setLogin("tom");
        joueur2.setMdp("hhh");
        joueur2.setEmail("ufufabafabefuhehhjehjb");
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
        quiz1.getQuestions().add(question1);
        em.persist(question1);

        //persiste question 2
        Question question2 = new Question();        
        question2.setQuiz(quiz2);
        question2.setId(2L);
        quiz2.getQuestions().add(question2);
        
        em.persist(question2);
        
        em.getTransaction().commit();
    }

    @Test
    public void test() {
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        
    }
    
    @Test
    public void verifQueJoueurDuQuiz1EstTomOk() {
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        
        Quiz quiz = em.find(Quiz.class, 1L);
        Joueur joueur = quiz.getJoueur();
        String login = joueur.getLogin();
        Assert.assertEquals("david", login);
        /*
        Assert.assertEquals("david", quiz.getJoueur().getLogin());
        */
    }
    
    @Test
    public void verifQueJoueurDeQuestion1EstTomOk() {
        EntityManager em = Persistence.createEntityManagerFactory("JpaTest2").createEntityManager();
        Question question = em.find(Question.class, 1L);
        Assert.assertEquals("david", question.getQuiz().getJoueur().getLogin());
        
    }
}
