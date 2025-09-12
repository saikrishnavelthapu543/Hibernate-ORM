package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class getconnection {

	public static Session getconnection()
	{
		Configuration con=new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		SessionFactory s=con.buildSessionFactory();	
		Session se=s.openSession();
		return se;
		}
}
