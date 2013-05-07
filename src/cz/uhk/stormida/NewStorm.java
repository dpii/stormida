package cz.uhk.stormida;

import java.util.List;

import Model.Storm;
import Model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.stackmob.sdk.api.StackMob;
import com.stackmob.sdk.api.StackMobOptions;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.api.StackMobQueryField;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

@EActivity
public class NewStorm extends Activity {

	private String title, pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_storm);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.new_storm, menu);
		return true;
	}

	@ViewById(R.id.etNewStorm_name)
	EditText etTitle;

	@ViewById(R.id.etNewStorm_pass)
	EditText etPass;

	@Click(R.id.btNS_Create)
	void create() {

		Storm.query(Storm.class, new StackMobQuery()
				.field(new StackMobQueryField("title").isEqualTo(etTitle
						.getText().toString())),
				new StackMobQueryCallback<Storm>() {
					@Override
					public void success(List<Storm> result) {

						if (result.size() == 0) {

							saveTopic();

						} else {

							showToast("Name already exists! Try again!");

						}

					}

					@Override
					public void failure(StackMobException e) {

						showToast("Connection error");
					}
				});

	}

	@UiThread
	void saveTopic() {

		title = etTitle.getText().toString();
		pass = etPass.getText().toString();

		if (title.trim().equals("") || title.trim().equals("")
				|| pass.trim().equals("") || pass.trim().equals("")) {

			showToast("Please enter Title and Password!");

		} else {

			final Storm topic = new Storm(title, pass);

			if (StackMob.getStackMob().isLoggedIn()) {
				User.getLoggedInUser(User.class,
						new StackMobQueryCallback<User>() {
							@Override
							public void success(List<User> list) {
								User user = list.get(0);

								user.getStorms().add(topic);

								user.save(StackMobOptions.depthOf(1));

								showToast("New Storm created!");

								Intent goStorms = new Intent(NewStorm.this,
										MyStorms_.class);
								startActivity(goStorms);

							}

							@Override
							public void failure(StackMobException e) {

							}
						});
			} else {

			}

		}

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
