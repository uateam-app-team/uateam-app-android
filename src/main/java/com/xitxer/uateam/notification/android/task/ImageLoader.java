package com.xitxer.uateam.notification.android.task;

import com.xitxer.uateam.notification.android.task.base.HolderObtainerTask;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;

public class ImageLoader extends HolderObtainerTask<String, Void, String> {

	public ImageLoader(final HolderObtainer<String> obtainer) {
		super(obtainer);
	}

	@Override
	protected String retrieve(final String... params) throws Exception {
		return null;
	}
}
