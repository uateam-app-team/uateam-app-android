package com.xitxer.uateam.notification.android.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.ReleaseEntryViewHandler;
import com.xitxer.uateam.notification.android.ui.fragment.base.IRefreshable;
import com.xitxer.uateam.notification.android.ui.fragment.handler.ListFragmentHandler;

public class ItemListFragment extends ListFragment implements IRefreshable {
	private ListFragmentHandler handler;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		handler.onActivityCreated();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		handler = new ListFragmentHandler(this, new ReleaseEntryViewHandler(getLayoutInflater(savedInstanceState)));
	}

	@Override
	public void refresh() {
		handler.loadContent();
	}
}
