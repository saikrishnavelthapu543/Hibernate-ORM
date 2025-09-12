package manager;

import java.lang.reflect.Field;

public class test {

	public static void main(String[] args) throws Exception {
		//setter injection
		//devoloper d=new devoloper();
		//teamlead t=new teamlead();
		//t.setDev(d);
		//manager m=new manager();
		//m.setTl(t);
		//m.dowork();
		
		
		//constructor injection
		//devoloper d=new devoloper();
		//teamlead t=new teamlead(d);
	//	manager m=new manager(t);
		//m.dowork();
		
		
		//property injection
		devoloper d=new devoloper();
		teamlead t=new teamlead();
		manager m=new manager();
		
		Class tld=teamlead.class;
		Field f= tld.getDeclaredField("dev");
		f.setAccessible(true);
		f.set(t, d);
		//t.dowork();
		
		
		Class m1=manager.class;
		Field f1=m1.getDeclaredField("tl");
		f1.setAccessible(true);
		f1.set(m, t);
		m.dowork();
		
		
		
		
		
		
	}

}
