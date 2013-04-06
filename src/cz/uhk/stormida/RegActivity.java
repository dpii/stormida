package cz.uhk.stormida;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

public class RegActivity extends Activity {

	private EditText login, pass;
	private boolean login_exists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);

		Button reg = (Button) findViewById(R.id.reg_btReg);

		reg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				login = (EditText) findViewById(R.id.reg_tLogin);
				pass = (EditText) findViewById(R.id.reg_tPass);

				User user = new User(login.getText().toString(), pass.getText()
						.toString());

				checkUserExists(user);

				if (!login_exists) {

					user.save();

				} else {
					
					login.setText("");
					
					

				}

			}
		});

	}

	private void checkUserExists(User user) {

		User.query(User.class, new StackMobQuery().isInRange(0, 1),
				new StackMobQueryCallback<User>() {

					@Override
					public void failure(StackMobException e) {

						login_exists = true;
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
