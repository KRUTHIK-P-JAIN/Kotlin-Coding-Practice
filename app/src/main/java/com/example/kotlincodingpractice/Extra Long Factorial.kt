package com.example.kotlincodingpractice

/**
Problem: Extra Long Factorials

You are given an integer n (1 ≤ n ≤ 100).

Compute n! (factorial of n).

The value of n! grows very quickly and cannot fit into 64-bit integers.
Therefore, you must use BigInteger (arbitrary-precision integers).

Example:
Input:
25

Output:
15511210043330985984000000

Explanation:
25! is a 26-digit number, far larger than Long.

Constraints:
1 ≤ n ≤ 100

Goal:
Print the factorial of n using BigInteger.

---------------------------------
Kotlin Solution (BigInteger)
---------------------------------
*/

import java.math.BigInteger

fun extraLongFactorials(n: Int) {
    var result = BigInteger.ONE

    for (i in 1..n) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }

    println(result)
}

fun main() {
    println("Enter a number")
    val n = readln().trim().toInt()
    extraLongFactorials(n)
}

/**
---------------------------------
Explanation
---------------------------------
- BigInteger can store very large numbers beyond Long range.
- Loop from 1 to n multiplying the value each time.
- For n=100, the result has 158 digits.
- Time complexity: O(n * bigint multiplication cost).
*/