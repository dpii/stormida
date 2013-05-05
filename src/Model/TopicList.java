package Model;

import java.util.ArrayList;
import java.util.List;

import com.stackmob.sdk.model.StackMobModel;

public class TopicList extends StackMobModel {

	private String name;
	private List<Topic> topics = new ArrayList<Topic>();
	
	public String getName() {
		return name;
	}
	

	public TopicList() {
		super(TopicList.class);
	}
	
	public TopicList(String name) {
		this();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	

}
