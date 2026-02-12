def main():
    import sys
    input = sys.stdin.read().split()
    n = int(input[0])
    pfr = list(map(int, input[1:n+1]))
    
    # 预处理：对每个位置i，记录后面是否有比它小的数
    has_smaller_after = [False] * n
    min_so_far = pfr[-1]
    for i in range(n-2, -1, -1):
        if pfr[i] > min_so_far:
            has_smaller_after[i] = True
        min_so_far = min(min_so_far, pfr[i])
    
    # 预处理：对每个位置i，记录后面是否有比它大的数
    has_larger_after = [False] * n
    max_so_far = pfr[-1]
    for i in range(n-2, -1, -1):
        if pfr[i] < max_so_far:
            has_larger_after[i] = True
        max_so_far = max(max_so_far, pfr[i])
    
    total = 0
    for i in range(n):
        if not has_larger_after[i]:
            total += 15
        else:
            # 找到i后面第一个比它大的数的位置j
            j = i + 1
            while j < n and pfr[j] <= pfr[i]:
                j += 1
            if j < n and has_smaller_after[j]:
                total += 5
            else:
                total += 10
    print(total)

if __name__ == "__main__":
    main()
