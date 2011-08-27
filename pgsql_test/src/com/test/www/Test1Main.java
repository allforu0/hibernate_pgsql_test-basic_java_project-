/**
 * 
 */
package com.test.www;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author 8300379
 * 
 */
public class Test1Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		/** Getting the Session Factory and session */
		Session session = util.HibernateUtil.getCurrentSession();
		/** Starting the Transaction */
		Transaction tx = session.beginTransaction();
		try {
			Test1Main test1Main = new Test1Main();
			
//			test1Main.c(session);
//			test1Main.r(session, 44);
			test1Main.rList(session);
//			test1Main.u(session, 44);
//			test1Main.d(session, 1);

			/** Commiting the changes */
			tx.commit();
			System.out.println("It's commited! ");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {

			/** Closing Session */
			// session.close();
			util.HibernateUtil.closeSession();
		}
	}

	public void c(Session session) {
		// test1 테이블 취급 시작.
		Test1 test1 = new Test1();
		test1.setText1("test text1 :) !!!");
		test1.setText2("test text2 :( !!!");
		test1.setCreated(new Date());
		//test1.setUpdated(new Date());
		session.save(test1);
	}

	public void r(Session session, int idx) {
		Test1 test1 = (Test1) session.get(Test1.class, idx); //get or load
		System.out.println("test1.toString()-> " + test1);

	}

	public void rList(Session session) {
		List<Test1> list = castList(Test1.class, session.createCriteria(Test1.class).list()); //워닝 뜨는거 싫어성.흥.ㅁ.
//		List<Test1> list = session.createCriteria(Test1.class).list();
		System.out.println("list size: " + list.size());
	}

	public void u(Session session, int idx) {
		Test1 test1 = new Test1(idx, "updated text1", "updated text2", null, new Date());
		session.update(test1);
		
	}

	public void d(Session session, int idx) {
		Test1 test1 = new Test1(idx);
		// session.createQuery("from test1");

//		test1.setIdx(
//		 ((Test1)session.createQuery("select t.idx from test1 as t order by t.idx desc limit 1 ").uniqueResult()).getIdx()
//		);
		session.delete(test1);
	}
	
	//@SuppressWarning("unchecked") 대신... 제네릭 타입.. 아흥옹흥 ㅠ
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
