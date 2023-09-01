package org.sakura.skindemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.sakura.skindemo.R;

import java.util.List;

public class SkinListAdapter implements SpinnerAdapter {

    private final Context mContext;
    private final List<String> mSkinList;

    public SkinListAdapter(Context context, List<String> list) {
        mContext = context;
        mSkinList = list;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_view_skin_list, null);
        TextView textView = convertView.findViewById(R.id.tv_current_item);
        textView.setText(getItem(position).toString());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_view_skin_list, null);
        TextView textView = convertView.findViewById(R.id.tv_current_item);
        textView.setText(getItem(position).toString());
        return convertView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return mSkinList.size();
    }

    @Override
    public Object getItem(int position) {
        return mSkinList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return mSkinList.isEmpty();
    }

    public int getPositionByItem(Object item) {
        for (int i = 0; i < mSkinList.size(); i++) {
            if (mSkinList.get(i).equals(item.toString())) {
                return i;
            }
        }
        return 0;
    }

}
