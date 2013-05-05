package Model;

import java.util.List;

import com.stackmob.sdk.model.StackMobModel;

public class Topic extends StackMobModel {

	private String title;
	private String pass;
	private List<Idea> ideaList;
	
	
	
	public Topic(String title, String pass) {
		super(Topic.class);
		this.title = title;
		this.pass = pass;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		
		return title + "";
	}


	public List<Idea> getIdeaList() {
		return ideaList;
	}


	public void setIdeaList(List<Idea> ideaList) {
		this.ideaList = ideaList;
	}

	
	


	
	
}
