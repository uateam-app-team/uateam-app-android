package com.xitxer.uateam.notification.android.task;

import java.util.List;

import com.xitxer.uateam.notification.android.task.base.SimpleHolderObtainerTask;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.core.model.ReleaseEntry;
import com.xitxer.uateam.notification.core.parser.RecentReleasesParser;
import com.xitxer.uateam.notification.core.parser.sitesource.HttpSiteSource;
import com.xitxer.uateam.notification.core.util.UateamSiteUtils;

public class RecentReleaseLoader extends SimpleHolderObtainerTask<List<ReleaseEntry>> {
	public RecentReleaseLoader(HolderObtainer<List<ReleaseEntry>> obtainer) {
		super(obtainer);
	}

	@Override
	protected List<ReleaseEntry> retrieve() throws Exception {
		return new RecentReleasesParser(new HttpSiteSource(UateamSiteUtils.URL_BASE)).get();
	}
}
