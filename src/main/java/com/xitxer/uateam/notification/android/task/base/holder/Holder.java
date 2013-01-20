package com.xitxer.uateam.notification.android.task.base.holder;


public class Holder<Data> implements IHolder<Data> {
	private final Data data;
	private final boolean successful;
	private final Exception exception;

	public Holder(Data data, boolean successful, Exception exception) {
		super();
		this.data = data;
		this.successful = successful;
		this.exception = exception;
	}

	@Override
	public boolean successful() {
		return successful;
	}

	@Override
	public Data getData() {
		return data;
	}

	@Override
	public Exception getException() {
		return exception;
	}

	@Override
	public String toString() {
		return "Holder [data=" + data + ", successful=" + successful + ", exception=" + exception + "]";
	}

	public static <Data> Holder<Data> hold(Data data, boolean successful, Exception exception) {
		return new Holder<Data>(data, successful, exception);
	}

	public static <Data> Holder<Data> hold(Data data) {
		return hold(data, true, null);
	}

	public static <Data> Holder<Data> hold(Exception exception) {
		return hold(null, false, exception);
	}
}
