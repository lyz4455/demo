package com.example.demo.learnlab.bitset;

import java.util.BitSet;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2021-09-17 15:18
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.get(10) + " 10 " + bitSet.size());
        bitSet.set(10);
        System.out.println(bitSet.get(10) + " 10 " + bitSet.size());

        System.out.println(bitSet.get(164) + " 164 " + bitSet.size());
        bitSet.set(164);
        System.out.println(bitSet.get(164) + " 164 " + bitSet.size());

        System.out.println(bitSet.toString());
    }
}
