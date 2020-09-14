package kwai;

import javax.print.attribute.standard.PrinterResolution;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 对于Set，List，Array，HashMap之类的每次操作完成都需要更新状态；i++，push，pop之类的；
public class LongestSubString {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(Solution(str));
    }

    public static int Solution(String str) {
        HashSet<Character> set = new HashSet<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                queue.add(str.charAt(i));
                set.add(str.charAt(i));
            } else {
                res = Math.max(res,set.size());
                while (set.contains(str.charAt(i))) {
                    set.remove(queue.poll());
                }
                queue.add(str.charAt(i));
            }
        }
        res = Math.max(res,set.size());
        return res;
    }
}
