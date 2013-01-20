package com.xitxer.uateam.notification.android.task.base;

import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;

public abstract class SimpleHolderObtainerTask<Data> extends HolderObtainerTask<Void, Void, Data> {
	public SimpleHolderObtainerTask(HolderObtainer<Data> obtainer) {
		super(obtainer);
	}

	@Override
	protected Data retrieve(Void... params) throws Exception {
		return retrieve();
	}

	protected abstract Data retrieve() throws Exception;
}
