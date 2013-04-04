package cz.uhk.stormida;

import java.util.Date;
import com.stackmob.sdk.model.StackMobModel;
 
public class Task extends StackMobModel {
 
    private String name;
    private Date dueDate;
    private int priority;
    private boolean done;
    private String description;
 
    public Task(String name, Date dueDate, String description) {
        super(Task.class);
        this.name = name;
        this.dueDate = dueDate;
        this.priority = 0;
        this.done = false;
        this.description = description;
    }
}