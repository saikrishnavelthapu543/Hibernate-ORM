package cisco;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import antlr.collections.List;
public class employeecontroller {
	public static Session getconnection()
	{
		Configuration con=new AnnotationConfiguration();
		con.configure("hibernate.cfg.xml");
		SessionFactory s=con.buildSessionFactory();	
		Session se=s.openSession();
		return se;
		}
	public void saveempdata(employee emp)
	{
		System.out.println("save operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//to transfer data from from java to database
		Transaction t=se.beginTransaction();
		//save methods internally calls insert method given by hibernate
		se.save(emp);
		//to execute the info into database
		t.commit();
		se.close();
		System.out.println("save operation ended");
	}
	public void getbyid(int eid)
	{
		//to get info by id
		System.out.println("getbyid operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//type casting
		//in this case there is no need of transaction process due to it retrieves th data not inserts
		//GET METHOD RETREIVES DATA FROM DATA BASE THROWS NULL IF NOT EXISTS
		//LOAD METHOD RETRIEVES DATA FROM DATA BASE AS AN OBJECT SO IT THROWS OBJECT NOT FOUND EXCEPTION
		employee emp=(employee) se.get(employee.class, eid);
		//employee emp=(employee) se.load(employee.class, eid);
		
		System.out.println(emp);
		se.close();
		System.out.println("getbyid operation ended");
	}
	public void delete(int eid)
	{
		//to get info by id
		System.out.println("delete operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//transaction is mandatory to alter the table
		Transaction t=se.beginTransaction();
		//type casting
		//in this case there is no need of transaction process due to it retrieves th data not inserts
		employee emp=(employee) se.get(employee.class, eid);
		System.out.println(emp);
		se.delete(emp);
		t.commit();
		se.close();
		System.out.println("delete operation ended");
	}
	public void update(int eid)
	{
		//to update
		System.out.println("update operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//transaction is mandatory to alter the table
		Transaction t=se.beginTransaction();
		//type casting
		//in this case there is no need of transaction process due to it retrieves the data not inserts
		employee emp=(employee) se.get(employee.class, eid);
		System.out.println(emp);
		emp.setEdesg("AWS devops engineer");
		se.update(emp);
		t.commit();
		se.close();
		System.out.println(" operation ended");
	}
	/**
	 * 
	 */
	public void getall()
	{
		//get total data from database
		System.out.println("getall operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//to write our own  query to retrieve overall data
		Query q=se.createQuery("from employee");
		//data that was retrieved should be a list of objects(in the sense rows)
		java.util.List<employee> data =q.list();
		//using for each to retrieve overall data from list
		for(employee v:data)
		{
			System.out.println(v);
		}
		System.out.println("getall operation ended");
	}
	public void get()
	{
		//get get selected column data from database
		System.out.println("get operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//to write our own  query to retrieve selected column  data
		//all sql operations are applicable in this query like where clause,group by ,order by,aggregatory functions
		//hql query
		Query q=se.createQuery("select eid,ename,esal from employee");
		//data that was retrieved should be a list of objects arrays [](in the sense columns)
		java.util.List<Object[]> data =q.list();
		//using for each to retrieve overall data from list
		//to print values of selected column in the form of objectarray the data could retrieved by index 
		for(Object[] v:data)
		{
			System.out.println(v[0]+","+v[1]+","+v[2]);
		}
		System.out.println("get operation ended");
	}
	public void getbyname(String ename)
	{
		//to get dynamic values 
		//get get selected column data from database
		System.out.println("getbyname operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//to write our own  query to retrieve selected column  data
		//all sql operations are applicable in this query like where clause,group by ,order by,aggregatory functions
		//hql query
		Query q=se.createQuery("select eid,ename,esal from employee where ename=:name");
		q.setParameter("name",ename);
		//data that was retrieved should be a list of objects arrays [](in the sense columns)
		java.util.List<Object[]> data =q.list();
		//using for each to retrieve overall data from list
		//to print values of selected column in the form of object array the data could retrieved by index 
		for(Object[] v:data)
		{
			System.out.println(v[0]+","+v[1]+","+v[2]);
		}
		System.out.println("getbyname operation ended");
	}
	public void updatehq(double esal,int eid)
	{
		//to update dynamically
		System.out.println("updatehq operation started");
		//getting connection to java via hibernate to database by session
		Session se=employeecontroller.getconnection();
		//transaction is mandatory to alter the table
		Transaction t=se.beginTransaction();
		//type casting
		//in this case there is no need of transaction process due to it retrieves the data not inserts
		Query q=se.createQuery("update employee set esal=:sal where eid=:id");
		q.setParameter("sal",esal);
		q.setParameter("id",eid);
		q.executeUpdate();
		t.commit();
		se.close();
		System.out.println("updatehq operation ended");
	}

}
