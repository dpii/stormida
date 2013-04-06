package cz.uhk.stormida;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.stackmob.android.sdk.common.StackMobAndroid;

public class MainActivity extends Activity {

	private String spass, slogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StackMobAndroid.init(getApplicationContext(), 0, "7a3785e2-64bd-495c-92e6-93da7d05c9c2");
		

		String[] tlacitka = { "btLogin", "btRegister" };

		View.OnClickListener myListener = new View.OnClickListener() {

			
			
			

			public void onClick(View v) {

				switch (v.getId()) {

				case R.id.btLogin:
					
					break;

				case R.id.btRegister:
					
					Intent reg = new Intent(MainActivity.this, RegActivity.class);
					
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
		
		
		EditText login = (EditText) findViewById(R.id.tLogin);
		EditText pass = (EditText) findViewById(R.id.tPassword);
		
		slogin = login.getText().toString();
		spass = pass.getText().toString();

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
	public boolean onOptionsItemSelected(Menu.Item item)	{


		switch (item.getId()){
			case 0: break;
			case 1: break;
	
		}
	
	return true;

	}*/

}
