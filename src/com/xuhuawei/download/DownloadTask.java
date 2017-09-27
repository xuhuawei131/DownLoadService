package com.xuhuawei.download;

public class DownloadTask extends Thread{
    private int tag;
    private OnDownloadCallback callback;
    public DownloadTask(int tag){
        this.tag=tag;
    }
    public void startDownload(OnDownloadCallback callback){
        this.callback=callback;
        start();

    }

    @Override
    public void run() {
        System.out.println(tag+"<-start->");
        callback.onStart(this);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            callback.onError(this);
        }
        System.out.println(tag+"->end<-");

        callback.onFinish(this);
    }
}
