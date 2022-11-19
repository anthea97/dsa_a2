class Solution38 {
    private static class Ch {
        boolean init;
        int count;
        int max, index;
        Ch[] ch = new Ch[26];

        public Ch() {
            init = false;
            count = 0;
            max = Integer.MIN_VALUE;
            index = -1;
        }

        public Ch[] getCh() {
            if (!init) {
                init = true;
                for (int i = 0; i < 26; i++) {
                    ch[i] = new Ch();
                }
            }
            return ch;
        }

        public void check(int i, int count) {
            if (count > max) {
                max = count;
                index = i;
            }
        }
    }

    public String longestCommonPrefix(String[] strList) {
        Ch head = new Ch();

        for (String str : strList) {
            Ch[] curr = head.getCh();
            Ch prev = head;
            for (Character c : str.toCharArray()) {
                curr[c - 'a'].count += 1;
                prev.check(c - 'a', curr[c - 'a'].count);
                prev = curr[c - 'a'];
                curr = curr[c - 'a'].getCh();
            }
        }

        if (head.max == strList.length) {
            StringBuilder ans = new StringBuilder();
            while (head.max == strList.length) {
                char ch = (char) ('a' + head.index);
                ans.append(ch);
                head = head.getCh()[head.index];
            }
            return ans.toString();
        } else {
            return "";
        }
    }
}

public class Q38 {
    public static void main(String[] args) {
        Solution38 solution = new Solution38();
        String ans = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println("Longest Common Prefix: " + ans);
    }
}
