package manager;
public class teamlead {
private devoloper dev;
public void dowork()
{
	System.out.println("teamlead work started");
	dev.dowork();
	System.out.println("teamlead work ended");
}
//public teamlead(devoloper dev)
//{
//	this.dev=dev;
//	}
public void setDev(devoloper dev) {
	this.dev = dev;
}
}
