package Brilley.JavaLearn;

/**
 * @author Brilley
 * @date 2022/3/1
 */
public class InstanceMethod {
    //variable name can only be used in this Class
    String name;
    protected String methodName;

    public void printName(){
        name="private variable in InstanceMethod Class printName method";
        System.out.println("the method name is :"+name);
    }

    public void modifyName(String str){
        name=str;
        System.out.println("the private variable name is modified to "+name);
    }

    public void printNameCurrent(){
        System.out.println("the static variable current value is "+name);
    }

}
