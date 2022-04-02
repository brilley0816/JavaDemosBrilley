package Brilley.concurrent;

/**
 * @author Brilley
 * @date 2022/3/24
 */
public class MyRunnable implements Runnable{
    @Override
    public void run()
    {
        for(int i=0;i<10;i++){
            try{
                Thread.sleep(20);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" beats "+i+" monsters");
        }
    }
}
