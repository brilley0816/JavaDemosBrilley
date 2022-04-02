package Brilley.concurrent;

/**
 * @author Brilley
 * @date 2022/3/24
 */
public class ThreadTest {
    public static void test1(){
        MyRunnable mr=new MyRunnable();
        Thread t1=new Thread(mr,"ZhangFei");
        Thread t2=new Thread(mr,"LvBu");
        Thread t3=new Thread(mr,"DiaoChan");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void test2(){
        MyRunnable mrc=new MyRunnable();
        Thread t1=new Thread(mrc,"ZhangFei");
        Thread t2=new Thread(mrc,"LvBu");
        Thread t3=new Thread(mrc,"DiaoChan");
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
    }

    public static void test3(){
        MyRunnable mrc=new MyRunnable();
        Thread t1=new Thread(mrc,"ZhangFei");
        Thread t2=new Thread(mrc,"LvBu");
        Thread t3=new Thread(mrc,"DiaoChan");
        //t1.start();
        t2.start();
        try {
            t2.join();
            System.out.println("t2 join set up");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        t1.start();
        t3.start();
    }
}
