package Brilley.Chapter01;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * @author Brilley
 * @date 2022/3/1
 */
public class ExtendsInitBlock extends InitBlock {
    public ExtendsInitBlock()
    {
        System.out.println("the extends class constructor part");
    }

    {
        System.out.println("the extends class init block part");
    }
}
