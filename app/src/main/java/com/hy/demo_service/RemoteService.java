package com.hy.demo_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * 远程服务
 * 远程Service与调用者不在同一个进程里（即远程Service是运行在另外一个进程）；而本地服务则是与调用者运行在同一个进程里
 * 使用场景：多个应用程序共享同一个后台服务（远程服务）
 * 具体实现：为了让远程Service与多个应用程序的组件（四大组件）进行跨进程通信（IPC），需要使用AIDL
 */

public class RemoteService extends Service {

    //实例化AIDL的Stub类(Binder的子类)
    AIDL_Service1.Stub mBinder=new AIDL_Service1.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void AIDL_Service() throws RemoteException {
            System.out.println("客户端通过AIDL与远程后台成功通信");
        }

        @Override
        public void add(int a, int b) throws RemoteException {
            System.out.println("服务端Service的计算结果是："+(a+b));
        }
    };

    @Override
    public void onCreate() {
        System.out.println("执行了onCreate()");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        System.out.println("执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("执行了onBind()");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("执行了onUnbind()");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        System.out.println("执行了onDestroy()");
        super.onDestroy();
    }
}
