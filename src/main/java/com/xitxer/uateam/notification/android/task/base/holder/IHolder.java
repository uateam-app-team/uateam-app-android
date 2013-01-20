package com.xitxer.uateam.notification.android.task.base.holder;

public interface IHolder<Data> {
	boolean successful();

	Data getData();

	Exception getException();
}
