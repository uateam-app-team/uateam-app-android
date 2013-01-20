package com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.base.Preconditions;
import com.xitxer.uateam.notification.android.R;
import com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.base.IViewHandler;
import com.xitxer.uateam.notification.core.model.ReleaseEntry;

public class ReleaseEntryViewHandler implements IViewHandler<ReleaseEntry> {
	private final LayoutInflater layoutInflater;

	public ReleaseEntryViewHandler(LayoutInflater layoutInflater) {
		super();
		this.layoutInflater = Preconditions.checkNotNull(layoutInflater);
	}

	@Override
	public View createView() {
		return layoutInflater.inflate(R.layout.release_entry, null);
	}

	@Override
	public View fillView(ReleaseEntry data, View view) {
		((ImageView) view.findViewById(R.id.release_group_icon)).setContentDescription(data.getIconLink());
		((TextView) view.findViewById(R.id.release_group_title)).setText(data.getGroup());
		// TODO: find better way to do this
		((TextView) view.findViewById(R.id.release_numbers)).setText(data.getSeason() + "." + data.getEpisode());
		((TextView) view.findViewById(R.id.release_title)).setText(data.getRelease());
		return view;
	}
}
