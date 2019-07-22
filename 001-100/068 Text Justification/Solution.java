1. 首先要能判断多少个word组成一行：
这里统计读入的所有words的总长curLen，并需要计算空格的长度。假如已经读入words[0:i]。当curLen + i <=L 且加curLen + 1 + word[i+1].size() > L时，一行结束。

2. 知道一行的所有n个words，以及总长curLen之后要决定空格分配：
平均空格数：k = (L - curLen) / (n-1)
前m组每组有空格数k+1：m = (L - curLen) % (n-1)

例子：L = 21，curLen = 14，n = 4
k = (21 - 14) / (4-1) = 2
m = (21 - 14) % (4-1)  = 1
A---B--C--D

3. 特殊情况：
(a) 最后一行：当读入到第i = words.size()-1 个word时为最后一行。该行k = 1，m = 0
(b) 一行只有一个word：此时n-1 = 0，计算(L - curLen)/(n-1)会出错。该行k = L-curLen, m = 0
(c) 当word[i].size() == L时。

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = 0;

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }

        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");

        return padResult(result.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}
