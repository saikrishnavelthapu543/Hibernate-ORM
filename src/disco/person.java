package disco;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class person {
	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fkkpid")
	private passport port;
	@Override
	public String toString() {
		return "person [pid=" + pid + ", pname=" + pname + ", port=" + port + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public passport getPort() {
		return port;
	}
	public void setPort(passport port) {
		this.port = port;
	}
}
