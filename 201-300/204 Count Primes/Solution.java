class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                result++;
            }
        }
        return result;
    }
}


      //素数打表
//    private int[] primeTable(int n) {
//        // prime[]存储了小于n的素数,下标从1开始
//        // 估计 x/ln(x)，n越大误差越小
//        int len = (int)(1.5 * n / Math.log(n));
//        int[] prime = new int[len];
//        // visit[]数组标记了是否为素数，bool类型
//        boolean[] visit = new boolean[n + 1];
//        // 初始化为true
//        for (int i = 0; i < visit.length; i++) {
//            visit[i] = true;
//        }
//
//        int num = 0;
//        for (int i = 2; i <= n; i++) {
//            if (visit[i]) {
//                num++;
//                prime[num] = i;
//            }
//
//            //对所有不超过i的最小素因子的素数p，将i*p标记为合数
//            for (int j = 1; (j <= num) && (i * prime[j] <= n); j++) {
//                visit[i * prime[j]] = false;
//                if (i % prime[j] == 0) break;
//            }
//        }
//        return prime;
//    }
