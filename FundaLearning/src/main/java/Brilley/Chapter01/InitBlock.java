package Brilley.Chapter01;

/**
 * @author Brilley
 * @date 2022/3/1
 */
public class InitBlock {
    InitBlock()
    {
        System.out.println("constructor part");
    }

    {
        System.out.println("Init block part");
    }
}
