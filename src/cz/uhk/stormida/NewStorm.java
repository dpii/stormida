package cz.uhk.stormida;

import Model.Topic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity
public class NewStorm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_storm);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_storm, menu);
		return true;
	}

	@ViewById(R.id.etNewStorm_name)
	EditText etName;

	@ViewById(R.id.etNewStorm_pass)
	EditText etPass;

	@Click(R.id.btNS_Create)
	void create() {

		Topic topic = new Topic(etName.getText().toString(), etPass.getText()
				.toString());

		topic.save();

		showToast("New topic created!");

		Intent goStorms = new Intent(NewStorm.this, MyStorms_.class);

		startActivity(goStorms);

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
