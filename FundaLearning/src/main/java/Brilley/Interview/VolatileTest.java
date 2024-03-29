package Brilley.Interview;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-08-15 12:01
 */
public class VolatileTest {
    private static int COUNTER = 0;

    public static void test1() {

        new ChangeListener().start();

        new ChangeMaker().start();

    }



    static class ChangeListener extends Thread {

        @Override

        public void run() {

            int threadValue = COUNTER;

            while ( threadValue < 5){

                if( threadValue!= COUNTER){

                    System.out.println("Got Change for COUNTER : " + COUNTER + "");

                    threadValue= COUNTER;
                }
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }

    }



    static class ChangeMaker extends Thread{

        @Override

        public void run() {

            int threadValue = COUNTER;

            while (COUNTER <5){

                System.out.println("Incrementing COUNTER to : " + (threadValue+1) + "");

                COUNTER = ++threadValue;

                try {

                    Thread.sleep(500);

                } catch (InterruptedException e) { e.printStackTrace(); }

            }

        }

    }
}
