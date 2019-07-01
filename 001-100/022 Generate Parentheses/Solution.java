class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, n, n, "");
        return result;
    }

    private void generate(List<String> result, int open, int close, String str) {
        if (open == 0 && close == 0) {
            result.add(str);
            return;
        }

        if (open > 0) {
            generate(result, open - 1, close, str + '(');
        }

        if (open < close) {
            generate(result, open, close - 1, str + ')');
        }

    }
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         generate(n, n, "", result);
//         return result;
//     }
    
//     public void generate(int left, int right, String output, List<String> result){
//         if (left > right || left < 0 || right < 0) return;
//         if(left == 0 && right == 0){
//             result.add(output);
//             return;
//         }
        
//         generate(left - 1, right, output + "(", result);
//         generate(left, right - 1, output + ")", result);
//     }
}
