package Brilley.ClassicalAlgorithmsProblems;

/**
 * @author Brilley
 * @description voa-server
 * @date 2022-09-03 11:14
 */
import java.util.*;
import java.lang.*;
class Node {
    char vaule;
    Node left;
    Node right;
    Node(){}
    Node(char value) {
        this.vaule = value;
    }
    Node(Node node, char value, int i) {
        this.vaule = value;
        if ( i == 1) {
            this.right = node;
        } else if (i == 0) {
            this.left = node;
        }
    }
}
public class NodeTest {
    public static void test() {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        int[] seq = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            seq[i] = sc.nextInt();
            System.out.println(seq[i]);
        }
        String str = sc.next();
        System.out.println(str);
        ArrayList<Node> nodeArr = new ArrayList<>(n + 1);
        for (int i = 0; i < n; i++) {
            nodeArr.add(new Node(str.charAt(i)));
        }
        for (int i = 2; i <= n; i++) {
            Node parent = nodeArr.get(seq[i] - 1);
            if (parent.left == null) {
                parent.left = nodeArr.get(i - 1);
            } else {
                parent.right = nodeArr.get(i - 1);
            }
        }
        int[] result = new int[n];
        Set<Character> arrSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arrSet.clear();
            count(nodeArr.get(i), arrSet);
            result[i] = arrSet.size();
            System.out.print(result[i] + " ");
        }

    }
    private static void count(Node node, Set<Character> arrSet) {
        if (node == null) {
            return;
        }
        else {
            arrSet.add(node.vaule);
        }
        count(node.left, arrSet);
        count(node.right,arrSet);
    }
}
