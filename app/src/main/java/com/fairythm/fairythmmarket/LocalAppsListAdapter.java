package com.fairythm.fairythmmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LocalAppsListAdapter extends ArrayAdapter<AppInfo> {
    private int resourceId;
    public LocalAppsListAdapter(Context context, int textViewResourceId, List<AppInfo> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        AppInfo appInfo=getItem(position);//获取当前AppInfo实例
        View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView appPackageName = view.findViewById(R.id.package_name);
        appPackageName.setText(appInfo.getPackageName());
        return view;
    }
}
