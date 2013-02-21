package com.xitxer.uateam.notification.android.util;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.util.Base64;

public class FileUtil {
	public static String encodeFileName(final String name) throws NoSuchAlgorithmException {
		return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(name.getBytes()), Base64.URL_SAFE);
	}

	public static File getCacheFile(final String name, final Context context) throws NoSuchAlgorithmException {
		return new File(context.getCacheDir(), encodeFileName(name));
	}

	private final Context context;

	public FileUtil(final Context context) {
		super();
		this.context = context;
	}
}
