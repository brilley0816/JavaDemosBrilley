package Brilley.JavaLearn;
import Brilley.BackTracking.EightQueens;
import Brilley.BackTracking.KnapsackPro;
import Brilley.BackTracking.LWSTDistance;
import Brilley.BinaryTree.BinaryHeap;
import Brilley.BinaryTree.BinaryTree;
import Brilley.BinaryTree.MyPriorityQueue;
import Brilley.Chapter02.ContactString;
//import Brilley.Chapter02.SplitString;
//import Brilley.Chapter03.ArrayTest;
//import Brilley.Chapter03.GenericTypeTest;
import Brilley.Chapter03.MyArray;
import Brilley.Chapter04.*;
import Brilley.Chapter05.ExceptionTest;
import Brilley.Chapter06.ArraysTools;
import Brilley.Chapter06.CollectionsTools;
import Brilley.Chapter06.GuavaTest;
import Brilley.Chapter06.Hutools;
import Brilley.Chapter07.BoxingUnboxingTest;
import Brilley.Chapter07.IOTest;
import Brilley.Chapter07.ParameterTransfer;
import Brilley.ClassicalAlgorithmsProblems.*;
import Brilley.DynamicProgramming.*;
import Brilley.Interview.TheLongestStr;
import Brilley.SearchAlgorithms.BinarySearch;
//import Brilley.SortAlgorithms.DictionarySort;
import Brilley.SortAlgorithms.MergeSort;
import Brilley.SortAlgorithms.QuickSort;
import Brilley.SortAlgorithms.SortedInPlace;
//import Brilley.Stream.ScannerTest;
import Brilley.concurrent.ThreadTest;
import Brilley.jvm.ClassLoaderTest;
import Brilley.stringRelated.EncodeString;
import Brilley.util.TimeComplexity;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.sql.SQLClientInfoException;
import java.time.LocalDateTime;
import java.util.*;
//import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        //Initialize : files created at the beginning
        /*
        System.out.println("hello world! This is Brilley Java learning demos ensembles!");
        StaticDataDemo sdd=new StaticDataDemo();
        System.out.println("directly use the Class's static data: Class.a: "+ StaticDataDemo.a);
        System.out.println("directly use the Class's field data: Object.b: "+ String.valueOf(sdd.b));
        sdd.InfoPrint();
        Test te=new Test();
        te.Info();

         */

        //03-01
        /*
        InstanceMethod im=new InstanceMethod();
        im.printName();
        //we can modify the static variable value ,if the instance method can modify the  static value
        im.modifyName("xiaoming");
        //verify the assumption
        im.printNameCurrent();
        //we can use print the protected variable in the Class InstanceMethod in the same package;
        System.out.println(im.methodName);
        //the protected variable in the Class Test but in the other package; can not see variable b;
        ///System.out.println(te.);

        CopyPerson cp=new CopyPerson("brilley",26);
        cp.printInfo();
        CopyPerson cp2=(CopyPerson) cp.clone();
        cp.printInfo();

        ExtendsInitBlock eib=new ExtendsInitBlock();

         */

        //03-02
        /*
        AppleIpad aIpad=new AppleIpad();
        System.out.println(aIpad.getElectricityUse());
        aIpad.printDescription();
        //AppleIpad does not has the static method from interface Electronic
        //System.out.println("aIpad is energy Efficient? "+AppleIpad.);
        //Electronic aIpadn=aIpad;
        System.out.println("aIpad is energy Efficient? "+Electronic.isEnergyEfficient("LED"));

        //multi extends
        Pig pg=new Pig();
        pg.fly();
        pg.run();

        //multi format
        List<Shape> shapeList=new ArrayList<>();
        Circle cir=new Circle();
        Square sqa=new Square();
        shapeList.add(cir);
        shapeList.add(sqa);
        for(Shape sha:shapeList)
        {
            sha.printShape();
        }

        StaticMethodStudent stu1=new StaticMethodStudent("brilley",25);
        StaticMethodStudent stu2=new StaticMethodStudent("yanyan",24);
        stu1.printInfo();
        stu2.printInfo();
        StaticMethodStudent.change();
        stu1.printInfo();
        stu2.printInfo();

         */

        //03-03
        /*
        //String is created by char[] in Java 8 and below version, from Java 9, the String has been created by byte[]
        // char is 2 bytes
        String strPool="strPool";
        String strPool2="strPool";
        //equals method is used to compare the value, of course they have the same values, so the output is true;
        //System.out.println(strPool.equals(StrPool2));
        // the output is true because the variables string value has been put in StringPool;
        System.out.println(strPool==strPool2);
        String strPool3=new String("StringPool");
        String strPool4=new String("StringPool");
        //System.out.println(strPool3.equals(strPool4));
        System.out.println(strPool3==strPool4);

        //error! Singleton has a private access
        //Singleton sing=new Singleton();
        // singleton is one type build method.
        Singleton sing;
        sing=Singleton.getInstance();
        System.out.println(sing.name);

         */

        //03-04
        /*
        ThisAsMethodResult tamr=new ThisAsMethodResult();
        //out method is a default private access, this is not in the same package
        //tamr.ou  add public access in the Class
        tamr.out();
        tamr.getThisAsMethodResult().out();
        System.out.println(tamr instanceof ThisAsMethodResult);//true // corresponding to the relation "is a "
        //System.out.println(tamr instanceof Circle);
        System.out.println(null instanceof Circle);
        ThisAsMethodResult thisTamr;
        //System.out.println(thisTamr instanceof Circle);

         */

        //03-12
        /*
        NoGenericArraylist list1=new NoGenericArraylist(5);
        list1.add("brilley");
        list1.add(new Date());
        //System.out.println(list1); NullPointerException
        String listE1=(String) list1.get(0);
        Date listE2=(Date) list1.get(1);
        System.out.println(listE1+listE2);

        GenericArraylist<String> list2=new GenericArraylist<>(5);
        list2.add("brilley");
        list2.add("yanyan");
        System.out.println(list2);
        System.out.println(list2.get(0));
        GenericArraylist<Date> list3=new GenericArraylist<>(5);
        list3.add(new Date());
        list3.add(new Date());
        System.out.println(list3);
        System.out.println(list3.get(1));
        String[] strsTest=new String[2];
        strsTest=list2.toArray(strsTest);
        for(String str:strsTest)
        {
            System.out.println(str);
        }
        Writer cmower = new Writer(18,"沉默王二","Web全栈开发进阶之路");
        System.out.println(JsonSerializer.serialize(cmower));

        Constructor[] constructors=String.class.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }


        //reflection to get An Array
        Class<?> cls=Class.forName("java.lang.String");
        Object array= Array.newInstance(cls,25);
        Array.set(array, 0, "Scala");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "Groovy");
        Array.set(array, 3, "Scala");
        Array.set(array, 4, "Clojure");
        System.out.println(Array.get(array,2));

        StaticProxy sp=new StaticProxy();
        sp.hello("brilley");
        sp.bye();

        //Dynamic proxy
        Subject realSubject=new RealSubject();

        InvocationHandler handler=new InvocationHandlerDemo(realSubject);

        Subject subject=(Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(),handler);
        System.out.println(subject.getClass().getName());
        subject.hello("World");
        String result=subject.bye();
        System.out.println("Real result is "+result);

        ImmutableString.strTest();

         */


        //03-13
        /*
        //value equal
        String name1="brilley";
        String name2="brilley";
        System.out.println(name2.equals(name1));
        //reference equal
        System.out.println(name1==name2);
        System.out.println(Objects.equals(name1,name2));

        StringBuffer name3=new StringBuffer("brilley");
        System.out.println(name3.equals(name1));
        System.out.println(name1.contentEquals(name3));

        // the result is so obvious!
        ContactString.addOperator();
        ContactString.strBuildOperator();

        SplitString.test1();
        SplitString.test2();
        SplitString.testPattern();
        SplitString.test3();

        ArrayTest.test();
        ArrayTest.printArray();

        GenericTypeTest.test();
        GenericTypeTest.test2();

         */

        //03-14
        /*
        MyArray myarr=new MyArray(5);
        myarr.insert(0,10);
        myarr.insert(1,2);
        myarr.insert(2,3);
        myarr.insert(1,4);
        //[10, 4, 2, 3, 0]
        System.out.println(myarr.length());
        myarr.insert(3,5);
        System.out.println(myarr.length());
        myarr.insert(4,8);
        myarr.insert(5,9);
        System.out.println(myarr.length());
        myarr.print();
        myarr.delete(1);
        myarr.print();

         */

        //03-15
        /*
        MyQueue myqueue=new MyQueue(5);
        myqueue.enQueue(2);
        myqueue.enQueue(3);
        myqueue.enQueue(4);
        //
        myqueue.output();
        myqueue.quitQueue();
        myqueue.quitQueue();
        myqueue.output();

         */

        //03-16
        /*
        MyIntArrList myIntArrList=new MyIntArrList();
        myIntArrList.add(2);
        myIntArrList.add(3);
        myIntArrList.add(4);
        myIntArrList.print();
        System.out.println(myIntArrList.count());
        System.out.println(myIntArrList.get(1));
        myIntArrList.delete(1);
        System.out.println(myIntArrList.get(1));
        myIntArrList.print();

        MyLinkedList<String> mylList=new MyLinkedList<>();
        mylList.add("brilley");
        mylList.add("yanyan");
        mylList.print();

         */

        //03-17
        /*
        ArrayListTest.addFromFirst(100000);
        ArrayListTest.addFromMid(100000);
        ArrayListTest.addFromLast(100000);
        LinkedListTest.addFromFrist(100000);
        LinkedListTest.addFromMid(100000);
        LinkedListTest.addFromLast(100000);
        LinkedListTest.forPrint(10000);
        LinkedListTest.iteratorPrint(10000);

        MySinglyLinkedList list=new MySinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        list.reverseList();
        list.print();

         */

        //03-18
        /*
        CircleQueue cirQueue=new CircleQueue(6);
        cirQueue.enQueue("brilley");
        cirQueue.enQueue("love");
        cirQueue.enQueue("yanyan");
        cirQueue.print();
        cirQueue.quitQueue();
        cirQueue.quitQueue();
        cirQueue.enQueue("super love");
        cirQueue.enQueue("brilley");
        cirQueue.print();
        System.out.println(cirQueue.quitQueue());
        System.out.println(cirQueue.quitQueue());
        System.out.println(cirQueue.quitQueue());
        System.out.println(cirQueue.quitQueue());
        cirQueue.print();
         */

        //03-19
        /*
        ExceptionTest.test1("Singleton");
        ExceptionTest.test1("Singleton2");
        System.out.println("the programme is going on");
        ExceptionTest.test2("Singleton");
        //ExceptionTest.test2("Singleton1");
        System.out.println("the programme is going on");
        System.out.println("I love yanyan!");
        LocalDateTime time1=LocalDateTime.now();
        System.out.println(time1);
        time1=LocalDateTime.now();
        System.out.println(time1);

         */

        //03-20
        /*
        ArraysTools.test1();
        CollectionsTools.test1();
        Hutools.test1();
        GuavaTest.testOptional();
        GuavaTest.testImmutable();

         */

        //03-21
        /*
        BoxingUnboxingTest.test1();
        BoxingUnboxingTest.test2();
        //BoxingUnboxingTest.testEfficiency();
        //the time to compute the sum of 0-Integer.MAX_VALUE by float type variable: 5583
        //the time to compute the sum of 0-Integer.MAX_VALUE by float type variable: 575

        Random r=new Random();
        int[] arrs=new int[]{r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100)};
        System.out.println(Arrays.toString(arrs));
        SortedInPlace.bubbleSort(arrs);
        int[] arrsb=new int[]{r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100)};
        System.out.println(Arrays.toString(arrsb));
        SortedInPlace.insertSort(arrsb);
        SortedInPlace.selectSort(arrsb);
        int[] testArray=new int[10000];
        for(int i=0;i<testArray.length;i++)
            testArray[i]=r.nextInt(1000);
        System.out.println(Arrays.toString(testArray));
        long t1=System.currentTimeMillis();
        System.out.println("sort algorithm: bubble: ");
        SortedInPlace.bubbleSort(testArray);
        long t2=System.currentTimeMillis();
        System.out.println("spend time: "+(t2-t1));

        System.out.println("sort algorithm: insert: ");
        SortedInPlace.insertSort(testArray);
        long t3=System.currentTimeMillis();
        System.out.println("spend time: "+(t3-t2));

        System.out.println("sort algorithm:select: ");
        SortedInPlace.selectSort(testArray);
        long t4=System.currentTimeMillis();
        System.out.println("spend time: "+(t4-t3));

         */

        //03-23
        /*
        ParameterTransfer.test1();
        IOTest.test1();
        IOTest.test2();
        IOTest.test3();
        IOTest.test4();

         */


        //03-24
        //ThreadTest.test1();
        //System.out.println("Daemon has been set");
        //ThreadTest.test2();
        //System.out.println("Thread Join has been set");
        //ThreadTest.test3();
//        Random r=new Random();
//        int[] arrs=new int[]{r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100)};
//        //MergeSort.sort(arrs);
//        //QuickSort.sort(arrs);
//        System.out.println(QuickSort.kthMaxValue(arrs,2));
//        QuickSort.sort(arrs);
//        ClassLoaderTest.test1();



        //0329-0331
        /*
        Random r=new Random();
        int[] arrs=new int[]{r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100)};
        int val=arrs[0];
        arrs[1]=val;
        System.out.println(Arrays.toString(arrs));
        QuickSort.sort(arrs);
        System.out.println("BinarySearch Result is "+BinarySearch.searchImp1(arrs,8));
        System.out.println("BinarySearch Result is"+BinarySearch.searchImp1(arrs,9));
        System.out.println("BinarySearch Result is "+BinarySearch.searchImp1(arrs,10));
        System.out.println("BinarySearch Result is "+BinarySearch.searchImp1(arrs,22));
        System.out.println("BinarySearch Result is "+BinarySearch.searchImp2(arrs,0,arrs.length-1,22));
        System.out.println("BinarySearch Result is "+BinarySearch.searchImp2(arrs,0,arrs.length-1,23));
        System.out.println("the length of arrays is "+arrs.length);
        System.out.println("BinarySearch Result is "+BinarySearch.bSearchFirst(arrs,0,arrs.length-1,val));
        System.out.println("BinarySearch Result is "+BinarySearch.bSearchLast(arrs,0,arrs.length-1,val));
        System.out.println("BinarySearch Result is "+BinarySearch.bSearchFirstGreaterOrEqual(arrs,0,arrs.length-1,val-1));
        System.out.println("BinarySearch Result is "+BinarySearch.bSearchLastLessOrEqual(arrs,0,arrs.length-1,val));

         */

        /*
        //04-01
        BinaryTree.test1();

        //04-04
        BinaryHeap.test1();

        MyPriorityQueue mpq=new MyPriorityQueue();
        mpq.enQueue(1);
        mpq.enQueue(8);
        mpq.enQueue(4);
        mpq.enQueue(17);
        mpq.enQueue(8);
        mpq.enQueue(10);
        System.out.println("deQueue: "+mpq.deQueue());
        System.out.println("deQueue: "+mpq.deQueue());
        System.out.println("deQueue: "+mpq.deQueue());

        Random r=new Random();
        int[] arrs=new int[]{r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100),r.nextInt(100)};
        //QuickSort.sort(arrs);
        BinaryHeap.heapSort(arrs);
        int a=r.nextInt(100);
        int b=r.nextInt(1000);
        System.out.println("The greatest common divisor between "+a+" "+b+ " is: "+CommonDivisor.getGreatestCommonDivisorV1(a,b));
        System.out.println("The greatest common divisor between "+a+" "+b+ " is: "+CommonDivisor.getGreatestCommonDivisorV2(a,b));
        System.out.println("The greatest common divisor between "+a+" "+b+ " is: "+CommonDivisor.getGreatestCommonDivisorV3(a,b));
        System.out.println("The greatest common divisor between "+a+" "+b+ " is: "+CommonDivisor.getGreatestCommonDivisorV4(a,b));
        System.out.println(a+" is a number power of 2? "+IsPowerOf2.isPowerOf2(a));
        System.out.println(b+" is a number power of 2? "+IsPowerOf2.isPowerOf2(b));

         */

        //04-06
        /*
        MaximumGold.test1();

        //04-06
        MaximumGold.test2();
        MaximumGold.test3();

        StackQueue sq1=new StackQueue();
        sq1.enQueue(1);
        sq1.enQueue(23);
        sq1.enQueue(54);
        System.out.println(sq1.deQueue());
        System.out.println(sq1.deQueue());
        System.out.println(sq1.deQueue());
        System.out.println(sq1.deQueue());
        int[] testArr=new int[]{1,4,6,3,5};
        DictionarySort.findNearBiggestValue(testArr);

        //ScannerTest.test1();
        //ScannerTest.test2();
        ScannerTest.test3();

         */

        //04-11
        //RemoveKDigits.test1();
        //TimeComplexity.test1();
        //EncodeString.test2();

        //04-12
        /*
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 3);
        lruCache.put(2, 3);
        lruCache.put(3, 3);
        lruCache.put(4, 3);
        lruCache.put(5, 3);
        lruCache.print();
        lruCache.get(2);
        lruCache.print();
        lruCache.put(3,5);
        lruCache.print();
        lruCache.put(6,5);
        lruCache.print();

         */

        //04-21
        //ScoreNum.test1();

        //05-06
        /*
        EightQueens.cal8queens(0);
        System.out.println(EightQueens.nums);
        KnapsackPro.findMaxWeight1(0,0);
        System.out.println(KnapsackPro.wMax);
        System.out.println(KnapsackPro.nums);
        KnapsackPro.findMaxWeight2(0,0);
        System.out.println(KnapsackPro.wMax);
        System.out.println(KnapsackPro.nums);
        KnapsackProDP.knapsack();
        KnapsackProDP.knapsack2();
        KnapsackProDP.knapsack3();
        System.out.println("Longest path: " + MetrixLongestPath.findLongestPath2(3,3));
        MetrixLongestPath.findLongestPath();

         */

        //05-07
        /*
        long t1 = System.currentTimeMillis();
        LWSTDistance.lwstDistance("mitcmu","matcnu");
        LWSTDistance.lwstDistance("mitcmu","mtacnu");
        LWSTDistance.lwstDistance("brilley","mtacnu");
        //LWSTDistance.lwstDistance2("brilleybrilleybrilleybrilleybrilleybrilleybrilleybrilley","mtacnumtacnumtacnumtacnumtacnumtacnumtacnu");
        long t2 = System.currentTimeMillis();
        System.out.println("time : " + (t2 - t1));

        long t3 = System.currentTimeMillis();
        LWSTDistance.lwstDistance2("mitcmu","matcnu");
        LWSTDistance.lwstDistance2("mitcmu","mtacnu");
        LWSTDistance.lwstDistance2("brilley","mtacnu");
        //LWSTDistance.lwstDistance2("brilleybrill","mtacnumtacn");
        long t4 = System.currentTimeMillis();
        System.out.println("time : " + (t4 - t3));

        long t5 = System.currentTimeMillis();
        LWSTDistanceDP.lwstDistance1("mitcmu","mtacnu");
        LWSTDistanceDP.lwstDistance1("mitcmu","matcnu");
        LWSTDistanceDP.lwstDistance1("brilley","mtacnu");
        //LWSTDistanceDP.lwstDistance1("brilleybrilleybrilleybrilleybrilleybrilleybrilleybrilley","mtacnumtacnumtacnumtacnumtacnumtacnumtacnu");
        //LWSTDistanceDP.lwstDistance1("brilleybrilleybrilleybrilleybrilleybrilleybrilleybrilleyyanyan","mtacnumtacnumtacnumtacnumtacnumtacnumtacnu");
        long t6 = System.currentTimeMillis();
        System.out.println("time : " + (t6 - t5));

        long t7 = System.currentTimeMillis();
        LWSTDistanceDP.lwstDistance2("mitcmu", "mtacnu");
        LWSTDistanceDP.lwstDistance2("mitcmu","matcnu");
        LWSTDistanceDP.lwstDistance2("brilley","mtacnu");
        //LWSTDistanceDP.lwstDistance2("brilleybrilleybrilleybrilleybrilleybrilleybrilleybrilley","mtacnumtacnumtacnumtacnumtacnumtacnumtacnu");
        //LWSTDistanceDP.lwstDistance2("brilleybrilleybrilleybrilleybrilleybrilleybrilleybrilleyyanyan","mtacnumtacnumtacnumtacnumtacnumtacnumtacnu");
        long t8 = System.currentTimeMillis();
        System.out.println("time: " + (t8 - t7));

         */

//        long t9 = System.currentTimeMillis();
//        LongestComStr.getLongestCommonStr("abc","abccd");
//        long t10 = System.currentTimeMillis();
//        System.out.println("time: " + (t10 - t9));
//
//        long t11 = System.currentTimeMillis();
//        LongestComStr.getLongestCommonStr2("abc","abccd");
//        LongestComStr.getLongestCommonStr2("12345","23415");
//        LongestComStr.getLongestCommonStr2("123459","234159999");
//        long t12 = System.currentTimeMillis();
//        System.out.println("time: " + (t12 - t11));


        //05-25
        /*
        boolean rest = StateMachineForNumInput.isNumber("-18e1919");
        System.out.println(rest);

         */

        // 06-08
//        LWSTDistanceDP.lwstDistance1("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
//        LWSTDistanceDP.lwstDistance2("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
//        LWSTDistanceDP.lwstDistance3("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
//        LWSTDistanceDP.lwstDistance4("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
//
//        LWSTDistanceDP.lwstDistance1("pneumonoultramicroscopicsili","ultramicroscopically");
//        LWSTDistanceDP.lwstDistance2("pneumonoultramicroscopicsili","ultramicroscopically");
//        LWSTDistanceDP.lwstDistance3("pneumonoultramicroscopicsili","ultramicroscopically");

        // 07-08
//        TheLongestStr.test();
//        TheLongestStr.test2();

        // 07-20
        int m = 4;
        int[]  sellPrice ={6, 6, 1, 3};
        int[] realValue = {1, 4, 4, 1};
        MaxRealValue.maxRealValue(m,sellPrice, realValue);
    }

}
