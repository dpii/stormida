package cz.uhk.stormida;

import java.util.List;

import Model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

public class RegActivity extends Activity {

	private String login, pass;
	private boolean login_exists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);

		Button b_reg = (Button) findViewById(R.id.reg_btReg);

		b_reg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				login = ((EditText) findViewById(R.id.reg_tLogin)).getText()
						.toString();
				pass = ((EditText) findViewById(R.id.reg_tPass)).getText()
						.toString();

				User user = new User(login, pass);

				checkUserExists(login);

				if (!login_exists) {

					user.save();

					Context context = getApplicationContext();
					CharSequence text = "New user created!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
					toast.show();

					Intent main = new Intent(RegActivity.this,
							MainActivity.class);

					startActivity(main);

				} else {

					Context context = getApplicationContext();
					CharSequence text = "Login already used. Please try again!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
					toast.show();

				}

			}
		});

		

	}

	private void checkUserExists(String login) {

		User.query(User.class,
				new StackMobQuery().fieldIsEqualTo("username", login),
				new StackMobQueryCallback<User>() {

					@Override
					public void failure(StackMobException e) {

						Context context = getApplicationContext();
						CharSequence text = "Connection Error!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
						toast.show();

					}

					@Override
					public void success(List<User> result) {

						if (result.size() == 0) {

							login_exists = false;

						} else {

							login_exists = true;

						}

					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg, menu);
		return true;
	}

}
