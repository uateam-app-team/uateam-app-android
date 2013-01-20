package com.xitxer.uateam.notification.android.task.base;

import android.os.AsyncTask;

import com.xitxer.uateam.notification.android.task.base.obtainer.Obtainer;

public abstract class ObtainerTask<Params, Progress, Data> extends AsyncTask<Params, Progress, Data> {
	private final Obtainer<Data> obtainer;

	public ObtainerTask(Obtainer<Data> obtainer) {
		super();
		if (obtainer == null) {
			throw new IllegalArgumentException("obtainer == null");
		}
		this.obtainer = obtainer;
	}

	@Override
	protected void onPostExecute(Data data) {
		super.onPostExecute(data);
		obtainer.obtain(data);
	}
}
