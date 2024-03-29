package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
   public static final SessionFactory sessionFactory;

   static {
      try {
         // Create the SessionFactory from hibernate.cfg.xml
         sessionFactory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
         // Make sure you log the exception, as it might be swallowed
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

   public static Session getCurrentSession() throws HibernateException {
      Session s = session.get();
      // Open a new Session, if this thread has none yet
      if (s == null) {
         s = sessionFactory.openSession();
         // Store it in the ThreadLocal variable
         session.set(s);
      }
      return s;
   }

   public static void closeSession() throws HibernateException {
      Session s = (Session) session.get();
      if (s != null)
         s.close();
      session.set(null);
   }
}

/*
public class HibernateUtil {

private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
}*/