package Brilley.Chapter06;


import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Brilley
 * @date 2022/3/21
 */
public class GuavaTest {
    public static void testOptional(){
        Optional<Integer> possible= Optional.of(5);
        System.out.println("possible.isPresent(): "+possible.isPresent());
        System.out.println("possible.get(): "+possible.get());
    }

    public static void testImmutable(){
        List<String> list=new ArrayList<>();
        list.add("heihie");
        list.add("1234");
        System.out.println(list);
        List unmodifiableList= Collections.unmodifiableList(list);
        //unmodifiableList.add("test"); //Exception in thread "main" java.lang.UnsupportedOperationException
        list.add("test");
        System.out.println(unmodifiableList);//unmodifiable changed

        ImmutableList<String> immutableList=ImmutableList.copyOf(list);
        list.add("cc");
        //immutableList.add("cc");//error
        System.out.println(list);
        System.out.println(immutableList);
    }
}
