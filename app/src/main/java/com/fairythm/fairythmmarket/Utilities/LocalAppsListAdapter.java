package com.fairythm.fairythmmarket.Utilities;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fairythm.fairythmmarket.R;
import com.fairythm.fairythmmarket.Utilities.AppInfo;

import java.util.List;

//此类用于初始化本地APPs里的ListView

public class LocalAppsListAdapter extends ArrayAdapter<AppInfo> {
    private int resourceId;

    public LocalAppsListAdapter(Context context, int textViewResourceId, List<AppInfo> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //ViewHolder viewHolder;
        AppInfo appInfo=getItem(position);//获取当前AppInfo实例
        View view;

        viewHolder = new ViewHolder();


        if(convertView == null) {

            Log.e(this.toString()+"null","Check Point");
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);


        }else{
            Log.e(this.toString()+"not null","Check Point");
            view = convertView;
        }//可能的话，加载之前listview缓冲，提高运行效率

        viewHolder.appName = view.findViewById(R.id.app_name);
        viewHolder.packageName = view.findViewById(R.id.package_name);
        viewHolder.appIcon = view.findViewById(R.id.package_image);


        viewHolder.appName.setText(appInfo.getAppName());
        viewHolder.packageName.setText(appInfo.getPackageName());
        viewHolder.appIcon.setImageDrawable(appInfo.getImage());

        view.getTag();

        Log.e(this.toString()+"before return","Check Point");
        return view;
    }

    class ViewHolder{

        ImageView appIcon;

        TextView appName;

        TextView packageName;
    }

    ViewHolder viewHolder;//你娃儿耍涨了？？
}
