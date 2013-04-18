package com.xitxer.uateam.notification.android.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;

import com.google.common.base.Preconditions;
import com.xitxer.uateam.notification.android.task.base.HolderObtainerTask;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;
import com.xitxer.uateam.notification.android.util.FileUtil;

public class ImageLoader extends HolderObtainerTask<String, Void, Bitmap> {
	private static CompressFormat getCompressFormat() {
		return VERSION.SDK_INT >= VERSION_CODES.ICE_CREAM_SANDWICH ? CompressFormat.WEBP : CompressFormat.JPEG;
	}

	private final FileUtil fileUtil;

	public ImageLoader(HolderObtainer<Bitmap> obtainer, Context context) {
		super(obtainer);
		fileUtil = new FileUtil(context);
	}

	@Override
	protected Bitmap retrieve(String... params) throws Exception {
		Preconditions.checkNotNull(params, "params == null");
		String url = Preconditions.checkNotNull(params[0], "params[0] == null");
		File file = fileUtil.getCacheFile(url);
		Bitmap bitmap;
		if (!file.exists()) {
			bitmap = BitmapFactory.decodeStream(new URL(url).openStream());
			bitmap.compress(getCompressFormat(), 95, new FileOutputStream(file));
		} else {
			bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
		}
		return bitmap;
	}
}
