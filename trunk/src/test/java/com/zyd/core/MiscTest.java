package com.zyd.core;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;

import com.zyd.ATestUtil;
import com.zyd.core.db.HibernateUtil;

import junit.framework.TestCase;

public class MiscTest extends TestCase {

    public void testUtil() {
        String[] domains = new String[] { 
                "http://www.abc.com", "abc.com",
                "http://www.abc.com.cn", "abc.com.cn",
                "http://abc.com", "abc.com",
                "http://abc.com.cn", "abc.com.cn",
                "http://ww.abc.com.cn", "ww.abc.com.cn",
                "http://ww.abc.com.cn:8010", "ww.abc.com.cn:8010",
                "http://127.0.0.1:8080/refererurl_0", "127.0.0.1:8080",
                "ftp://www.abc.com.cn", null,
                "http://29xdomain.com/s1002172", "29xdomain.com",
                "http://9xdomain.com/s1002172", "9xdomain.com"
                
                };
        for (int i = 0; i < domains.length; i++) {
            assertEquals(domains[i + 1], Utils.getShortestDomain(domains[i]));
            i++;
        }
    }
    public void testHibernateContainsEntity()throws Exception{
        ATestUtil.setUpSpring();
        System.out.println(HibernateUtil.getSessionFactory().getClassMetadata("Restaurant"));
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Criteria c = session.createCriteria("Restaurant");
        c.setMaxResults(10);
        System.out.println(c.list());                
    }
}