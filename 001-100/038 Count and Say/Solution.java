class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(count);
                result.append(str.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }
}
