package cz.uhk.stormida;

import com.stackmob.sdk.model.StackMobModel;
 
public class Idea extends StackMobModel {
 
  
    private String text;
    private int plus;

 
    public Idea(String text, int plus) {
        super(Idea.class);
        this.text = text;
        this.plus = 0;
    }
}