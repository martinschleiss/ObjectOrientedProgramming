/**
 * @version 1.1
 */

import java.util.Date;

public class Member {
	
	private String name;
	private String tel;
	private String instrument;
	private Date memberFrom;
	private Date memberUntil;
	
	public Member (String name, String tel, String instrument, Date memberFrom){
		this.name = name;
		this.tel = tel;
		this.instrument = instrument;
		this.memberFrom = memberFrom;
		this.memberUntil = null; //wird zu diesem Zeitpunkt noch nicht festgelegt
	}

	public Date getMemberFrom() {
		
		return memberFrom;
	}
	
	public Date getMemberUntil() {
		
		return memberUntil;
	}
	
	public void setMemberUntil(Date d) {
		
		memberUntil = d;
	}
	
	public String toString() {
		
		return "Name: " + name + ", Instrument: " + instrument + ", Telephone-Number: "+tel;
	}
}
