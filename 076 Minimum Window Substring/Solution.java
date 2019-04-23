class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        int sLength = s.length();
        int tLength = t.length();

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tLength; i++) {
            int count = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), count + 1);
        }

        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;

        for (int right = 0; right < sLength; right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }

                while (count == tLength) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    c = s.charAt(left);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                        if (map.get(c) > 0) {
                            count--;
                        }
                    }
                    left++ ;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }
    
//     public String minWindow(String s, String t) {
//         if (s.isEmpty() || t.isEmpty()) {
//             return "";
//         }

//         int sLength = s.length();
//         int tLength = t.length();

//         // Dictionary which keeps a count of all the unique characters in t.
//         Map<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < tLength; i++) {
//             int count = map.getOrDefault(t.charAt(i), 0);
//             map.put(t.charAt(i), count + 1);
//         }

//         // Number of unique characters in t, which need to be present in the desired window.
//         int required = map.size();

//         // formed is used to keep track of how many unique characters in t
//         // are present in the current window in its desired frequency.
//         // e.g. if t is "AABC" then the window must have two A's, one B and one C.
//         // Thus formed would be = 3 when all these conditions are met.
//         int formed = 0;

//         // Left and Right pointer
//         int left = 0;
//         int right = 0;

//         // Dictionary which keeps a count of all the unique characters in the current window.
//         Map<Character, Integer> windowCounts = new HashMap<>();

//         // ans list of the form (window length, left, right)
//         int[] ans = {-1, 0, 0};

//         while (right < sLength) {
//             char c = s.charAt(right);
//             windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

//             // If the frequency of the current character added equals to the
//             // desired count in t then increment the formed count by 1.
//             if (map.containsKey(c) && windowCounts.get(c).intValue() == map.get(c).intValue()) {
//                 formed++;
//             }

//             // Try and contract the window till the point where it ceases to be 'desirable'.
//             while (left <= right && formed == required) {
//                 c = s.charAt(left);

//                 if (ans[0] == -1 || right - left + 1 < ans[0]) {
//                     ans[0] = right - left + 1;
//                     ans[1] = left;
//                     ans[2] = right;
//                 }

//                 // The character at the position pointed by the
//                 // `Left` pointer is no longer a part of the window.
//                 windowCounts.put(c, windowCounts.get(c) - 1);
//                 if (map.containsKey(c) && windowCounts.get(c) < map.get(c)) {
//                     formed--;
//                 }

//                 // Move the left pointer ahead, this would help to look for a new window.
//                 left++;
//             }
//             // Keep expanding the window once we are done contracting.
//             right++;
//         }

//         return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//     }
}
