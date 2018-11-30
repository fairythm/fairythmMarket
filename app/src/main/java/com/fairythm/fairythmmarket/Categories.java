package com.fairythm.fairythmmarket;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

public class Categories extends AppCompatActivity {

    private DrawerLayout categoryDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagories);

        //采用toolbar
        android.support.v7.widget.Toolbar toolbar=findViewById(R.id.categories_toolbar);
        setSupportActionBar(toolbar);

        //toolbar导航栏设置
        categoryDrawerLayout = findViewById(R.id.categories_drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_navigator);
        }

        //Drawer中点击事件设置
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.appList);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.appList:
                        getPKList(Categories.this);
                        categoryDrawerLayout.closeDrawers();
                        break;
                    case R.id.application:

                        categoryDrawerLayout.closeDrawers();
                        break;
                    case R.id.game:


                        categoryDrawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    //获取已安装应用列表
    List<PackageInfo> getPKList(Context context){
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> ip = pm.getInstalledPackages(0);//获取全部安装的应用
        int flag = PackageManager.GET_ACTIVITIES + PackageManager.GET_PERMISSIONS;//0

        Log.e("Categories","starting to scan apps");
        for(int i = 0;i < ip.size();i++){
            Log.e("Package:",ip.get(i).packageName);
        }

        return ip;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                categoryDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }

        return true;
    }
}
