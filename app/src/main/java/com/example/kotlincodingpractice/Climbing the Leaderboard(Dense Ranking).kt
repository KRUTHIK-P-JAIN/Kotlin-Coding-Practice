package com.example.kotlincodingpractice

/*
Problem: Climbing the Leaderboard (Dense Ranking)

You are given:
1. ranked: An array of leaderboard scores in descending order.
Duplicate scores mean the players share the same rank.
2. player: An array of Alice's scores in ascending order.

Dense Ranking Rules:
- The highest score gets rank 1.
- Equal scores share the same rank.
- The next distinct score gets the next rank number.

Task:
For each score in player, determine Alice’s rank on the leaderboard.

Constraints:
- ranked size ≤ 200000
- player size ≤ 20000
- Scores are positive integers.

Efficient Approach Required:
Brute force O(n*m) will timeout.
Use O(n + m) two-pointer method.

-----------------------------------
Kotlin Solution (O(n + m) time)
-----------------------------------
 */

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    // Remove duplicates from leaderboard
    val uniqueRanks = ranked.distinct()

    val ranks = IntArray(player.size)
    var index = uniqueRanks.size - 1  // start from lowest rank

    for (i in player.indices) {
        val score = player[i]

        // Move upward as long as player beats or matches leaderboard entry
        while (index >= 0 && score >= uniqueRanks[index]) {
            index--
        }

        // Rank = index + 2 (because index+1 is the position)
        ranks[i] = index + 2
    }

    return ranks.toTypedArray()
}

fun main() {
    val ranked = arrayOf(100, 100, 90, 80, 80, 75, 60)
    val players = arrayOf(50, 65, 77, 90, 102)

    val result = climbingLeaderboard(ranked, players)
    println(result.asList())
}

/*
-----------------------------------
Example
-----------------------------------

ranked = [100, 100, 90, 80, 80, 75, 60]
player = [50, 65, 77, 90, 102]

Output:
[6, 5, 4, 2, 1]

Explanation:
50  → rank 6
65  → rank 5
77  → rank 4
90  → rank 2
102 → rank 1

-----------------------------------
Notes
-----------------------------------
- distinct() gives dense ranking.
- Two-pointer ensures O(n + m) time.
- Works efficiently for maximum constraints.
*/