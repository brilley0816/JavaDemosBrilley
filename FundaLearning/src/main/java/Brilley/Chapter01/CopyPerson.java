package Brilley.Chapter01;

/**
 * @author Brilley
 * @date 2022/3/1
 */
public class CopyPerson implements Cloneable {
    private String name;
    private int age;
    public CopyPerson(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public void printInfo()
    {
        System.out.println("The person's name is: "+name+" and the age is "+age);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
