      import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws IOException {
        // 使用 BufferedReader 读取输入，处理大数据量更高效
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 读取列表大小
        int size = Integer.parseInt(br.readLine());
        
        // 读取列表元素
        String[] parts = br.readLine().split(" ");
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(parts[i]);
        }
        
        // 对列表进行升序排序
        Arrays.sort(list);
        
        // 输出交替元素（索引为 0, 2, 4...）
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i += 2) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(list[i]);
        }
        System.out.println(sb.toString());
    }
}
