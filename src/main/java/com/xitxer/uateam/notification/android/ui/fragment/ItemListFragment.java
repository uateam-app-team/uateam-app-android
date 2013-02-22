package com.xitxer.uateam.notification.android.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.ReleaseEntryViewHandler;
import com.xitxer.uateam.notification.android.ui.fragment.handler.ListFragmentHandler;

public class ItemListFragment extends ListFragment {
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		new ListFragmentHandler(this, new ReleaseEntryViewHandler(getLayoutInflater(savedInstanceState))).onActivityCreated();
	}
}
