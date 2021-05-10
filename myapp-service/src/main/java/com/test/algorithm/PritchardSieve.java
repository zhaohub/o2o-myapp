package com.test.algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * 筛法求素数
 */
public class PritchardSieve {

   public static void main(String[] args) {
      outputPrime(100000);
      System.out.println(sieve(100000));
   }


   private static void outputPrime(int n) {
      //合数
      boolean[] c = new boolean[n + 1];
      c[0] = c[1] = true;

      List<Integer> primes = new ArrayList<>();
      int m = 0;

      for (int i = 2; i <= n / 2; ++i) {
         if (i % 10000000 == 0) {
            System.out.println("当前i=" + i + " 素数个数=" + m);
         }
         if (!c[i]) {
            primes.add(m++, i);
         }

         for (int j = 0; j < m && primes.get(j) <= n / i; ++j) {
            c[primes.get(j) * i] = true; //筛去
            if (i % primes.get(j) == 0) { //找到了最小素因子
               break;
            }
         }
      }
      for (int i = n / 2 + 1; i <= n; ++i) {
         if (!c[i]) {
            primes.add(m++, i);
         }
      }
      System.out.println("素数个数:" + m);
      //System.out.println(primes);
   }

   private static int sieve(int n) {
      int p = 0; //素数个数
      boolean[] primes = new boolean[n];
      for (int i = 0; i < n; i++) {
         primes[i] = true;
      }
      primes[0] = primes[1] = false;

      int i = 2;
      for (; i * i < n; ++i) {
         if (primes[i]) {
            p++;
            for (int j = i * i; j < n; j += i) {
               primes[j] = false;
            }
         }
      }
      for (; i < n; ++i) {
         if (primes[i]) {
            p++;
         }
      }
      return p;
   }
}
