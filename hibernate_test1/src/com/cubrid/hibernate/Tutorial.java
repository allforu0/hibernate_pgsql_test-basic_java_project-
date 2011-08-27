package com.cubrid.hibernate;

import org.hibernate.Session;
import java.util.List;
import java.util.Iterator;
import com.cubrid.hibernate.HibernateUtil;

public class Tutorial {
	public static void main(String[] args) {
		System.out.println("Tutorial is starting");

		// Selecting rows
		Session session = HibernateUtil.getSession();
		List<Country> countries = session.createCriteria(Country.class).list();
		
		System.out.println(countries.size() + " list size!!");
		
		Iterator<Country> it = countries.iterator();

		
		System.out.println(it.toString() + " it.toString() !!");
		
		
		System.out.println("while start");
		while(it.hasNext()) {
			Country country = it.next();
			System.out.println("> "+country.getCode()+" <");
		}
		System.out.println("while end");
	}
}