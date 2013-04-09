package cz.uhk.stormida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MyStorms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_storms);
		
		Intent intent = getIntent();
		String login = intent.getStringExtra("login");
		
		TextView et = (TextView) findViewById(R.id.tv_LoggedAs);
		et.setText(login);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_storms, menu);
		return true;
	}

}
