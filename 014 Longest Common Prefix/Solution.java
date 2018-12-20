class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";    
        }
        
        String result = "";

        int len = strs.length;
        int minWordLen = strs[0].length();
        int minWordPos = 0;
        for (int i = 1; i < len; i++) {
            if (strs[i].length() < minWordLen) {
                minWordLen = strs[i].length();
                minWordPos = i;
            }
        }

        int j = 0;
        while (j < minWordLen) {
            int i = 0;
            while (i < len) {
                if (strs[minWordPos].charAt(j) == strs[i].charAt(j)) {
                    i++;
                } else {
                    return result;
                }
            }
            if (i == len) {
                j++;
                result = strs[minWordPos].substring(0, j);
            }
        }


        return result;
    }
}
