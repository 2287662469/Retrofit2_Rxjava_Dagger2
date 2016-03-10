package com.finddreams.retrofit.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.finddreams.retrofit.bean.ExpressBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
*适配器
*@author finddreams
*@address http://blog.csdn.net/finddreams
*/
public class ExpressAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ExpressBean.ResultEntity> list;

    public ExpressAdapter(ArrayList<ExpressBean.ResultEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, android.R.layout.simple_list_item_2, null);
        }
        TextView text1 = (TextView) convertView.findViewById(android.R.id.text1);
        TextView text2 = (TextView) convertView.findViewById(android.R.id.text2);

        text1.setText(list.get(position).getName());
        text2.setText(list.get(position).getTel());

        return convertView;
    }
}
