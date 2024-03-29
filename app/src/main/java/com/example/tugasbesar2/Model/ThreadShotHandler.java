package com.example.tugasbesar2.Model;

import android.os.CountDownTimer;
import android.os.Message;

import android.os.Handler;

import com.example.tugasbesar2.View.MainActivity;

public class ThreadShotHandler extends Handler {
    protected final static int MSG_SET_OUTPUT = 0;
    protected MainActivity mainActivity;
    protected CountDownTimer timer;

    public ThreadShotHandler(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }



    @Override
    public void handleMessage(Message msg){
        if(msg.what== ThreadShotHandler.MSG_SET_OUTPUT){
            Shot shot =  (Shot) msg.obj;
            this.mainActivity.shot = shot;
            this.mainActivity.drawSlave();
        }
    }

    public void x(Shot shot){
        Message msg = new Message();
        msg.what = MSG_SET_OUTPUT;
        msg.obj = shot;
        this.sendMessage(msg);
    }
}
