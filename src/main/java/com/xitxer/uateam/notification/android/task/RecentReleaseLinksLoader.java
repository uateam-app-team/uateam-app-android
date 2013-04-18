package com.xitxer.uateam.notification.android.task;

import com.xitxer.uateam.notification.android.parser.SiteSourceSingletonHolder;
import com.xitxer.uateam.notification.android.task.base.HolderObtainerTask;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.android.util.PLog;
import com.xitxer.uateam.notification.core.model.ReleaseEntry;
import com.xitxer.uateam.notification.core.parser.RecentReleasesParser;

public class RecentReleaseLinksLoader extends HolderObtainerTask<ReleaseEntry, Void, Void> {
	public RecentReleaseLinksLoader(HolderObtainer<Void> obtainer) {
		super(obtainer);
	}

	@Override
	protected Void retrieve(ReleaseEntry... params) throws Exception {
		RecentReleasesParser parser = new RecentReleasesParser(SiteSourceSingletonHolder.getSiteSource());
		int i = 0;
		for (ReleaseEntry releaseEntry : params) {
			parser.parseReleaseLinks(releaseEntry);
			PLog.d("releaseEntry", "n=" + i + " releaseEntry=" + releaseEntry);
		}
		return null;
	}
}
