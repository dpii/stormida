package cz.uhk.stormida;

import java.util.List;

import Model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.stackmob.sdk.api.StackMob;
import com.stackmob.sdk.callback.StackMobModelCallback;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

@EActivity
public class MyStorms extends Activity {

	private User user;

	@ViewById(R.id.tv_LoggedAs)
	TextView lu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_storms);

		final Handler handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				// msg.getData().getString("jm"));

			}

		};

		if (StackMob.getStackMob().isLoggedIn()) {
			User.getLoggedInUser(User.class, new StackMobQueryCallback<User>() {
				@Override
				public void success(List<User> list) {
					user = list.get(0);
					setLoggedUser(user);
				}

				@Override
				public void failure(StackMobException e) {

				}
			});
		} else {

		}

		getData();

	}

	private void getData() {

	}

	@UiThread
	void setLoggedUser(User user) {
			lu.setText(user.getUsername());
	}

	@Click(R.id.btLogout)
	void logout() {

		user.logout(new StackMobModelCallback() {

			@Override
			public void success() {

				showToast("Logged out!");
				goAnon();
			}

			@Override
			public void failure(StackMobException e) {
				showToast("Error! Cant logout now.");
			}
		});

	}

	@UiThread
	void goAnon() {

		Intent goAnon = new Intent(MyStorms.this, MainActivity_.class);

		startActivity(goAnon);

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
