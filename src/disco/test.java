package disco;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cisco.employee;
import utility.getconnection;

public class test {

	public void savedata(person p)
	{
		System.out.println("save operation started");
		//getting connection to java via hibernate to database by session
		Session se=getconnection.getconnection();
		//to transfer data from from java to database
		Transaction t=se.beginTransaction();
		//save methods internally calls insert method given by hibernate
		se.save(p);
		//to execute the info into database
		t.commit();
		se.close();
		System.out.println("save operation ended");
	}
	public static void main(String[] args) {
		test t=new test();
		person p=new person();
		p.setPname("saikrishna");
		
		passport pp=new passport();
		pp.setPassnum("RYI376");
		p.setPort(pp);
		
		t.savedata(p);

	}

}
