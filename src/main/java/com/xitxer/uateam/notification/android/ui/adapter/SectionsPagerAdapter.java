package com.xitxer.uateam.notification.android.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xitxer.uateam.notification.android.ui.fragment.ItemListFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return 1;
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
		case 0:
			return new ItemListFragment();
		default:
			return null;
		}
	}
}
