package Brilley.Chapter02;

public class ContactString {

    //the number of 1000 is samll ,so change to 10000
    public static  void addOperator(){
        long startTime=System.currentTimeMillis();
        String ss="wo";
        for(int i=0;i<10000;i++){
            ss+="hi";
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void strBuildOperator(){
        long startTime=System.currentTimeMillis();
        StringBuilder ss=new StringBuilder("wo");
        for(int i=0;i<10000;i++){
            ss.append("hi");
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

}
