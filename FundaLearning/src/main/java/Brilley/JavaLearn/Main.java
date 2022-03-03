package Brilley.JavaLearn;
import Brilley.Chapter01.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("hello world! This is Brilley Java learning demos ensembles!");
        StaticDataDemo sdd=new StaticDataDemo();
        System.out.println("directly use the Class's static data: Class.a: "+ StaticDataDemo.a);
        System.out.println("directly use the Class's field data: Object.b: "+ String.valueOf(sdd.b));
        sdd.InfoPrint();
        Test te=new Test();
        te.Info();

        //03-01
        InstanceMethod im=new InstanceMethod();
        im.printName();
        //we can modify the static variable value ,if the instance method can modify the  static value
        im.modifyName("xiaoming");
        //verify the assumption
        im.printNameCurrent();
        //we can use print the protected variable in the Class InstanceMethod in the same package;
        System.out.println(im.methodName);
        //the protected variable in the Class Test but in the other package; can not see variable b;
        ///System.out.println(te.);

        CopyPerson cp=new CopyPerson("brilley",26);
        cp.printInfo();
        CopyPerson cp2=(CopyPerson) cp.clone();
        cp.printInfo();

        ExtendsInitBlock eib=new ExtendsInitBlock();

        //03-02
        AppleIpad aIpad=new AppleIpad();
        System.out.println(aIpad.getElectricityUse());
        aIpad.printDescription();
        //AppleIpad does not has the static method from interface Electronic
        //System.out.println("aIpad is energy Efficient? "+AppleIpad.);
        //Electronic aIpadn=aIpad;
        System.out.println("aIpad is energy Efficient? "+Electronic.isEnergyEfficient("LED"));

        //multi extends
        Pig pg=new Pig();
        pg.fly();
        pg.run();

        //multi format
        List<Shape> shapeList=new ArrayList<>();
        Circle cir=new Circle();
        Square sqa=new Square();
        shapeList.add(cir);
        shapeList.add(sqa);
        for(Shape sha:shapeList)
        {
            sha.printShape();
        }

        StaticMethodStudent stu1=new StaticMethodStudent("brilley",25);
        StaticMethodStudent stu2=new StaticMethodStudent("yanyan",24);
        stu1.printInfo();
        stu2.printInfo();
        StaticMethodStudent.change();
        stu1.printInfo();
        stu2.printInfo();


    }
}
