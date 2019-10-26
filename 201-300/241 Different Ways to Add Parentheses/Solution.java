class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == '+' || temp == '-' || temp == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        switch (temp) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        map.put(input, result);
        return result;
    }
}
