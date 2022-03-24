package Brilley.Chapter07;

import Brilley.Chapter01.CopyPerson;

/**
 * @author Brilley
 * @date 2022/3/23
 */
public class ParameterTransfer {
    static CopyPerson a;
    public static void test1(){
        a=new CopyPerson("brilley",26);
        System.out.println(a);
        a.printInfo();
        changeName(a,"yanyan");
        a.printInfo();

    }

    public static void changeName(CopyPerson cp, String name){
        System.out.println(cp);
        cp.setName(name);
    }

}
