class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add(0);
            for (int j = i; j >= 1; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
