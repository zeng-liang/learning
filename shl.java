def main():
    import sys
    data = sys.stdin.read().split()
    n = int(data[0])
    pfr = map(int, data[1:n+1])
    
    if n == 0:
        print 0
        return
    
    # 预处理：每个位置 i 后面是否有比它小的数
    has_smaller_after = [False] * n
    min_so_far = pfr[-1]
    for i in xrange(n-2, -1, -1):
        if pfr[i] > min_so_far:
            has_smaller_after[i] = True
        min_so_far = min(min_so_far, pfr[i])
    
    # 预处理：每个位置 i 后面是否有比它大的数
    has_larger_after = [False] * n
    max_so_far = pfr[-1]
    for i in xrange(n-2, -1, -1):
        if pfr[i] < max_so_far:
            has_larger_after[i] = True
        max_so_far = max(max_so_far, pfr[i])
    
    # 预处理：next_greater[i] = i 后面第一个比 pfr[i] 大的位置
    next_greater = [-1] * n
    stack = []
    for i in xrange(n-1, -1, -1):
        while stack and pfr[stack[-1]] <= pfr[i]:
            stack.pop()
        if stack:
            next_greater[i] = stack[-1]
        stack.append(i)
    
    total = 0
    for i in xrange(n):
        if not has_larger_after[i]:
            total += 15
        else:
            j = next_greater[i]
            if j != -1 and has_smaller_after[j]:
                total += 5
            else:
                total += 10
    print total

if __name__ == "__main__":
    main()
