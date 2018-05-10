/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulateshuffleexchange;

/**
 *
 * @author motamed
 */
public class Covert {

    public static void main(String[] args) {

        int n = 3;
        System.out.println(n + " exchange " + exchange(n, 0));
        for (int i = 0; i < 8; i++) {
            System.out.println(i + " shuffle " + shuffle(i));
        }

    }

    public static int exchange(int value, int suffixE) {
        String binValue = Integer.toBinaryString(value);
        StringBuilder sb = new StringBuilder(binValue);
        char last = sb.charAt(sb.length() - 1);
        char exchange;
        if (last == '0') {
            exchange = '1';
        } else {
            exchange = '0';
        }

        sb.setCharAt(sb.length() - 1, exchange);
        return Integer.parseInt(sb.toString(), 2);
    }

    public static int shuffle(int value) {
        String binValue = Integer.toBinaryString(value);
        StringBuilder sb = new StringBuilder(binValue);
        //add leading zeros 
        while (sb.length() < 3) {
            sb.insert(0, '0');
        }
        char beLast = sb.charAt(0);
        sb.deleteCharAt(0);
        sb.append(beLast);

        return Integer.parseInt(sb.toString(), 2);

    }

}
