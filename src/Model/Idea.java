package Model;

import com.stackmob.sdk.model.StackMobModel;

public class Idea extends StackMobModel {

	private String text;
	private String pass;

	public Idea(Class<? extends StackMobModel> actualClass, String text,
			String pass, int plus) {
		super(actualClass);
		this.text = text;
		this.pass = pass;
		this.plus = plus;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	private int plus;

	public Idea(String text, int plus) {
		super(Idea.class);
		this.text = text;
		this.plus = 0;
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