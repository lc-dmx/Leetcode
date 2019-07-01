class Solution {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty() || s == null) {
            return 0;
        }

        String[] words = s.split(" ");
        return words.length - 1 >= 0 ? words[words.length - 1].length() : 0;
    }
}



class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length() - 1; 
        int i=0;
        
        while((n-i) >= 0 && s.charAt(n-i) != ' '){
            i++;
            
        }
        return i;
    }
}
