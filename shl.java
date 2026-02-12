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
        if (leftSum == rightSum) {
            result.add(leftSum)
            left++
            right--
            if (left <= right) {
                leftSum = list[left]
                rightSum = list[right]
            }
        } else if (leftSum < rightSum) {
            left++
            leftSum += list[left]
        } else {
            right--
            rightSum += list[right]
        }
    }

    if (left == right) {
        result.add(list[left])
    }

    val palindrome = result + result.dropLast(1).reversed()
    println(palindrome.joinToString(" "))
}
