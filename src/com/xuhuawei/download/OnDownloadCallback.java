package com.xuhuawei.download;

public interface OnDownloadCallback {


    public void onStart(DownloadTask bean);
    public void onError(DownloadTask bean);
    public void onFinish(DownloadTask bean);

}
