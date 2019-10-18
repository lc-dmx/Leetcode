class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalArea = (C - A) * (D - B) + (G - E) * (H - F);

        if (A >= G || B >= H || C <= E || D <= F) {
            return totalArea;
        }
        int length = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);

        return totalArea - length * height;
    }
}
