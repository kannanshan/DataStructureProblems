package com.hackerrank.hard.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DNA {

        static class Trie {
        int health;
        char ch;
        Trie[] subTrie = new Trie[26];

        public Trie() {
        }

        void addHealth(String input, int health) {
            if (input.length() == 0)
                this.health += health;
            else {
                if (subTrie[input.charAt(0) - 'a'] == null) {
                    subTrie[input.charAt(0) - 'a'] = new Trie();
                }
                subTrie[input.charAt(0) - 'a'].addHealth(input.substring(1), health);
            }
        }

        int getHealth(String input) {
            if (input.length() == 0 || subTrie[input.charAt(0) - 'a'] == null)
                return this.health;
            return subTrie[input.charAt(0) - 'a'].getHealth(input.substring(1));
        }

    }

    public static int getHealth(String[] gene, int[] health, int start, int end, String dna) {
        Trie input = new Trie();
        int healthValue = 0;
        for (int i = start; i <= end; i++) {
            input.addHealth(gene[i], health[i]);
        }
        for (int i = 0; i < dna.length(); i++) {
            healthValue += input.getHealth(dna.substring(i));
        }
        return healthValue;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	int max=Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int temp=0;
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];

            temp = getHealth(genes, health, first, last, d);
            max=Math.max(max, temp);
            min=Math.min(min, temp);
        }
        System.out.print(min+" "+max);
        scanner.close();
    }
}
