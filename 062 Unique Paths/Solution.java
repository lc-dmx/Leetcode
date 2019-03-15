When considering the possible paths (tracing them out with your finger), you might whisper "Up, right, up, right...".

Why not write those thoughts down? Using "u" and "r" we can write out a path:

r r r r r r r u u u u
That is, go all the way right (6 r's), then all the way up (4 u's). The path in the diagram would be:

r r r r u u u u r r
Using the text interpretation, the question becomes "How many ways can we re-arrange the letters rrrrrruuuu?"

Ah, the ubiquitous combination/permutation problem -- never thought it'd be useful, eh?

class Solution {
    public int uniquePaths(int m, int n) {
        if (m < n) {
            int tmp = n;
            n = m;
            m = tmp;
        }

        long numerator = factorial(m + n - 2, m - 1);
        long denominator = factorial(n - 1, 0);

        return (int)(numerator / denominator);
    }

    private long factorial(int start, int end) {
        long result = 1;
        while (start > end) {
            result *= start;
            start--;
        }
        return result;
    }
}
