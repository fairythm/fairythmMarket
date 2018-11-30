package com.fairythm.fairythmmarket;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

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
        categoryDrawerLayout = findViewById(R.id.categories_drawer);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_navigator);
        }

    }

    //toolbar添加menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.categories_toolbar_menu,menu);
        return true;
    }

    //按下menu选项
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                categoryDrawerLayout.openDrawer(GravityCompat.START);//打开drawer
                break;
            case R.id.application:
                //显示应用
                break;
            case R.id.game:
                //显示游戏
                break;
            case R.id.settings:
                //显示设置
                break;
            default:
        }
        return true;
    }
}
