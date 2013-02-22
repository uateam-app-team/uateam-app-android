package com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.base.Preconditions;
import com.xitxer.uateam.notification.android.R;
import com.xitxer.uateam.notification.android.task.ImageLoader;
import com.xitxer.uateam.notification.android.task.base.holder.IHolder;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.base.IViewHandler;
import com.xitxer.uateam.notification.android.util.PLog;
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
	public View fillView(ReleaseEntry data, final View view) {
		((ImageView) view.findViewById(R.id.release_group_icon)).setContentDescription(data.getIconLink());
		new ImageLoader(new HolderObtainer<Bitmap>() {
			private final ImageView imageView = ((ImageView) view.findViewById(R.id.release_group_icon));
			@Override
			public void obtain(IHolder<Bitmap> data) {
				if (data.successful()) {
					imageView.setImageBitmap(data.getData());
				} else {
					PLog.e("ReleaseEntryViewHandler", data.getException());
				}
			}
		}, layoutInflater.getContext()).execute(data.getIconLink());
		((TextView) view.findViewById(R.id.release_group_title)).setText(data.getGroup());
		// TODO: find better way to do this
		((TextView) view.findViewById(R.id.release_numbers)).setText(data.getSeason() + "." + data.getEpisode());
		((TextView) view.findViewById(R.id.release_title)).setText(data.getRelease());
		return view;
	}
}
