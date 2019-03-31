class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dist = new int[len2 + 1][len1 + 1];
        dist[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dist[0][i] = i;
        }

        for (int i = 1; i <= len2; i++) {
            dist[i][0] = i;
        }

        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                int tmp = word1.charAt(j - 1) == word2.charAt(i - 1) ? 0 : 1;
                dist[i][j] = Math.min(dist[i][j - 1] + 1, Math.min(dist[i - 1][j] + 1, dist[i - 1][j - 1] + tmp));
            }
        }

        return dist[len2][len1];
    }
}
