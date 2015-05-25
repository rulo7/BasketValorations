package com.dani.raul.basketvalorations_app.model;


import android.os.Handler;

public class TimerController extends Thread{

    private boolean running = false;
    private Handler h;

    public TimerController (Handler h){
        this.h = h;
    }

    public void action(){
        this.running = !this.running;
    }

    public boolean isRunning(){
        return this.running;
    }

    @Override
    public void run(){
        while(true) {
            if(this.running) {
                this.h.sendEmptyMessage(0);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
