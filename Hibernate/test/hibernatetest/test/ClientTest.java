/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatetest.test;

import hibernatetest.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class ClientTest {
    
    @Test
    public void test1 (){
        
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        
        Query query = s.createQuery("SELECT c FROM Client c").setFirstResult(0).setMaxResults(50);
        
        System.out.println(query.list());
    }
}
