package com.example.kotlincodingpractice

/*
PROBLEM: Non-Divisible Subset

You are given:
- An integer k
- An array of integers s[]

Goal:
Find the maximum size of a subset such that
the sum of any two numbers in the subset is NOT divisible by k.

--------------------------------------------------
KEY IDEA (MODULO LOGIC)

If:
(a + b) % k == 0
then
(a % k + b % k) % k == 0

So instead of numbers, we only care about their remainders modulo k.

--------------------------------------------------
IMPORTANT OBSERVATIONS

1. Remainder 0:
   - Any two numbers with remainder 0 will sum to a multiple of k.
   - So we can take ONLY ONE number with remainder 0.

2. Remainders i and (k - i):
   - i + (k - i) = k → divisible by k
   - So we must choose the larger group between them, not both.

3. Special case when k is even:
   - Remainder k/2 + k/2 = k → divisible
   - So we can take ONLY ONE element with remainder k/2.

--------------------------------------------------
ALGORITHM

1. Count frequency of each remainder: freq[r] = count of numbers where n % k == r
2. Start result = min(1, freq[0])
3. For i from 1 to k/2:
   - If i != k - i:
       result += max(freq[i], freq[k - i])
   - Else (i == k/2):
       result += min(1, freq[i])
4. Print result

--------------------------------------------------
TIME & SPACE
Time: O(n + k)
Space: O(k)

--------------------------------------------------
EXAMPLE

Input:
s = [1, 7, 2, 4]
k = 3

Remainders:
1 % 3 = 1
7 % 3 = 1
2 % 3 = 2
4 % 3 = 1

freq = [0, 3, 1]

Pairs:
- remainder 1 vs 2 → pick max(3,1) = 3

Output: 3
*/

fun nonDivisibleSubset(k: Int, s: IntArray): Int {
    val freq = IntArray(k)

    for (num in s) {
        freq[num % k]++
    }

    var result = minOf(1, freq[0])

    for (i in 1..k / 2) {
        result += if (i != k - i) {
            maxOf(freq[i], freq[k - i])
        } else {
            minOf(1, freq[i])
        }
    }

    return result
}

fun main() {
    val firstLine = readln().trim().split(" ")
    val k = firstLine[1].toInt()

    val s = readln().trim().split(" ").map { it.toInt() }.toIntArray()

    println(nonDivisibleSubset(k, s))
}
