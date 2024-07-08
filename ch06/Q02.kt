package ch06

fun main() {
    val arr = charArrayOf('r', 'a', 'c', 'e', 'c', 'a', 'r')
    println(arr.joinToString(","))
    println(reverseString(arr).joinToString(","))
}

fun reverseString(s: CharArray): CharArray {
    var start = 0
    var end = s.size - 1
    // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
    while (start<end) {
        s[start] = s[end].also { s[end] = s[start] }

        // 앞쪽 문자는 한칸 뒤로, 뒤쪽 문자는 한칸 앞으로 이동
        start++
        end--
    }
    return s
}

