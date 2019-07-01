class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return results;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        int length = digits.length();

        combine(0, length, "", digits, map, results);

        return results;
    }

    private void combine(int start, int end, String str, String digits,
                         Map<Character, String> map, List<String> results) {
        if (start == end) {
            results.add(str);
            return;
        }

        char digit = digits.charAt(start);
        for (char c : map.get(digit).toCharArray()) {
            combine(start + 1, end, str + c, digits, map, results);
        }

    }
}
