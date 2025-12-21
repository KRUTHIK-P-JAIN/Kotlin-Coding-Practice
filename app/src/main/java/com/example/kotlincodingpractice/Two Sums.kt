package com.example.kotlincodingpractice

/*
Problem:
Given an array and a target, return indices of two numbers whose sum equals target.

Input:
nums = [2,7,11,15], target = 9
Output:
[0,1]
 */

fun main() {
    val nums = listOf(2,7,11,15)
    val target = 9
    twoSums(nums, target)
}

fun twoSums(nums: List<Int>, target: Int): List<Int> {
    val map = mutableMapOf<Int, Int>()
    for(i in nums.indices) {
        val diff = target - nums[i]
        if (map.containsKey(diff)) {
            return listOf(map[diff]!!, i)
        }
        map[nums[i]] = i
    }
    return emptyList()
}
