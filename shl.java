import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val list = mutableListOf<Long>()
    repeat(n) {
        list.add(scanner.nextLong())
    }
    scanner.close()

    if (list.isEmpty()) {
        return
    }

    var left = 0
    var right = list.size - 1
    var leftSum = list[left]
    var rightSum = list[right]
    val result = mutableListOf<Long>()

    while (left < right) {
        when {
            leftSum == rightSum -> {
                result.add(leftSum)
                left++
                right--
                if (left <= right) {
                    leftSum = list[left]
                    rightSum = list[right]
                }
            }
            leftSum < rightSum -> {
                left++
                leftSum += list[left]
            }
            else -> {
                right--
                rightSum += list[right]
            }
        }
    }

    // 当左右指针相遇时，将最终合并和加入结果
    if (left == right) {
        result.add(leftSum)
    }

    // 构建最终回文
    val palindrome = result + result.dropLast(1).reversed()
    println(palindrome.joinToString(" "))
}
