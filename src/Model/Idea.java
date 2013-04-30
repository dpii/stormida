package Model;

import com.stackmob.sdk.model.StackMobModel;

public class Idea extends StackMobModel {

	private String text;
	private int plus;

	public Idea(String text, int plus) {
		super(Idea.class);
		this.text = text;
		this.plus = plus;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

}