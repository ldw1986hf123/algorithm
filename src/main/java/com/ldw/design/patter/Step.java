package com.ldw.design.patter;

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
 * 思路：这是最典型的类似斐波那契数列的变型。N阶楼梯，第一步有两种走法，
 * 1、走一步，则剩下N-1级
 * 2，走两步，剩下N-2级
 * 所以f（n）=f(n-1)+f(n-2)
 */
public class Step {

    public static void main(String[] args) {
        System.out.println(ways(8));
    }

    public static int ways(int n) {
        if (n == 1)
            return 1;
        if (n == 2) return 2;
        return ways(n - 1) + ways(n - 2);
    }

}