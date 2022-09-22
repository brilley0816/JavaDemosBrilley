package Brilley.ClassicalAlgorithmsProblems;

import java.net.DatagramPacket;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-22 16:19
 */
class CpData implements Comparable<CpData> {
    int data;
    String name;
    int value;
    public void print() {
        System.out.println("data: " + data + "; name: " + name + "; value: " + value);
    }

    @Override
    public int compareTo(CpData o) {
        if (this.data < o.data) {
            return -1;
        } else if (this.data == o.data) {
            return this.name.compareTo(o.name);
        } else {
            return 1;
        }
    }
}

public class CompareTest {
    public static void test1() {
        CpData[] nums = new CpData[5];
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            nums[i] = new CpData();
            nums[i].data = rd.nextInt(16);
            nums[i].name = String.valueOf(rd.nextInt(20));
            nums[i].value = rd.nextInt(20) + 16;
        }
        Arrays.sort(nums);
        for (CpData cd : nums) {
            cd.print();
        }

    }

    public static void test2() {
        CpData[] nums = new CpData[5];
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            nums[i] = new CpData();
            nums[i].data = rd.nextInt(16);
            nums[i].name = String.valueOf(rd.nextInt(20));
            nums[i].value = rd.nextInt(20) + 16;
        }
        Arrays.sort(nums, new Comparator<CpData>() {
            @Override
            public int compare(CpData o1, CpData o2) {
                if(o1.data < o2.data) {
                    return -1;
                } else if (o1.data == o2.data) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (CpData cd : nums) {
            cd.print();
        }

    }
}
