package cz.uhk.stormida;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity
public class Idea extends Activity {

	
	private String topic;
	
	@ViewById(R.id.lvIdeas)
	ListView lvIdeas;
	
	
	@Click(R.id.btAdd)
	void add(){
		
		
		
		
	}
	
	@Click(R.id.btDownload)
	void download(){
		
		
		
		
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_idea);
		
		
		Bundle b = getIntent().getExtras();
		
		String s = (String) b.get("topic");
		
		showToast(s);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.idea, menu);
		return true;
	}
	
	@UiThread
	void showToast(CharSequence msg) {

		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, msg, duration);
		toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
		toast.show();

	}

}
