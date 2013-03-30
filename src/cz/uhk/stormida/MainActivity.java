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

	String retezec = "";
	String sq = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StackMobAndroid.init(getApplicationContext(), 0, "7a3785e2-64bd-495c-92e6-93da7d05c9c2");
		
		
		Task myTask = new Task("Learn more about StackMob", new Date());
		myTask.save();

		String[] tlacitka = { "button1", "button2", "button3", "buttonplus",
				"button4", "button5", "button6", "buttonminus", "button7",
				"button8", "button9", "buttondiv", "button0", "buttondot",
				"buttoneq", "buttonmul", "buttonb" };

		View.OnClickListener myListener = new View.OnClickListener() {

			EditText et = (EditText) findViewById(R.id.editText1);

			public void onClick(View v) {

				switch (v.getId()) {

				case R.id.button1:
					retezec = retezec + "1";
					break;

				case R.id.button2:
					retezec = retezec + "2";
					break;

				case R.id.button3:
					retezec = retezec + "3";
					break;

				case R.id.buttonplus:
					retezec = retezec + "+";
					break;

				// druhy radek

				case R.id.button4:
					retezec = retezec + "4";
					break;

				case R.id.button5:
					retezec = retezec + "5";
					break;

				case R.id.button6:
					retezec = retezec + "6";
					break;

				case R.id.buttonminus:
					retezec = retezec + "-";
					break;

				// treti radek
				case R.id.button7:
					retezec = retezec + "7";
					break;

				case R.id.button8:
					retezec = retezec + "8";
					break;

				case R.id.button9:
					retezec = retezec + "9";
					break;

				case R.id.buttondiv:
					retezec = retezec + "/";
					break;

				// ctvrty radek

				case R.id.button0:
					retezec = retezec + "0";
					break;

				case R.id.buttondot:
					retezec = "";
					break;

				case R.id.buttoneq:

					Procesor kalkul = new JednoduchyProcesor();
					retezec += "=" + kalkul.getVysledek(retezec);
					break;

				case R.id.buttonmul:
					retezec = retezec + "*";

					break;

				case R.id.buttonb:

					Uri uri = Uri.parse("http://www.google.cz/#q=" + retezec);
					Intent browser = new Intent(Intent.ACTION_VIEW, uri);

					startActivity(browser);

					break;

				}
				et.setText(retezec);

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
	public boolean onOptionsItemSelected(Menu.Item item)	{


		switch (item.getId()){
			case 0: break;
			case 1: break;
	
		}
	
	return true;

	}*/

}
