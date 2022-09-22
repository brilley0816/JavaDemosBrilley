package Brilley.ClassicalAlgorithmsProblems;

import java.lang.reflect.Method;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-22 12:45
 */
public class ReflectionTest {
    public static void test1() throws ClassNotFoundException{
        Method[] methods = Class.forName("Brilley.ClassicalAlgorithmsProblems.Son").getMethods();
        System.out.println("getMethods:");
        for (Method m: methods) {
            System.out.println(m.toString());
        }
        System.out.println("getDeclaredMethods: ");
        methods = Class.forName("Brilley.ClassicalAlgorithmsProblems.Son").getDeclaredMethods();
        for (Method m: methods) {
            System.out.println(m.toString());
        }
    }

    public static void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<Object> clazzA = (Class<Object>) Class.forName("Brilley.ClassicalAlgorithmsProblems.Son");
        Object a = clazzA.newInstance();
//        Class<Parent> clazzB = (Class<Parent>) Class.forName("Brilley.ClassicalAlgorithmsProblems.Parent");
//        Son s = new Son();
//        Class clazzC =s.getClass();
//        Class clazzD = Class.forName("Brilley.ClassicalAlgorithmsProblems.Son");
//        clazzD.getClass();
//        Class clazzE = Son.class;
//        Son a = (Son) clazzE.newInstance();

//        System.out.println(clazzE.equals(clazzD));

    }

    public static void test3() {
        A a = new A();
        A b = new B();
        A c = new C();
        System.out.println("==================");
        System.out.println(b.getClass() == B.class);
        System.out.println(c.getClass() == B.class);

        System.out.println("eeeeeeeeeeeeeeeeee");
        System.out.println(b.getClass().equals(B.class));
        System.out.println(c.getClass().equals(B.class));

        System.out.println("iiiiiiiiiiiiiiiiii");
        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
        System.out.println(b instanceof C);

        System.out.println("xxxxxxxxxxxxxxxxx");
        System.out.println(B.class.isInstance(a));
        System.out.println(B.class.isInstance(b));
        System.out.println(B.class.isInstance(c));
    }
}
class Parent {
    String name;
    // static block
    static {
        System.out.println("this is parent's static block");
    }
    int age;
    public void sayName(){
        System.out.println("name: " + name);
    }
}
class Son extends Parent{
    // static block
    static {
        System.out.println("this is son's static block");
    }

    // instance block
    {
        System.out.println("this is son's instance block");
    }
    public void doWork() {
        System.out.println("I can work!");
    }
    private void code() {
        System.out.println("I can code!");
    }
}

class A {
}

class B extends A{
}

class C extends B{
}

