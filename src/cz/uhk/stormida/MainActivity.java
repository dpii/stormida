package cz.uhk.stormida;

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

import com.stackmob.android.sdk.common.StackMobAndroid;
import com.stackmob.sdk.callback.StackMobModelCallback;
import com.stackmob.sdk.exception.StackMobException;

public class MainActivity extends Activity {

	private String login, pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StackMobAndroid.init(getApplicationContext(), 0,
				"7a3785e2-64bd-495c-92e6-93da7d05c9c2");

		String[] tlacitka = { "btLogin", "btRegister" };

		View.OnClickListener myListener = new View.OnClickListener() {

			public void onClick(View v) {

				switch (v.getId()) {

				case R.id.btLogin:

					Button b_login = (Button) findViewById(R.id.btLogin);

					b_login.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							login = ((EditText) findViewById(R.id.tLogin))
									.getText().toString();
							pass = ((EditText) findViewById(R.id.tPassword))
									.getText().toString();

							User user = new User(login, pass);
							user.login(new StackMobModelCallback() {

								@Override
								public void success() {

									Context context = getApplicationContext();
									CharSequence text = "Welcome back!";
									int duration = Toast.LENGTH_SHORT;

									Toast toast = Toast.makeText(context, text,
											duration);
									toast.setGravity(Gravity.CENTER
											| Gravity.CENTER, 0, 0);
									toast.show();

									Intent goUser = new Intent(
											MainActivity.this, MyStorms.class);
									goUser.putExtra("login", login);
									startActivity(goUser);

								}

								@Override
								public void failure(StackMobException e) {

									Context context = getApplicationContext();
									CharSequence text = "Login or Password is incorrect. Plase try again!";
									int duration = Toast.LENGTH_SHORT;

									Toast toast = Toast.makeText(context, text,
											duration);
									toast.setGravity(Gravity.CENTER
											| Gravity.CENTER, 0, 0);
									toast.show();

								}
							});

						}
					});

					break;

				case R.id.btRegister:

					Intent reg = new Intent(MainActivity.this,
							RegActivity.class);

					reg.putExtra("test", 1000);
					startActivity(reg);

					break;

				}

			}
		};

		for (String s : tlacitka) {

			int resId = getResources().getIdentifier(s, "id", getPackageName());

			Button b = (Button) findViewById(resId);
			b.setOnClickListener(myListener);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add("Google it!");
		menu.add("Zavřít");
		return true;
	}

	/*
	 * public boolean onOptionsItemSelected(Menu.Item item) {
	 * 
	 * 
	 * switch (item.getId()){ case 0: break; case 1: break;
	 * 
	 * }
	 * 
	 * return true;
	 * 
	 * }
	 */

}
