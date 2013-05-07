package Model;

import java.util.ArrayList;
import java.util.List;

import com.stackmob.sdk.model.StackMobUser;

public class User extends StackMobUser {

	public User(String username, String password) {
		super(User.class, username, password);
	}
	private List<Storm> stormList;

	
	public List<Storm> getStorms() {
		if (stormList == null) {
			stormList = new ArrayList<Storm>();
		}
		return stormList;
	}

	public void setTopics(List<Storm> stormList) {
		this.stormList = stormList;
	}

}