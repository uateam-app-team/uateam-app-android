package com.xitxer.uateam.notification.android.parser;

import com.xitxer.uateam.notification.core.parser.sitesource.CachedSiteSource;
import com.xitxer.uateam.notification.core.parser.sitesource.HttpSiteSource;
import com.xitxer.uateam.notification.core.parser.sitesource.SiteSource;
import com.xitxer.uateam.notification.core.util.UateamSiteUtil;

public class SiteSourceSingletonHolder {
	private static final Object LOCK_OBJECT = new Object();
	private static SiteSource siteSource = null;

	public static void dropSiteSource() {
		siteSource = null;
	}

	public static SiteSource getSiteSource() {
		if (siteSource == null) {
			synchronized (LOCK_OBJECT) {
				if (siteSource == null) {
					siteSource = new CachedSiteSource(new HttpSiteSource(UateamSiteUtil.URL_BASE));
				}
			}
		}
		return siteSource;
	}
}
