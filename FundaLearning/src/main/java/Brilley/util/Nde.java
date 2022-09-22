package Brilley.util;
import  java.util.*;
/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-21 10:56
 */
public class Nde {
    String str;
    ArrayList<Nde> al = new ArrayList<Nde>();
    ArrayList<Integer> prices = new ArrayList<>();
    int distance;
    Nde bestPath() {
        int small = smallest(this.al, this.prices);
        return al.get(small);
    }
    int smallest(ArrayList<Nde> no, ArrayList<Integer> prize) {
        int answer = 0;
        for (int uu = 1; uu < prize.size(); uu++) {
            if ((no.get(uu).distance + prize.get(uu))> (no.get(uu - 1).distance + prize.get(uu - 1))) {
                answer = uu - 1;
            } else  {
                answer = uu;
            }
        }
        return answer;
    }

    public static void test1() {
        Nde nd1 = new Nde();
        nd1.str = "A";
        Nde nd2 = new Nde();
        nd2.str = "B";
        Nde nd3 = new Nde();
        nd3.str = "C";
        Nde nd4 = new Nde();
        nd4.str = "D";
        Nde nd5 = new Nde();
        nd5.str = "E";
        nd1.distance = 10;
        nd1.al.add(nd2);
        nd1.prices.add(5);
        nd1.al.add(nd3);
        nd1.prices.add(2);

        nd2.distance = 10;
        nd2.al.add(nd4);
        nd2.prices.add(1);

        nd3.distance = 15;
        nd3.al.add(nd4);
        nd3.prices.add(3);
        nd3.al.add(nd5);
        nd3.prices.add(5);

        nd4.al.add(nd5);
        nd4.prices.add(3);
        nd4.distance = 5;
        nd5.distance = 0;

        Nde nooo = nd1;
        System.out.print(nooo.str);
        while (nooo.distance != 0) {
            nooo = nooo.bestPath();
            System.out.print("->" + nooo.str);
        }

    }
}
