public class StringCompress {

    public void compress(char[] chars) {

        char prev = chars[0];
        int count = 1;
        int j = 0;
        int res = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                builder.append(prev);
                if(count == 1) {
                    builder.append('1');
                }
                res++;
                if (count > 1) {
                    String s = Integer.toString(count);  //do this loop only when count >9
                    for (int k = 0; k < s.length(); k++) {
                        builder.append(s.charAt(k));
                    }
                }
                count = 1;
            }
            prev = chars[i];
        }

        chars[res] = prev;
        builder.append(prev);
        res++;
        if (count == 1) {
            builder.append(1);
        }
        if (count > 1) {
            String s = Integer.toString(count);
            for (int k = 0; k < s.length(); k++) {
                builder.append(s.charAt(k));
            }
        }

        System.out.println(builder.toString());

    }

    public static void main(String args[])
    {
        StringCompress compress = new StringCompress();
        String s = "aaabbbcccaa";
        compress.compress(s.toCharArray());
    }
}

