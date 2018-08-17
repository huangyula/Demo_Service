package com.hy.demo_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 可通信的服务Service
 * 在MyService1的基础上,增设“与Activity通信”的功能
 * 即使用绑定Service服务（Binder类、bindService()、onBind(）、unbindService()、onUnbind()）
 */

public class MyService2 extends Service{
    MyBinder mBinder=new MyBinder();
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("执行了onCreat()");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("onStartCommand()");
        return super.onStartCommand(intent, flags, startId);

    }


    @Override
    public void onDestroy() {
        System.out.println("onDestroy()");
        super.onDestroy();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind()");
        //返回实例
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("onUnbind()");
        return super.onUnbind(intent);
    }

    //新建一个子类,继承自Binder类
    class MyBinder extends Binder{
        public void service_connect_Activity() {
            System.out.println("Service关联了Activity,并在Activity执行了Service的方法");
        }

    }

}
