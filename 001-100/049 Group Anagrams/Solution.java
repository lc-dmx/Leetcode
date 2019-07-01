class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;
        for (String str: strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tmp = String.valueOf(temp);

            if (map.containsKey(tmp)) {
                result.get(map.get(tmp)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                map.put(tmp, count++);
                list.add(str);
                result.add(list);
            }
        }
        return result;
    }
}
