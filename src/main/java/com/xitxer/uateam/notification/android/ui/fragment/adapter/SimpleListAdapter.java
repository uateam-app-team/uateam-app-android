package com.xitxer.uateam.notification.android.ui.fragment.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.xitxer.uateam.notification.android.ui.fragment.adapter.viewhandler.base.IViewHandler;

public class SimpleListAdapter<Data> extends BaseAdapter {
	private final List<Data> list;
	private final IViewHandler<Data> viewCreator;

	public SimpleListAdapter(List<Data> list, IViewHandler<Data> viewCreator) {
		super();
		if (list == null) {
			list = new ArrayList<Data>();
		}
		if (viewCreator == null) {
			throw new IllegalArgumentException("viewCreator == null");
		}
		this.list = list;
		this.viewCreator = viewCreator;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Data getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = viewCreator.createView();
		}
		return viewCreator.fillView(getItem(position), view);
	}

	public static <Data> SimpleListAdapter<Data> make(List<Data> list, IViewHandler<Data> viewCreator) {
		return new SimpleListAdapter<Data>(list, viewCreator);
	}
}
