package com.effision.assestment.servicelayer;

import java.util.ArrayList;
import java.util.List;

import com.effision.assestment.beans.Users;

public class UserCreation {

	private List<Users> userRecord;
	private static UserCreation usercreation = null;

	private UserCreation() {
		userRecord = new ArrayList<Users>();
	}

	public static UserCreation getInstance() {
		if (usercreation == null) {
			usercreation = new UserCreation();
			return usercreation;
		} else {
			return usercreation;
		}
	}

	public void add(Users user) {
		userRecord.add(user);
	}
	 public List<Users> getStudentRecords() {
		    return userRecord;
		    }
}
