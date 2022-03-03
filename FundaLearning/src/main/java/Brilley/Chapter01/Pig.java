package Brilley.Chapter01;

public class Pig implements Fly,Run{
    @Override
    public void fly(){
        System.out.println("this is a pig can fly");
    }

    @Override
    public void run(){
        System.out.println("this is a pig can run");
    }

}
