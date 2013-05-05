package cz.uhk.stormida;

import java.util.List;

import Model.Topic;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.api.StackMobQueryField;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

@EActivity
public class JoinStorm extends Activity {

	private String name, pass;
	private Topic topic;

	@ViewById(R.id.etNewStorm_name)
	EditText etName;

	@ViewById(R.id.etNewStorm_pass)
	EditText etPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_storm);

	}

	@Click(R.id.btJoinStorm)
	void joinStorm() {

		name = etName.getText().toString();
		pass = etPass.getText().toString();

		Topic.query(Topic.class, new StackMobQuery()
				.field(new StackMobQueryField("name").isEqualTo(name)),
				new StackMobQueryCallback<Topic>() {
					@Override
					public void success(List<Topic> result) {

						topic = result.get(0);

						checkPass(topic);

					}

					@Override
					public void failure(StackMobException e) {
					}
				});

		if (topic != null) {

			Topic.query(Topic.class, new StackMobQuery()
					.field(new StackMobQueryField("name").isEqualTo(name)),
					new StackMobQueryCallback<Topic>() {
						@Override
						public void success(List<Topic> result) {

							topic = result.get(0);

						}

						@Override
						public void failure(StackMobException e) {
						}
					});

		} else {

		}

	}

	@Background
	void checkPass(Topic Topic) {
		
		
		name = etName.getText().toString();
		pass = etPass.getText().toString();
		
		
		if (pass.equals(topic.getPass())){
			
			showToast("You added " + topic.getTitle());
			
		}

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.join_storm, menu);
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
