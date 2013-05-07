package cz.uhk.stormida;

import java.util.List;

import Model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.stackmob.android.sdk.common.StackMobAndroid;
import com.stackmob.sdk.api.StackMob;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.api.StackMobQueryField;
import com.stackmob.sdk.callback.StackMobCallback;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	@ViewById(R.id.btLogin)
	Button btLogin;

	private String login, pass, login_;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		StackMobAndroid.init(getApplicationContext(), 0,
				"7a3785e2-64bd-495c-92e6-93da7d05c9c2");
		StackMob.getStackMob().getSession().getLogger().setLogging(true);

		checkLoginSession();

	}

	private void checkLoginSession() {

		if (StackMob.getStackMob().isLoggedIn()) {
			User.getLoggedInUser(User.class, new StackMobQueryCallback<User>() {
				@Override
				public void success(List<User> list) {

					goUser();
				}

				@Override
				public void failure(StackMobException e) {

				}
			});
		} else {

		}

	}

	@Click(R.id.btLogin)
	void clickLogin() {

		login = ((EditText) findViewById(R.id.tLogin)).getText().toString();
		pass = ((EditText) findViewById(R.id.tPassword)).getText().toString();

		User user = new User(login, pass);

		user.login(new StackMobCallback() {

			@Override
			public void success(String arg0) {

				showToast("Welcome back!");

				goUser();

			}

			@Override
			public void failure(StackMobException arg0) {

				showToast("Wrong username or password!");

			}
		});

	}

	@Click(R.id.btRegister)
	void clickRegister() {

		login = ((EditText) findViewById(R.id.tLogin)).getText().toString();
		pass = ((EditText) findViewById(R.id.tPassword)).getText().toString();

		checkUserExistsSave(login);

	}

	@UiThread
	void checkUserExistsSave(String login) {

		User.query(User.class, new StackMobQuery()
				.field(new StackMobQueryField("username").isEqualTo(login)),
				new StackMobQueryCallback<User>() {
					@Override
					public void success(List<User> result) {

						login_ = ((EditText) findViewById(R.id.tLogin))
								.getText().toString();
						pass = ((EditText) findViewById(R.id.tPassword))
								.getText().toString();

						if (result.size() == 0) {

							saveUser();

						} else {

							showToast("Username already exists. Try again!");
						}

					}

					@Override
					public void failure(StackMobException e) {

						showToast("Connection error!");
					}
				});

	}

	@UiThread
	void saveUser() {

		login = ((EditText) findViewById(R.id.tLogin)).getText().toString();
		pass = ((EditText) findViewById(R.id.tPassword)).getText().toString();

		User user = new User(login, pass);

		if (login.trim().equals("") || login.trim().equals("")
				|| pass.trim().equals("") || pass.trim().equals("")) {

			showToast("Please enter Login and Password!");

		} else {

			user.save();

			showToast("Account created. You can log in now!");

		}

	}

	@UiThread
	void goUser() {

		Intent goUser = new Intent(MainActivity.this, MyStorms_.class);

		startActivity(goUser);

	}

	@UiThread
	void showToast(CharSequence msg) {

		Context context = getApplicationContext();
		// CharSequence text = "Welcome back!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, msg, duration);
		toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
		toast.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add("Google it!");
		menu.add("Zavřít");
		return true;
	}

}
