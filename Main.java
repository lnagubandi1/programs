import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Main {

       public int countBishopMoves(int rows, int cols)
       {
           return Math.min(cols-1,rows-1)+Math.min(cols-1, 8-rows)+Math.min(8-cols,rows-1)+Math.min(8-cols,8-rows);
       }

        public static void main(String[] args) {

           int count =0;

           Main m = new Main();
           count = m.countBishopMoves(1,1);//given initial bishop position



           List<Integer> list = Arrays.asList(1,2,3,4);
           int sum = list.stream().filter(i->i%2 == 0).mapToInt(e->e).max().orElseThrow();

//            System.out.println(sum);





         //  elist.stream().filter(e->(e.firstName).startsWith("A")).forEach(e->System.out.println(e.firstName));

//            List<Employee> esorted = elist.stream()
//                    .sorted(Comparator.comparing(Employee::getAge)).

//                List<Employee> list1 = elist.stream().sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getAge, Comparator.reverseOrder()))
//                    .collect(Collectors.toList());

                //in case of same name they are furtner sorted by their age.

//            list1.stream().forEach(e->System.out.println(e.firstName));

            Random r = new Random();
//            r.ints(0,9).limit(10).forEach(e-> System.out.println(e));



            //min no.

//            List<Integer> min = Arrays.asList(100,7,1,2,3,4,1,2);
//            Integer i = min.stream().min(Comparator.comparing(Integer::valueOf)).get();
////            System.out.println(i);

            List<String> ss = Arrays.asList("Hi","Hello","Alekhya","sddd");
            ss.stream().filter(e-> e.length()>3).count();

            //removing duplicates elements from alist

            List<Integer> min = Arrays.asList(100,90,1,2,3,4);

            min.stream().collect(Collectors.toSet()).stream().sorted(Comparator.comparing(Integer::valueOf,Comparator.reverseOrder()));

            String input = "Hello";
             Map<Object, Long> map = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));

             //find first non repeating character

           Character cc = input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting())).entrySet().stream().filter(e->e.getValue() == 1).findFirst().
                   map(entry->entry.getKey()).get();

           System.out.println(cc);

           //find frst repeating character

            String s1 = "hhaiii";

          Character c2=  s1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(e->e,Collectors.counting())).entrySet().stream().
                  filter(entry->entry.getValue()>1).findFirst().map(ee->ee.getKey()).get();

          System.out.println(c2);

          Random r1 = new Random();
          r1.ints(5,1,11).sorted().forEach(e->System.out.println(e));

          List<Integer> list2 = Arrays.asList(1,2,3,4,5,101);

          Integer  i=list2.stream().mapToInt(e->e).max().getAsInt();
          System.out.println(i);


          //find duplicate elements:
           List<Integer> list3 = Arrays.asList(2,3,4,6,2,34,5,34,35);
           List<Integer> list4 = list3.stream().collect(Collectors.groupingBy(e->e, Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(e->e.getKey()).sorted().collect(Collectors.toList());
           System.out.println(list4);


           //prime no.
            int n = 21;
            boolean bool =IntStream.range(2,n/2).noneMatch(x->n%x == 0);

            boolean isPrime = IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0);
            System.out.println(isPrime);

            //armstrong no.
            int z = 153;
            int len = Integer.toString(z).length();
            System.out.println(len);
            int finalLen1 = len;
            int sum2 = Integer.toString(z).chars().map(c->Character.digit(c,10)).map(x-> (int)Math.pow(x, finalLen1)).sum();
            System.out.println(sum2);

            int a[] = { 1, 4, 5, 2, 12, 34, 2, 11 };
            Arrays.stream(a).forEach(System.out::println);

            //palindrome
            String s11 = "bbaab";

            int len1 = s11.length();
            boolean isPalindrome = IntStream.range(0,n/2).allMatch(index->s11.charAt(index) == s11.charAt(len1 - index - 1));
            System.out.println(isPalindrome);

            //second highest no. in arr

            int[] arr = {1,2,3,4};

            int res = Arrays.stream(arr).boxed().sorted(Comparator.comparing(Integer::valueOf, Comparator.reverseOrder())).skip(1).findFirst().get();
            System.out.println(res);

            //program to sort two arrays in ascending order
            int[] arr1 = {1,2,5,4,7,8};
            int[] arr2 ={5,7,8,2,3,6};

            Stream.concat(Arrays.stream(arr1).boxed(),Arrays.stream(arr2).boxed()).distinct().sorted().forEach(System.out::println);

           int j = Arrays.stream(arr1).sum();
           System.out.println(j);

           //Write a program to append char in char ex-input- {A, B, C} output->[A_X, B_Y, C_Z].

            Stream<Character> chars = Stream.of('A','B','C');
            chars.forEach(c->
            {   char x;
                x = (char) (c + 23);
                System.out.println(c+"_"+x);

            });

            Stream<Character> charStream = Stream.of('A', 'B', 'C');
            charStream.forEach(ch -> {
                char newChar = (char) (ch + 23);
                System.out.println(ch + "_" + newChar);
            });

            //find out all the nos starting with 1

            List<Integer> list5 = Arrays.asList(1,2,11,11,7,17);
            List<Integer> list6 = list5.stream().map(Object::toString).filter(x->x.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(list6);


            int[] nums = {1, 2, 3, 4, 5, 2}; // Example array

            boolean hasDuplicates = Arrays.stream(nums)
                    .boxed() // Convert int to Integer
                    .collect(Collectors.toSet()) // Create a set to remove duplicates
                    .size() < nums.length;

            System.out.println(hasDuplicates);

            List<Integer> list8= null;
          //  List<List<Integer>> list9 = Optional.ofNullable(list8).orElse().stream().collect(Collectors.toList());

            String s = "rat";
           String yy = s.chars().sorted().mapToObj(c->(char)c).map(Object::toString).collect(Collectors.joining());
           //or   s.chars().sorted().mapToObj(c->(char)c).map(c->Character.toString(c)).collect(Collectors.joining());

           System.out.println(yy);

           //sum of all digits of a no.

            int n1 = 123;
            int sum_n1 = String.valueOf(123).chars().map(c->Character.digit(c,10)).sum();
            System.out.println(sum_n1);


            //reverse the following string

            String s2 = "Hello Hi How are You";
            String[] s_arr = s2.split("\\s+");
            String ss_ans = Arrays.stream(s_arr).reduce((x,y)->y+ " "+  x).get();
            System.out.println(ss_ans);

            // reverse each word of a string
            String ss1_ans = Arrays.stream(s_arr).map(s3->new StringBuilder(s3).reverse().toString()+" ").collect(Collectors.joining());
            System.out.println(ss1_ans);

            //reverse integer

            int z1 = 123;

            String sz1 = String.valueOf(z1);
            String sz1_ans = sz1.chars().map(c->(char)c).mapToObj(c1->Character.toString(c1)).reduce((c,d)->(d+c)).get();
            System.out.println(Integer.valueOf(sz1_ans));

            //palindrome
            String pali = "aabaa";
            int p = pali.length();

            boolean b = IntStream.range(0,p/2).allMatch(index -> pali.charAt(index) == pali.charAt(p-index-1));
            System.out.println(b);

            String[] strs = {"flower","ow","flight"};

            //longest common prefix
           String result_lcp = Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length)).
                   reduce((lcp1,lcp2)->
                   {
                       int lcp_min = Math.min(lcp2.length(),lcp1.length());
                       int i_lcp=0;
                       while (i_lcp<lcp_min && lcp1.charAt(i_lcp) == lcp2.charAt(i_lcp))
                       {
                           i_lcp++;
                       }

                       return lcp1.substring(0,i_lcp);

                   }).get();

           System.out.println("h"+result_lcp);

            List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

            decimalList.stream().sorted(Comparator.comparing((Double::valueOf), Comparator.reverseOrder())).collect(Collectors.toList());

            min = Arrays.asList(100,90,1,2,3,4);
            int reduce_res= min.stream().reduce((d,e)->{

                if(d>e)
                {
                    return d;
                }
                else
                {
                    return e;
                }


        }).get();

            System.out.println(reduce_res);

            int[] a1 = new int[] {4, 2, 5, 1};

            int[] b1 = new int[] {8, 1, 9, 5};

            int[] c = IntStream.concat(Arrays.stream(a1), Arrays.stream(b1)).distinct().sorted().toArray();

            System.out.println(Arrays.toString(c));

            String s22="alekhya";

             s22 =  s22.chars().mapToObj(x->String.valueOf((char)x)).sorted().collect(Collectors.joining());
             System.out.println(s22);

            List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

            List<String> listOfStrings_sorted =  listOfStrings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());

            System.out.println(listOfStrings_sorted);

            //reverse an integer array
            int[] array = new int[] {5, 1, 7, 3, 9, 6};

            int array_length = array.length;

            int[] array_result = IntStream.range(0,array_length).map(ii-> array[array_length-1-ii]).toArray();
           Arrays.stream(array_result).forEach(System.out::println);


            List<String> listOfStrings1 = Arrays.asList("Pen", "Eraser", "Note Book", "Pencil", "Pen", "Note Book", "Pencil");
           List<String> output = listOfStrings1.stream().collect(Collectors.groupingBy(x->x, Collectors.counting())).entrySet().stream().
                    max(Comparator.comparing(Map.Entry::getValue)).map(e->e.getKey()).stream().collect(Collectors.toList());

           System.out.println(output);

            String inputString = "Java Concept Of The Day";
           inputString=  inputString.replaceAll("\\s+","").toLowerCase();
          List<Character> list_chars =  inputString.chars().mapToObj(c3c->(char)c3c).collect(Collectors.groupingBy(cccc->cccc, Collectors.counting())).entrySet()
                   .stream().filter(entry->entry.getValue() > 1).map(entry->entry.getKey()).collect(Collectors.toList());

          System.out.println(list_chars);

            String[] strsw = {"eat","tea","tan","ate","nat","bat"};

           Map<String, List<String>> mapp=  Arrays.stream(strsw).collect(Collectors.groupingBy(str->
            {
                String strr;
                strr = str.chars().mapToObj(c1c->String.valueOf((char)c1c)).sorted().collect(Collectors.joining());
                return strr;

            }, Collectors.toList()));

           List<List<String>> list7 = mapp.entrySet().stream().
                   map(entry-> entry.getValue()).collect(Collectors.toList());
           System.out.println(list7);














































        }












}



