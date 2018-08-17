package com.hy.demo_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startService;
    private Button stopService;
    private Button bindService;
    private Button unbindService;
    private Button intentService;
    private FrontService.MyBinder mMyBinder;


    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("Activity与Service建立了连接");
            mMyBinder=(FrontService.MyBinder)service;
            mMyBinder.add(500,20);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("Activity与Service断开了连接");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService = (Button) findViewById(R.id.startService);
        stopService = (Button) findViewById(R.id.stopService);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

        bindService = (Button) findViewById(R.id.bindService);
        unbindService = (Button) findViewById(R.id.unbindService);

        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);

        intentService=(Button)findViewById(R.id.intenservice);
        intentService.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //点击启动Service
            case R.id.startService:
                //构建启动服务的Intent对象
                Intent startIntent = new Intent(this, FrontService.class);
                //调用startService()方法-传入Intent对象,以此启动服务
                startService(startIntent);
                break;

            //点击停止Service
            case R.id.stopService:
                //构建停止服务的Intent对象
                Intent stopIntent = new Intent(this, FrontService.class);
                //调用stopService()方法-传入Intent对象,以此停止服务
                stopService(stopIntent);
                break;

            case R.id.bindService:
                Intent bindIntent=new Intent(this,FrontService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;

            case R.id.unbindService:
                unbindService(connection);
                break;

            case R.id.intenservice:
                /**
                 * 同一服务只会开启一个工作线程
                 * 在onHandleIntent依次处理intent请求
                 */
                Intent intent1=new Intent("com.hy.intentservice");
                Bundle bundle=new Bundle();
                bundle.putString("taskName","task1");
                intent1.putExtras(bundle);
                startService(intent1);

                Intent intent2=new Intent("com.hy.intentservice");
                Bundle bundle2=new Bundle();
                bundle2.putString("taskName","task2");
                intent2.putExtras(bundle2);
                startService(intent2);//多次启动
                break;

                default:
                    break;

        }



    }
}
