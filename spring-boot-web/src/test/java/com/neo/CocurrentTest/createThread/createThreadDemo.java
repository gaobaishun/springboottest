package com.neo.CocurrentTest.createThread;


import com.neo.testClassTemplate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class createThreadDemo extends testClassTemplate {
     Logger logger=LoggerFactory.getLogger(createThreadDemo.class);
    @Test
    public void createThreadOne() throws InterruptedException {
        Thread thread=new MyThread();
        thread.run();

        //logger.info("创建线程的第三种方式：实现Callable接口（可以有返回值），用FutureTask封装，然后用Thread封装");
    }

    @Test
    public void createThreadTwo(){
        Runnable runnable=new MyThread2();
        Thread thread=new Thread(runnable);
        thread.run();
    }

    @Test
    public void createThreadThree(){
        ThreadDemo td = new ThreadDemo();

        // 1.执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
        FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();

        // 2.接收线程运算后的结果
        Integer sum;
        try {
            //等所有线程执行完，获取值，因此FutureTask 可用于 闭锁
            sum = result.get();
            System.out.println("-----------------------------");
            System.out.println(sum);
            logger.info("创建线程的第三种方式：实现Callable接口（可以有返回值），用FutureTask封装，然后用Thread封装");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

/*
* 创建线程的第一种方式继承Thread复写run方法
* */
class MyThread extends Thread {//继承Thread类
    public static int i=0;

    Logger logger= LoggerFactory.getLogger(MyThread.class);
    @Override
    public void run() {
        //重写run方法
        i++;
        logger.debug("创建线程的第一种方法：继承Thread类，创建对象调用run即可");
    }
}

//public class Main {
//
//　　public static void main(String[] args){
//
//　　　　new MyThread().start();//创建并启动线程
//
//　　}
//
//}

class MyThread2 implements Runnable {//实现Runnable接口

    Logger logger=LoggerFactory.getLogger(MyThread2.class);

    public void run(){
    logger.info("创建线程的第二种方法，实现Runnable接口，创建Thread的对象：Thread th=new Thread（myThread2）");
    //重写run方法

    }

}

//public class Main {
//
//public static void main(String[] args){
//
//　　　　//创建并启动线程
//
//　　　　MyThread2 myThread=new MyThread2();
//
//　　　　Thread thread=new Thread(myThread);
//
//　　　　thread().start();
//
//　　　　//或者    new Thread(new MyThread2()).start();
//
//　　}
//
//}
class ThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}