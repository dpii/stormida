package Model;

import java.util.ArrayList;
import java.util.List;

import com.stackmob.sdk.model.StackMobModel;

public class Storm extends StackMobModel {

	private String title;
	private String pass;

	public Storm(String title, String pass) {
		super(Storm.class);
		this.title = title;
		this.pass = pass;
	}

	public Storm() {
		super(Storm.class);
	}

	private List<Idea> ideaList;

	public List<Idea> getIdeas() {
		if (ideaList == null) {
			ideaList = new ArrayList<Idea>();
		}
		return ideaList;
	}

	public void setIdeas(List<Idea> ideaList) {
		this.ideaList = ideaList;
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

}
