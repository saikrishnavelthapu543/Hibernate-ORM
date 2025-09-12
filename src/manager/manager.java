package manager;
public class manager {
private teamlead tl;
	//injection is done by three methods
	//1.setter injection
	public void setTl(teamlead tl) {
	this.tl = tl;
}
	//constructor injection
//	public manager(teamlead tl) {		
//		this.tl = tl;
//		}

	public void dowork()
	{
		System.out.println("manager work started");
		tl.dowork();
		System.out.println("manager work ended");
	}
}
