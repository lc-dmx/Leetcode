# Solution 1
space O(n)
time O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] temp = new char[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

# Solution 2
space O(nlogn)
time O(1)

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sTemp = s.toCharArray();
        char[] tTemp = t.toCharArray();
        Arrays.sort(sTemp);
        Arrays.sort(tTemp);
        return Arrays.equals(sTemp, tTemp);
    }
}
