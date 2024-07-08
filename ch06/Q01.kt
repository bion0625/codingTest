package ch06

fun main() {
    val s = "Do geese see God?"
    println(s + " => " + isPalindrom(s))
}

fun isPalindrom(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    // 서로 중앙으로 이동해나가다 겹치는 부분에서 종료
    while (start < end) {
        when {
            // 영숫자인지 판별하고 유효하지 않으면 뒤로 한 칸 이동
            !s[start].isLetterOrDigit() -> start++
            // 영숫자인지 판별하고 유효하지 않으면 앞으로 한 칸 이동
            !s[end].isLetterOrDigit() -> end--
            else -> {
                // 이 외에는 유효한 문자이므로 앞뒤 글자를 모두 소문자로 변경하여 비교
                // 하나라도 일치하지 않는다면 팰린드롬이 아니므로 false 리턴
                if (s[start].lowercaseChar() != s[end].lowercaseChar()) return false
                // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한칸 앞으로 이동
                start++
                end--
            }
        }
    }
    // 무사히 종료될 경우 펠린드롬이므로 true 리턴
    return true
}