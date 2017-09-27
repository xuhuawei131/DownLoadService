package com.xuhuawei.download;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class DownLoadService  implements OnDownloadCallback{
    //等待队列
    private Queue<DownloadTask> waittingQueue;
    //下载队列
    private static final int num = 3;

    private List<DownloadTask> workingList;

    public DownLoadService() {
        waittingQueue = new ConcurrentLinkedDeque<>();
        workingList = new CopyOnWriteArrayList<>();
    }

    /**
     * 主线程添加
     *
     * @param task
     * @return
     */
    public boolean addDownloadTask(DownloadTask task) {
        int num=0;
        if (waittingQueue.contains(task) || workingList.contains(task)) {
            return false;
        } else {
            waittingQueue.add(task);
            startNextDownload();
            return true;
        }
    }


    public void startNextDownload() {

        while (workingList.size() <=num) {

            if (!waittingQueue.isEmpty()) {
                DownloadTask task = waittingQueue.poll();
                workingList.add(task);
                task.startDownload(this);
            }else{
                break;
            }
        }
    }





    @Override
    public void onStart(DownloadTask bean) {

    }

    @Override
    public void onError(DownloadTask bean) {
        startNextDownload();
    }

    @Override
    public void onFinish(DownloadTask bean) {
        workingList.remove(bean);
        startNextDownload();
    }
}
