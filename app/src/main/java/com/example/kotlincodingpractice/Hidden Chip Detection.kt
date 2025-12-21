package com.example.kotlincodingpractice

/*
Hidden Chip Detection

Problem Statement:
You are given a dataset of n square-shaped chips, each weighing 1 gram.
Each chip has a specific side length.

A chip is considered hidden if the side length of the larger chip is at least k times
greater than the side length of the smaller chip:
    largerSide ≥ k × smallerSide

Since each chip weighs 1 gram and the total weight must not exceed 2 grams,
at most one chip can be hidden inside another, and each chip can be used only once.

Task: Given an array imageDim containing the side lengths of each chip,
determine the maximum number of chips that can be hidden inside other chips.

---

Input Format:
n
imageDim[0]
imageDim[1]
...
imageDim[n-1]
k

Output Format:
An integer representing the maximum number of chips that can be hidden

Constraints:
1 ≤ n ≤ 2 × 10^5
1 ≤ imageDim[i] ≤ 10^9
1 ≤ k ≤ 10^9

---

Sample Input 0:
5
6
4
2
4
8
2

Sample Output 0:
2

Sample Input 1:
4
4
2
6
14
3

Sample Output 1:
2
*/

fun getMaxHiddenChips(imageDim: MutableList<Int>, k: Int): Int {
    val arr = imageDim.sorted()
    val n = arr.size

    var count = 0
    var i = 0

    for (j in n/2 until n) {
        if (i >= n/2) break

        if (arr[j].toLong() >= arr[i].toLong() * k.toLong()){
            count++
            i++
        }
    }

    return count
}

fun main() {
    println("Enter n")
    val n = readln().trim().toInt()
    val imageDim = mutableListOf<Int>()

    println("Enter $n elements of imageDim one below other")
    repeat(n) {
        val x = readln().trim().toInt()
        imageDim.add(x)
    }

    println("Enter k")
    val k = readln().trim().toInt()

    println("The maximum number of chips that can be hidden inside other chips: ${getMaxHiddenChips(imageDim, k)}")

}

/*
Why sort?
Sorting ensures we pair the smallest chip with the smallest possible larger chip
that satisfies the k constraint. This greedy strategy guarantees the maximum
number of valid pairs without wasting larger chips.

Why n/2?
Each hiding uses 2 chips, so at most n/2 chips can be hidden. Restricting hidden
candidates to the smallest half guarantees that an optimal solution always exists,
because larger chips are better used as containers.

Why toLong()?
Constraints allow values up to 10^9 for side lengths and k. Multiplying two Int values
can overflow (10^9 × 10^9 = 10^18 > Int.MAX_VALUE). Using toLong() ensures safe
multiplication and correct comparisons.
 */
