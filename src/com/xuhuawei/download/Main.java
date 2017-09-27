package com.xuhuawei.download;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        DownLoadService service=new DownLoadService();
//
        DownloadTask task1=new DownloadTask(0);
        DownloadTask task2=new DownloadTask(1);
        DownloadTask task3=new DownloadTask(2);
        DownloadTask task4=new DownloadTask(3);
        DownloadTask task5=new DownloadTask(4);
        DownloadTask task6=new DownloadTask(5);
        DownloadTask task7=new DownloadTask(6);
        DownloadTask task8=new DownloadTask(7);
        DownloadTask task9=new DownloadTask(8);
//


        service.addDownloadTask(task1);
        service.addDownloadTask(task2);
        service.addDownloadTask(task3);
        service.addDownloadTask(task4);
        service.addDownloadTask(task5);
        service.addDownloadTask(task6);
        service.addDownloadTask(task7);
        service.addDownloadTask(task8);
        service.addDownloadTask(task9);

//        Scanner reader=new Scanner(System.in);
//        System.out.println("请输入数字");
//        int num=0;
//        while ((num=reader.nextInt())!=0){
//            DownloadTask task=new DownloadTask(num);
//            service.addDownloadTask(task);
//        }
    }

}
