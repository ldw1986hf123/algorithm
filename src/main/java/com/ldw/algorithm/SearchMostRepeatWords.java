package com.ldw.algorithm;


/**
 * 假如有10G的数据，内存只有4G甚至更小，要求求出重复率最高的前K个数
 * 思路：
 * 先将大文件按照规则分成若干个小文件
 * 遍历每个小文件，用map确定重复次数
 * 将map的元素插入到大小为K的小根堆中
 * 遍历结束之后，小根堆中剩余的元素就是重复次数最多的K个元素
 *
 */
public class SearchMostRepeatWords {
}
