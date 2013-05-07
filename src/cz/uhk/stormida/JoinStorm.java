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
import android.widget.EditText;
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
public class JoinStorm extends Activity {

	private String name, pass;
	private Storm storm;

	@ViewById(R.id.etTitle)
	EditText etTitle;

	@ViewById(R.id.etPass)
	EditText etPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_storm);

	}

	// EXISTUJE?
	// JE SPRAVNE HESLO?
	// ULOZ

	@Click(R.id.btJoinStorm)
	void joinStorm() {

		name = etTitle.getText().toString();
		pass = etPass.getText().toString();

		Storm.query(Storm.class, new StackMobQuery()
				.field(new StackMobQueryField("title").isEqualTo(name)),
				new StackMobQueryCallback<Storm>() {
					@Override
					public void success(List<Storm> result) {

						if (result.size() == 0) {

							showToast("Wrong name or password! Try again!");

						} else {

							storm = result.get(0);

							checkPass(storm);

						}

					}

					@Override
					public void failure(StackMobException e) {
					}
				});

	}

	@UiThread
	void checkPass(Storm storm) {

		name = etTitle.getText().toString();
		pass = etPass.getText().toString();

		if (pass.equals(storm.getPass())) {

			if (StackMob.getStackMob().isLoggedIn()) {
				User.getLoggedInUser(User.class,
						new StackMobQueryCallback<User>() {
							@Override
							public void success(List<User> list) {

								User loggedInUser = list.get(0);

								saveTopic(loggedInUser);
							}

							@Override
							public void failure(StackMobException e) {

							}
						});
			} else {
				Intent i = new Intent(JoinStorm.this, MainActivity_.class);

				startActivity(i);
			}

		} else {

			showToast("Wrong name or password! Try again!");

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.join_storm, menu);
		return true;
	}

	@UiThread
	void saveTopic(User loggedInUser) {

		loggedInUser.getStorms().add(storm);

		loggedInUser.save(StackMobOptions.depthOf(1));

		showToast("You joined Storm: " + storm.getTitle());

		startActivity(new Intent(JoinStorm.this, MyStorms_.class));
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
