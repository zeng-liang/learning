def calculate_group_id():
    import sys
    input = sys.stdin.read().split()
    n = int(input[0])
    listPFR = list(map(int, input[1:n+1]))
    
    if n == 0:
        print(0)
        return
    
    right_max = [0] * n
    right_min = [0] * n
    
    # 从右向左初始化最后一个元素
    right_max[-1] = -float('inf')
    right_min[-1] = float('inf')
    
    # 预处理右侧最大和最小值
    for i in range(n-2, -1, -1):
        right_max[i] = max(listPFR[i+1], right_max[i+1])
        right_min[i] = min(listPFR[i+1], right_min[i+1])
    
    total = 0
    for i in range(n):
        current = listPFR[i]
        if current >= right_max[i]:
            total += 15
        elif current < right_max[i] and current < right_min[i]:
            total += 10
        else:
            total += 5
    
    print(total)

calculate_group_id()
