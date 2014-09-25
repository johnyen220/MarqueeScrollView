package com.johnyen.marqueescrollview;

import java.util.ArrayList;
import java.util.List;

import johnyen.lib.MarqueeHorizontalScrollView;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String marquee1="US begins air strikes on Islamic State targets";
		String marquee2="Students to protest in HK centre";
		String marquee3="Chinese firms exporting tools of torture, says Amnesty";
		String marquee4="Obama announces US crackdown on inversion tax 'loophole'";
		List<String> marqueeStringSet=new ArrayList<String>();
		marqueeStringSet.add(marquee1);
		marqueeStringSet.add(marquee2);
		marqueeStringSet.add(marquee3);
		marqueeStringSet.add(marquee4);
		MarqueeHorizontalScrollView margueeScrollView1=(MarqueeHorizontalScrollView)findViewById(R.id.marqueeHorizontalScrollView1);
		margueeScrollView1.setIsScrollable(false);
		margueeScrollView1.setVisibility(View.VISIBLE);
		margueeScrollView1.setStringAdapter(marqueeStringSet);
		margueeScrollView1.setMarqueeTextSize(30);
		margueeScrollView1.setMarqueeTextColor(Color.BLACK);
		margueeScrollView1.startMove();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
