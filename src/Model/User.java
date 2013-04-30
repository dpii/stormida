package Model;
 
import java.util.ArrayList;
import java.util.List;

import com.stackmob.sdk.model.StackMobUser;
import com.stackmob.taskmob.TaskList;

 
public class User extends StackMobUser {
 
	public User(String username, String password) {
        super(User.class, username, password);
    }
 

	private List<IdeaList> topicLists;
	
    public List<IdeaList> getIdeaLists() {
        return IdeaLists;
    }
    
    
	private List<TaskList> taskLists;
	
	public List<TaskList>  getTaskLists() {
		
 
    public void setTasks(List<IdeaList> IdeaLists) {
        this.IdeaLists = IdeaLists;
    }
}