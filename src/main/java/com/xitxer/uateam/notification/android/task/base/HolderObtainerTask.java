package com.xitxer.uateam.notification.android.task.base;

import com.xitxer.uateam.notification.android.task.base.holder.Holder;
import com.xitxer.uateam.notification.android.task.base.holder.IHolder;
import com.xitxer.uateam.notification.android.task.base.obtainer.HolderObtainer;

public abstract class HolderObtainerTask<Params, Progress, Data> extends ObtainerTask<Params, Progress, IHolder<Data>> {
	public HolderObtainerTask(HolderObtainer<Data> obtainer) {
		super(obtainer);
	}

	@Override
	protected IHolder<Data> doInBackground(Params... params) {
		try {
			return Holder.hold(retrieve(params));
		} catch (Exception exception) {
			return Holder.hold(exception);
		}
	}

	protected abstract Data retrieve(Params... params) throws Exception;
}
