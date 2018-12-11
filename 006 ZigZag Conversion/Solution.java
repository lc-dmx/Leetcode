class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        int len = s.length();
        int span = 2 * (numRows - 1);
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            int j = 0;
            for (; i + j < len; ) {
                result.append(s.charAt(i + j));
                j = j + span;
                if (i != 0 && i != numRows - 1 && j - i < len) {
                    result.append(s.charAt(j - i)); 
                }
            }
        }
        return result.toString();
    }
}
