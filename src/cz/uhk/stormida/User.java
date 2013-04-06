package cz.uhk.stormida;
 
import java.util.ArrayList;
import java.util.List;
 
import com.stackmob.sdk.model.StackMobUser;
 
public class User extends StackMobUser {
 
    private List<IdeaList> IdeaLists;
    private String login;
    private String pass;
 
    public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	protected User(String username, String password) {
        super(User.class, username, password);
    }
 
 
    public List<IdeaList> getIdeaLists() {
        return IdeaLists;
    }
 
    public void setTasks(List<IdeaList> IdeaLists) {
        this.IdeaLists = IdeaLists;
    }
}