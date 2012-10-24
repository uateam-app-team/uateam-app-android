package com.xitxer.uateam.notification.android;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.xitxer.uateam.notification.core.model.ReleaseEntry;
import com.xitxer.uateam.notification.core.parser.RecentReleasesParser;
import com.xitxer.uateam.notification.core.parser.sitesource.HttpSiteSource;
import com.xitxer.uateam.notification.core.utils.UateamSiteUtils;

public class ItemListFragment extends ListFragment {
	private static final String TAG = ItemListFragment.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RecentReleasesParser parser = new RecentReleasesParser(
				new HttpSiteSource(UateamSiteUtils.URL_BASE));
		List<ReleaseEntry> entries = null;
		try {
			entries = parser.get();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
		}
		if (entries != null) {
			setListAdapter(new ArrayAdapter<ReleaseEntry>(this.getActivity(),
					android.R.id.text1, entries));
		}
	}

	@Override
	public void onStart() {
		setEmptyText("Порожньо");
		super.onStart();
	}
}
