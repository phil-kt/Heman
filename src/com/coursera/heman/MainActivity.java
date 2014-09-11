package com.coursera.heman;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {

	MediaPlayer mpButtonClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e("banana", "onCreate!");

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.e("banana", "onResume!");
		mpButtonClick = MediaPlayer.create(this, R.raw.hey);
		mpButtonClick.start();

		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.e("banana", "onPause!");
		mpButtonClick.stop();
		mpButtonClick.release();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buttonClick(View v) {
		mpButtonClick.start();
	}

	public void browseWeb(View v) {
		String url = "http://knowyourmeme.com/memes/he-man-sings";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}

}
