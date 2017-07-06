package doantheanh.models;

public class DatabaseManagement {
	public boolean checkUser(String userName, String password) {
		if (userName.equals("doan") && password.equals("123")) {
			return true;
		} else {
			return false;
		}
	}
}
