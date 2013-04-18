package com.xitxer.uateam.notification.android.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.xitxer.uateam.notification.android.R;
import com.xitxer.uateam.notification.android.parser.SiteSourceSingletonHolder;
import com.xitxer.uateam.notification.android.ui.adapter.SectionsPagerAdapter;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
		// new ImageLoader(new HolderObtainer<Bitmap>() {
		// @Override
		// public void obtain(IHolder<Bitmap> data) {
		// if(data.successful()){
		// viewPager.setBackground(new
		// BitmapDrawable(MainActivity.this.getResources(), data.getData()));
		// }
		// }
		// }, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		SiteSourceSingletonHolder.dropSiteSource();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.manu_refresh: {
			SiteSourceSingletonHolder.dropSiteSource();
			return true;
		}
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
