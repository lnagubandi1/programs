import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int minDeletions(String s) {

        Map<Character, Long> map = s.chars().mapToObj(c->(char)c).
                collect(Collectors.groupingBy(x->x, Collectors.counting())).entrySet().stream().
                sorted(Comparator.comparing(Map.Entry::getValue , Comparator.reverseOrder())).
                collect(Collectors.toMap(entry->entry.getKey(), entry->entry.getValue()));

        Set<Integer> set = new HashSet<>();

        int[] arr = map.values().stream().mapToInt(x-> x.intValue()).toArray();

        AtomicInteger result = new AtomicInteger();



        IntStream.range(0, arr.length).forEach(

                x->
                {
                    while(set.contains(arr[x]) &&  arr[x] >0)
                    {
                        arr[x] = arr[x]-1;
                        result.getAndIncrement();
                    }
                    set.add(arr[x]);
                }

        );

        return result.get();


    }

    public static void main(String args[])
    {
        Solution s = new Solution();
        System.out.println("hi"+s.minDeletions("aaabbbcc"));
    }
}