package Brilley.Chapter01;

import javax.sound.midi.Soundbank;

/**
 * @author Brilley
 * @date 2022/3/12
 */
public class RealSubject implements Subject{
    @Override
    public void hello(String str){
        System.out.println("hello "+str);
    }

    @Override
    public String bye(){
        System.out.println("Goodbye");
        return "Over";
    }
}
