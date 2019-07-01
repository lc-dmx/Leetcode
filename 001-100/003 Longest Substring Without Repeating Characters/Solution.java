//method 1
class Solution{
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] chars = new boolean[256]; // 256 ASCII code
        int rst = 0;
        int start = 0;
        int end = 0;
        while (start < s.length()) {
            while (end < s.length() && !chars[s.charAt(end)]) {
                chars[s.charAt(end)] = true;
                rst = Math.max(rst, end - start + 1);
                end++;
            }
            chars[s.charAt(start)] = false;
            start++;
        }
        return rst;
    }
}

//method 2
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
