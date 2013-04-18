package com.xitxer.uateam.notification.android.ui.fragment.handler;

import java.util.List;

import android.support.v4.app.ListFragment;
import android.widget.ListAdapter;

import com.google.common.base.Preconditions;
import com.xitxer.uateam.notification.android.task.RecentReleaseLinksLoader;
import com.xitxer.uateam.notification.android.task.RecentReleaseLoader;
import com.xitxer.uateam.notification.android.task.base.holder.IHolder;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.android.ui.fragment.adapter.SimpleListAdapter;
import com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.base.IViewHandler;
import com.xitxer.uateam.notification.core.model.ReleaseEntry;

public class ListFragmentHandler implements HolderObtainer<List<ReleaseEntry>> {
	private static final String TAG = ListFragmentHandler.class.getSimpleName();

	private final ListFragment fragment;
	private final IViewHandler<ReleaseEntry> viewHandler;

	public ListFragmentHandler(ListFragment fragment, IViewHandler<ReleaseEntry> viewHandler) {
		super();
		this.fragment = Preconditions.checkNotNull(fragment, "fragment == null");
		this.viewHandler = Preconditions.checkNotNull(viewHandler, "viewHandler == null");
	}

	public ListAdapter createListAdapter(List<ReleaseEntry> list) {
		return SimpleListAdapter.make(list, viewHandler);
	}

	public void loadContent() {
		new RecentReleaseLoader(this).execute();
	}

	public void loadLinks(List<ReleaseEntry> entries){
		new RecentReleaseLinksLoader(new HolderObtainer<Void>() {
			@Override
			public void obtain(IHolder<Void> data) {
			}
		}).execute(entries.toArray(new ReleaseEntry[] {}));
	}

	@Override
	public void obtain(IHolder<List<ReleaseEntry>> data) {
		if (data.successful()) {
			fragment.setListAdapter(createListAdapter(data.getData()));
			loadLinks(data.getData());
		} else {
			fragment.setEmptyText(data.getException().getMessage());
			fragment.setListAdapter(createListAdapter(null));
		}
	}

	public void onActivityCreated() {
		loadContent();
	}
}
