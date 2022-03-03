package Brilley.Chapter01;

public class StaticMethodStudent {
    String name;
    int age;
    static String school="北京交通大学";
    public StaticMethodStudent(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public static void change(){
        school="清华大学";
    }
    public void printInfo()
    {
        System.out.println("The Student's name is: "+name+" and the age is "+age+" in the school "+ school);
    }
}
