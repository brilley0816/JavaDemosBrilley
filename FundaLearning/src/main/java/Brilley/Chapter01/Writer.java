package Brilley.Chapter01;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class Writer {
    private int age;
    @JsonField("writerName")
    private String name;
    @JsonField
    private String bookName;

    public Writer(int age, String name, String bookName){
        this.age=age;
        this.name=name;
        this.bookName=bookName;
    }

    @Override
    public String toString(){
        return "Writer{"+
                "age="+age+
                ", name='"+name+'\''+
                ", bookName='"+bookName+'\''+
                '}';
    }

}
