package interview.ch07

fun main() {
    val nums = intArrayOf(2, 6, 11, 15)
    val target = 8

    val result = twoSum(nums, target)
    print(nums)
    println()
    print(result)
}

fun print(list: IntArray) {
    for (i in 0 .. list.size - 1) {
        print(list[i].toString() + ",")
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsMap: MutableMap<Int, Int> = mutableMapOf()
    // 하나의 for 반복으로 통합
    for ((i, num) in nums.withIndex()) {
        if(numsMap.containsKey(target - num)) return intArrayOf(numsMap[target - num] ?:0, i)
        // 정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
        numsMap[num] = i
    }
    // 항상 정답이 존재하므로 이 값이 리턴되는 경우는 없음
    return intArrayOf(0, 0)
}