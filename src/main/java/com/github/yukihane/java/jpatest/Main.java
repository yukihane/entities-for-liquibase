package com.github.yukihane.java.jpatest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author yuki
 */
public class Main {

    private void tranExec(EntityManager m) {
        Organization org = new Organization();
        org.setName("ある組織");

        Member mem = new Member();
        mem.setName("メンバー1");

        org.addMember(mem);

        m.persist(org);
    }

    private void execute(EntityManager m) {
        EntityTransaction tx = m.getTransaction();
        tx.begin();

        try {
            tranExec(m);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("myPU");
        EntityManager m = f.createEntityManager();

        try {
            new Main().execute(m);
        } finally {
            m.close();
            f.close();
        }
    }
}
