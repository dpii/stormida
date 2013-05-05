package cz.uhk.stormida;

import java.util.List;

import Model.Topic;
import Model.User;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.stackmob.sdk.api.StackMob;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.callback.StackMobModelCallback;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

@EActivity
public class MyStorms extends Activity {

	private User user;

	@ViewById(R.id.tv_LoggedAs)
	TextView lu;

	@ViewById(R.id.lvStorms)
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_storms);

		getData();

		lv.setClickable(true);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				Topic t = (Topic) lv.getItemAtPosition(position);

				Intent goIdea = new Intent(MyStorms.this, Idea_.class);

				String s = t.getTitle();
				
				goIdea.putExtra("topic", s);
				startActivity(goIdea);

			}
		});

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

	}

	@Background
	void getData() {

		Topic.query(Topic.class, new StackMobQuery().isInRange(0, 9),
				new StackMobQueryCallback<Topic>() {
					@Override
					public void success(List<Topic> result) {

						bindData(result);

					}

					@Override
					public void failure(StackMobException e) {
					}
				});

	}

	@UiThread
	void bindData(List<Topic> result) {

		ListAdapter adapt = new ArrayAdapter<Topic>(this,
				android.R.layout.simple_list_item_1, result);
		lv.setAdapter(adapt);

	}

	@UiThread
	void setLoggedUser(User user) {
		lu.setText("Logged: " + user.getUsername());
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

	@Click(R.id.btJoin)
	void join() {

		Intent goJoin = new Intent(MyStorms.this, JoinStorm_.class);
		startActivity(goJoin);

	}

	@Click(R.id.btCreate)
	void create() {

		Intent goCreate = new Intent(MyStorms.this, NewStorm_.class);
		startActivity(goCreate);

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
