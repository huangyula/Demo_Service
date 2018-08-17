package com.hy.demo_service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 处理异步请求，实现多线程
 */

public class MyIntentService extends IntentService {
    private String tag=MyIntentService.class.getName();

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * 复写onHandleIntent方法
     * 实现耗时任务的操作
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //根据Intent的不同进行不同的事务处理
        String taskName=intent.getExtras().getString("taskName");
        switch (taskName){
            case "task1":
                Log.i(tag,"do task1");
                break;
            case "task2":
                Log.i(tag,"do task2");
                break;
            default:
                break;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(tag,"onCreate");
    }

    /*复写onStartCommand()方法*/
    //默认实现将请求的Intent添加到工作队列里
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(tag,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(tag,"onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(tag,"onBind");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(tag,"onUnbind");
        return super.onUnbind(intent);
    }
}
