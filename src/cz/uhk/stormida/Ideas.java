package cz.uhk.stormida;

import java.util.List;

import Model.Idea;
import Model.Storm;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.stackmob.sdk.api.StackMobOptions;
import com.stackmob.sdk.api.StackMobQuery;
import com.stackmob.sdk.api.StackMobQueryField;
import com.stackmob.sdk.callback.StackMobQueryCallback;
import com.stackmob.sdk.exception.StackMobException;

@EActivity
public class Ideas extends Activity {

	private Storm storm;

	private List<Idea> ideas = null;

	private String s;

	@ViewById(R.id.lvIdeas)
	ListView lvIdeas;

	@ViewById(R.id.etIdea)
	EditText etIdea;

	@ViewById(R.id.tvTitle)
	TextView tvTitle;

	@Click(R.id.btAdd)
	void add() {

		Storm.query(Storm.class, new StackMobQuery()
				.field(new StackMobQueryField("title").isEqualTo(s)),
				StackMobOptions.depthOf(1), new StackMobQueryCallback<Storm>() {
					@Override
					public void success(List<Storm> result) {

						storm = result.get(0);

						Idea idea = new Idea(etIdea.getText().toString(), 0);

						storm.getIdeas().add(idea);

						storm.save(StackMobOptions.depthOf(1));

						clearET();

						bindData(storm.getIdeas());

					}

					@Override
					public void failure(StackMobException e) {
					}
				});

	}

	@UiThread
	void clearET() {

		etIdea.setText("");
	}

	@Click(R.id.btDownload)
	void download() {

		Storm.query(Storm.class, new StackMobQuery()
				.field(new StackMobQueryField("title").isEqualTo(s)),
				StackMobOptions.depthOf(1), new StackMobQueryCallback<Storm>() {
					@Override
					public void success(List<Storm> result) {

						Storm storm = result.get(0);

						bindData(storm.getIdeas());

					}

					@Override
					public void failure(StackMobException e) {
					}
				});

	}

	@UiThread
	void bindData(List<Idea> ideas) {

		ListAdapter adapt = new ArrayAdapter<Idea>(this,
				android.R.layout.simple_list_item_1, ideas);
		lvIdeas.setAdapter(adapt);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_idea);

		Bundle b = getIntent().getExtras();

		s = (String) b.get("storm");

		showToast(s);

		tvTitle.setText("Storm topic: " + s);
		
		
		Storm.query(Storm.class, new StackMobQuery()
		.field(new StackMobQueryField("title").isEqualTo(s)),
		StackMobOptions.depthOf(1), new StackMobQueryCallback<Storm>() {
			@Override
			public void success(List<Storm> result) {

				storm = result.get(0);

				bindData(storm.getIdeas());

			}

			@Override
			public void failure(StackMobException e) {
			}
		});
		
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.idea, menu);
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
