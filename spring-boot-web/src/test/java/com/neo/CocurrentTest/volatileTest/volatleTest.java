package com.neo.CocurrentTest.volatileTest;

public class volatleTest {

    public static void main(String[] args) {
        // new 出一个新的对象 t
        MyThread t = new MyThread();
        /**
         * 两个线程是在对同一个对象进行操作
         */
        Thread ta = new Thread(t, "Thread-A");
        Thread tb = new Thread(t, "Thread-B");
        Thread tc = new Thread(t,"Thread-C");
        Thread td = new Thread(t,"thread-d");
        ta.start();
        tb.start();
        tc.start();
        td.start();
    }
}

class MyThread implements Runnable {
    // 变量 a 被两个线程共同操作，可能会造成线程竞争
    volatile int a = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            a+=1;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
            System.out.println(Thread.currentThread().getName() + " → a = " + a);
        }
    }
}
