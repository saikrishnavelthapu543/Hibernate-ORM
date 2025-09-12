package disco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class passport {
	@Id
	@GeneratedValue
private int passid;
private String passnum;
@Override
	public String toString() {
		return "passport [passid=" + passid + ", passnum=" + passnum + "]";
	}
public int getPassid() {
		return passid;
	}
	public void setPassid(int passid) {
		this.passid = passid;
	}
	public String getPassnum() {
		return passnum;
	}
	public void setPassnum(String passnum) {
		this.passnum = passnum;
	}

}
