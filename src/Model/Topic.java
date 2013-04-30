package Model;

import com.stackmob.sdk.model.StackMobModel;

public class Topic extends StackMobModel {

	private String topic;
	private String pass;
	private List<Idea> ideaList;
	
	
	
	public Topic(Class<? extends StackMobModel> actualClass) {
		super(actualClass);
		
	}


	public String getTopic() {
		return topic;
	}



	public void setTopic(String topic) {
		this.topic = topic;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	
	
}
