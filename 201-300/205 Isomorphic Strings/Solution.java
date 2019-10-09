# Solution 1
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] si = s.toCharArray();
        char[] ti = t.toCharArray();
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[si[i]] != m2[ti[i]]) return false;
            m1[si[i]] = i + 1;
            m2[ti[i]] = i + 1;
        }
        return true;
    }
}

# Solution 2
class Solution {
    public boolean isIsomorphic(String s, String t) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (!map.containsKey(temp)) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(temp, t.charAt(i));
            }
            sb.append(map.get(temp));
        }
        return sb.toString().equals(t);
    }
}
