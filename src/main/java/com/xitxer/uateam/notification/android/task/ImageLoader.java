package com.xitxer.uateam.notification.android.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;

import com.google.common.base.Preconditions;
import com.xitxer.uateam.notification.android.task.base.HolderObtainerTask;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.android.util.FileUtil;
import com.xitxer.uateam.notification.android.util.PLog;
import com.xitxer.uateam.notification.core.util.UateamSiteUtil;

public class ImageLoader extends HolderObtainerTask<String, Void, Bitmap> {
	private static final String TAG = ImageLoader.class.getSimpleName();

	private final FileUtil fileUtil;

	public ImageLoader(HolderObtainer<Bitmap> obtainer, Context context) {
		super(obtainer);
		fileUtil = new FileUtil(context);
	}

	@Override
	protected Bitmap retrieve(String... params) throws Exception {
		String url = Preconditions.checkNotNull(params[0]);
		if (!url.startsWith(UateamSiteUtil.URL_BASE)) {
			url = UateamSiteUtil.URL_BASE + url;
		}
		PLog.d(TAG, "url:" + url);
		File file = fileUtil.getCacheFile(url);
		PLog.d(TAG, "file:" + file);
		Bitmap bitmap;
		PLog.d(TAG, "!file.exists():" + (!file.exists()));
		if (!file.exists()) {
			bitmap = BitmapFactory.decodeStream(new URL(url).openStream());
			bitmap.compress(CompressFormat.JPEG, 90, new FileOutputStream(file));
		} else {
			bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
		}
		return bitmap;
	}
}
