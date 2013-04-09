package Model;
 
import java.util.List;

import com.stackmob.sdk.model.StackMobUser;

 
public class User extends StackMobUser {
 
    private List<IdeaList> IdeaLists;

    
	public User(String username, String password) {
        super(User.class, username, password);
    }
 
    public List<IdeaList> getIdeaLists() {
        return IdeaLists;
    }
 
    public void setTasks(List<IdeaList> IdeaLists) {
        this.IdeaLists = IdeaLists;
    }
}