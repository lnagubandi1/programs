import java.util.*;

public class Logs {

    public static void main(String args[])
    {
        String arr[] = {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
                "10.0.0.3 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"};


        Map<String, Integer> cnt = new TreeMap<>();
        int max_occur = 0;

        for (String req : arr) {
            String ip = req.trim().split(" ")[0];
            // System.out.println("curr ip is " + ip);

            if (!cnt.containsKey(ip)) {
                cnt.put(ip, 0);
            }
            cnt.put(ip, cnt.get(ip) + 1);

            if (max_occur < cnt.get(ip)) {
                max_occur = cnt.get(ip);
            }
        }

        for (String ip : cnt.keySet()) {
            if (cnt.get(ip) == max_occur) {
                System.out.println(ip);
            }
        }

    }
    }



