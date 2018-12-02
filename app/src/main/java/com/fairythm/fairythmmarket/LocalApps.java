package com.fairythm.fairythmmarket;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fairythm.fairythmmarket.Utilities.AppInfo;
import com.fairythm.fairythmmarket.Utilities.LocalAppsListAdapter;

import java.util.ArrayList;
import java.util.List;

//此活动用于展示用户手机内已经安装的APP

public class LocalApps extends AppCompatActivity {

    private List<AppInfo> appInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_apps);

        initAppInfos();//初始化APP数据
        LocalAppsListAdapter adapter = new LocalAppsListAdapter(LocalApps.this,R.layout.app_info_inlist,appInfoList);
        ListView listView = findViewById(R.id.packages_list);
        listView.setAdapter(adapter);

        //listview点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AppInfo appInfo = appInfoList.get(position);

                Log.d(this.toString(),appInfo.getPackageName());
                AlertDialog.Builder builder = new AlertDialog.Builder(LocalApps.this);
                builder.setItems(new String[]{"Uninstall"}, new DialogInterface.OnClickListener() {
                    //点击弹出卸载按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.fromParts("package",appInfo.getPackageName(),null);
                        Intent intent = new Intent(Intent.ACTION_DELETE,uri);
                        startActivity(intent);
                    }
                });
                builder.show();

            }
        });

    }

    private void initAppInfos(){
        PackageManager pm = LocalApps.this.getPackageManager();
        List<PackageInfo> ip = pm.getInstalledPackages(0);//获取全部安装的应用
        int flag = PackageManager.GET_ACTIVITIES + PackageManager.GET_PERMISSIONS;//0



        for(int i = 0;i < ip.size();i++){
            if((ip.get(i).applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {//不统计系统应用

                AppInfo app = new AppInfo(
                        ip.get(i).packageName,
                        ip.get(i).applicationInfo.loadLabel(pm).toString(),
                        ip.get(i).applicationInfo.loadIcon(pm)
                );
                appInfoList.add(app);
            }
        }
    }
}
