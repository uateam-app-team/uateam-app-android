package com.xitxer.uateam.notification.android.util;

import android.util.Log;

public class PLog {
	private static final boolean isPrintLog = true;
	private static final boolean isPrintLogD = true;
	private static final boolean isPrintLogE = true;
	private static final boolean isPrintLogI = true;
	private static final boolean isPrintLogV = true;
	private static final boolean isPrintLogW = true;
	private static final boolean isPrintLogWTF = true;

	private PLog() {
	}

	public static void d(String TAG, String msg) {
		if (isPrintLog && isPrintLogD) {
			Log.d(TAG, msg);
		}
	}

	public static void e(String TAG, String msg) {
		if (isPrintLog && isPrintLogE) {
			Log.e(TAG, msg);
		}
	}

	public static void e(String TAG, Throwable tr) {
		if (isPrintLog && isPrintLogE) {
			Log.e(TAG, tr.getMessage(), tr);
		}
	}

	public static void e(String TAG, String msg, Throwable tr) {
		if (isPrintLog && isPrintLogE) {
			Log.e(TAG, msg, tr);
		}
	}

	public static void i(String TAG, String msg) {
		if (isPrintLog && isPrintLogI) {
			Log.i(TAG, msg);
		}
	}

	public static void v(String TAG, String msg) {
		if (isPrintLog && isPrintLogV) {
			Log.v(TAG, msg);
		}
	}

	public static void w(String TAG, String msg) {
		if (isPrintLog && isPrintLogW) {
			Log.w(TAG, msg);
		}
	}

	public static void wtf(String TAG, String msg) {
		if (isPrintLog && isPrintLogWTF) {
			Log.wtf(TAG, msg);
		}
	}
}
