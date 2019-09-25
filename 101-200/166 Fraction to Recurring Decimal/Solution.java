class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean sign = false;
        if ((long)numerator * denominator < 0 ) {
            sign = true;
        }
        long num1 = Math.abs((long)numerator);
        long num2 = Math.abs((long)denominator);

        long intPart = num1 / num2;
        long reminder = num1 % num2;

        String result = String.valueOf(intPart);
        result = sign ? "-" + result : result;

        if (reminder == 0) return result;

        result += ".";
        String s = "";
        int pos = 0;
        Map<Long, Integer> map = new HashMap<>();

        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                s = s.substring(0, map.get(reminder)) + "(" + s.substring(map.get(reminder)) + ")";
                break;
            }

            map.put(reminder, pos);
            s += String.valueOf(reminder * 10 / num2);
            reminder = reminder * 10 % num2;
            pos++;
        }

        return result + s;
    }
}
