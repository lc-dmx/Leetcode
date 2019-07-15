class Solution {
    public List<String> restoreIpAddresses(String s) {
        /**
         * 1.ip地址是四个部分，即需要将字符串切割成四部分;
         * 2.需要对每一部分进行分类讨论，即每部分是1位、2位或者是3位，且要对每一部分的合法性进行验证，故
         *   可以将问题分解成四个相同的小部分，然后用递归实现；
         * 3.在每一次的递归中，由于需要分类讨论，所以还需要一层for循环。
         */
        List<String> result = new ArrayList<>();
        dfs(0, s, result, "");
        return result;
    }

    private void dfs(int n, String s, List<String> result, String temp){
        /**
         * n:递归层数
         * s:切割后剩余字符串
         * result:存储所有合法ip地址的变量
         * temp:存储当前合法的ip地址的变量
         */
        if (n == 4) {
            if (s.isEmpty()) {
                result.add(temp);
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (s.length() < i) {
                    break;
                }
                int val = Integer.valueOf(s.substring(0, i));
                //切割出来 01 的时候应判断不合法
                if (i == String.valueOf(val).length() && val <= 255) {
                    dfs(n + 1, s.substring(i), result, temp + String.valueOf(val) + (n == 3 ? "" : "." ));
                }

            }
        }
    }
}
