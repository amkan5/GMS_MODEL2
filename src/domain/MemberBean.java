package domain;

import lombok.Data;

@Data
public class MemberBean {
	protected String memId,name,roll,teamId,age,password,ssn;

	@Override
	public String toString() {
		return "MemberBean [memId=" + memId + ", name=" + name + ", roll=" + roll + ", teamId=" + teamId + ", age="
				+ age + ", password=" + password + "]";
	}

}
