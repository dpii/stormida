package Model;

import java.util.ArrayList;
import java.util.List;


import com.stackmob.sdk.model.StackMobModel;

public class IdeaList extends StackMobModel {

	private String name;
	private List<Idea> ideas = new ArrayList<Idea>();

	public IdeaList() {
		super(IdeaList.class);
	}

	public IdeaList(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Idea> getTasks() {
		return ideas;
	}
}