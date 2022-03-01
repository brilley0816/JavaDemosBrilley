package Brilley.JavaLearn;
import Brilley.Chapter01.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world! This is Brilley Java learning demos ensembles!");
        StaticDataDemo sdd=new StaticDataDemo();
        System.out.println("directly use the Class's static data: Class.a: "+ StaticDataDemo.a);
        System.out.println("directly use the Class's field data: Object.b: "+ String.valueOf(sdd.b));
        sdd.InfoPrint();
        Test te=new Test();
        te.Info();
    }
}
