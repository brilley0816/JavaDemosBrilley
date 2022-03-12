package Brilley.JavaLearn;
import Brilley.Chapter01.*;
import Brilley.Chapter02.ImmutableString;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IllegalAccessException, ClassNotFoundException {
        //Initialize : files created at the beginning
        /*
        System.out.println("hello world! This is Brilley Java learning demos ensembles!");
        StaticDataDemo sdd=new StaticDataDemo();
        System.out.println("directly use the Class's static data: Class.a: "+ StaticDataDemo.a);
        System.out.println("directly use the Class's field data: Object.b: "+ String.valueOf(sdd.b));
        sdd.InfoPrint();
        Test te=new Test();
        te.Info();

         */

        //03-01
        /*
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

         */

        //03-02
        /*
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

         */

        //03-03
        /*
        //String is created by char[] in Java 8 and below version, from Java 9, the String has been created by byte[]
        // char is 2 bytes
        String strPool="strPool";
        String strPool2="strPool";
        //equals method is used to compare the value, of course they have the same values, so the output is true;
        //System.out.println(strPool.equals(StrPool2));
        // the output is true because the variables string value has been put in StringPool;
        System.out.println(strPool==strPool2);
        String strPool3=new String("StringPool");
        String strPool4=new String("StringPool");
        //System.out.println(strPool3.equals(strPool4));
        System.out.println(strPool3==strPool4);

        //error! Singleton has a private access
        //Singleton sing=new Singleton();
        // singleton is one type build method.
        Singleton sing;
        sing=Singleton.getInstance();
        System.out.println(sing.name);

         */

        //03-04
        ThisAsMethodResult tamr=new ThisAsMethodResult();
        //out method is a default private access, this is not in the same package
        //tamr.ou  add public access in the Class
        tamr.out();
        tamr.getThisAsMethodResult().out();
        System.out.println(tamr instanceof ThisAsMethodResult);//true // corresponding to the relation "is a "
        //System.out.println(tamr instanceof Circle);
        System.out.println(null instanceof Circle);
        ThisAsMethodResult thisTamr;
        //System.out.println(thisTamr instanceof Circle);

        //03-12
        NoGenericArraylist list1=new NoGenericArraylist(5);
        list1.add("brilley");
        list1.add(new Date());
        //System.out.println(list1); NullPointerException
        String listE1=(String) list1.get(0);
        Date listE2=(Date) list1.get(1);
        System.out.println(listE1+listE2);

        GenericArraylist<String> list2=new GenericArraylist<>(5);
        list2.add("brilley");
        list2.add("yanyan");
        System.out.println(list2);
        System.out.println(list2.get(0));
        GenericArraylist<Date> list3=new GenericArraylist<>(5);
        list3.add(new Date());
        list3.add(new Date());
        System.out.println(list3);
        System.out.println(list3.get(1));
        String[] strsTest=new String[2];
        strsTest=list2.toArray(strsTest);
        for(String str:strsTest)
        {
            System.out.println(str);
        }
        Writer cmower = new Writer(18,"沉默王二","Web全栈开发进阶之路");
        System.out.println(JsonSerializer.serialize(cmower));

        Constructor[] constructors=String.class.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }


        //reflection to get An Array
        Class<?> cls=Class.forName("java.lang.String");
        Object array= Array.newInstance(cls,25);
        Array.set(array, 0, "Scala");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "Groovy");
        Array.set(array, 3, "Scala");
        Array.set(array, 4, "Clojure");
        System.out.println(Array.get(array,2));

        StaticProxy sp=new StaticProxy();
        sp.hello("brilley");
        sp.bye();

        //Dynamic proxy
        Subject realSubject=new RealSubject();

        InvocationHandler handler=new InvocationHandlerDemo(realSubject);

        Subject subject=(Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),handler);
        System.out.println(subject.getClass().getName());
        subject.hello("World");
        String result=subject.bye();
        System.out.println("Real result is "+result);

        ImmutableString.strTest();


    }
}
