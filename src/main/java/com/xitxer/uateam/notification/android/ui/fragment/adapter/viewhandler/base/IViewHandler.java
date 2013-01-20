package com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.base;

import android.view.View;

public interface IViewHandler<Data> {
	View createView();

	View fillView(Data data, View view);
}
