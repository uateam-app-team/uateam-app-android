package com.xitxer.uateam.notification.android.util;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.util.Base64;

public class FileUtil {
	public static String encodeFileName(String name) throws NoSuchAlgorithmException {
		return Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(name.getBytes()), Base64.URL_SAFE);
	}

	public static File getCacheFile(String name, Context context) throws NoSuchAlgorithmException {
		return new File(context.getCacheDir(), encodeFileName(name));
	}

	private final Context context;

	public FileUtil(Context context) {
		super();
		this.context = context;
	}

	public File getCacheFile(String name) throws NoSuchAlgorithmException {
		return getCacheFile(name, context);
	}
}
