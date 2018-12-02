package com.fairythm.fairythmmarket.Utilities;

//此类用于初始化用户安装应用列表的一个项目

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String appName;//应用名称

    private String packageName;//应用包名

    private Drawable image;//应用图标

    public String getPackageName() {
        return packageName;
    }

    public Drawable getImage(){
        return image;
    }

    public String getAppName(){
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public AppInfo(String name,String appName, Drawable img){
        packageName=name;
        this.appName=appName;
        image=img;
    }
}
