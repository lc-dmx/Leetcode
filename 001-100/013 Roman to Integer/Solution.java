class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            String str = String.valueOf(s.charAt(i));

            if (i + 1 < len && map.get(str) < map.get(String.valueOf(s.charAt(i + 1)))) {
                str = str + String.valueOf(s.charAt(i + 1));
                i++;
            }
            result = result + map.get(str);
            i++;

        }
        return result;
    }
}
