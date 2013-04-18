package com.xitxer.uateam.notification.android.task;

import java.util.List;

import com.xitxer.uateam.notification.android.parser.SiteSourceSingletonHolder;
import com.xitxer.uateam.notification.android.task.base.SimpleHolderObtainerTask;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.core.model.ReleaseEntry;
import com.xitxer.uateam.notification.core.parser.RecentReleasesParser;

public class RecentReleaseLoader extends SimpleHolderObtainerTask<List<ReleaseEntry>> {

	public RecentReleaseLoader(HolderObtainer<List<ReleaseEntry>> obtainer) {
		super(obtainer);
	}

	@Override
	protected List<ReleaseEntry> retrieve() throws Exception {
		return new RecentReleasesParser(SiteSourceSingletonHolder.getSiteSource()).get();
	}
}
