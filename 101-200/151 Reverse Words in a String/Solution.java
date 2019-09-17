class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = strs.length - 1; i >= 0; i--) {
            if(!strs[i].equals("")) {
                if(sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(strs[i]);
            }
        }
        return sb.toString();
        
    }
}
