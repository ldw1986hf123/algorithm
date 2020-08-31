package com.ldw.design.patter;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.application.Application;


/**
 * 题目：一个楼梯有N阶，从下往上走，一步可以走一阶，也可以走两阶，有多少种走法？
 * 解:
 * 例如3阶楼梯有3种走法：
 * 1、1、1
 * 1、2
 * 2、1
 * 输入样例：
 * 3
 * 返回值样例：
 * <p>
 * 3
 * 思路：此题可以用倒推法理解,即走到n级台阶前有2种情况（即最后一步有2种情况可以走到第n级）,
 * 就是（n－1）级时向上走1级或（n－2）级时向上走2级,而走到（n－1）级时有f（n－1）种走法,走到（n－2）级时有f（n－2）种走法,
 * 所以f（n）＝f（n－1）＋f（n＋2）
 */
public class Step {

    public static void main(String[] args) {
//        System.out.println(ways(8));

        System.out.println(repeatPush(4));

    }

    /**
     * 是编程最方便的解法，当然，也是效率最低的解法，原因是会出现大量的重复计算。为了避免这种情况，可以采用递推的方式。
     * @param n
     * @return
     */
    public static int ways(int n) {
        if (n == 1)
            return 1;
        if (n == 2) return 2;
        return ways(n - 1) + ways(n - 2);
    }

    /**
     * 递推求解
     */
    public static int repeatPush(int n) {
        int a[] = new int[n];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

}