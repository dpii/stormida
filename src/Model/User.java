package Model;
 
import java.util.ArrayList;
import java.util.List;

import com.stackmob.sdk.model.StackMobUser;

 
public class User extends StackMobUser {
 
	public User(String username, String password) {
        super(User.class, username, password);
    }
 

	private List<TopicList> topicLists;


	public List<TopicList> getTopicLists() {
		if(topicLists == null) {
			topicLists = new ArrayList<TopicList>();
		}
		return topicLists;
	}


	public void setTopicLists(List<TopicList> topicLists) {
		this.topicLists = topicLists;
	}
	

}