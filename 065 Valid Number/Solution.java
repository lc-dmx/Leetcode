class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }

        if (s.length() == 1) {
            return Character.isDigit(s.charAt(0));
        }

        boolean e = false;
        boolean decimal = false;
        for (int i = 0 ; i < s.length() - 1 ; i++) {
            char c = s.charAt(i);
            char next = s.charAt(i + 1);
            if (Character.isDigit(c)) {
                if (!Character.isDigit(next) && next != '.' && next != 'e') {
                    return false;
                }
            } else if(c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
                if (!Character.isDigit(next) && next != '.') {
                    return false;
                }
            } else if (c == 'e') {
                if (e || i == 0) {
                    return false;
                }
                e = true;
                decimal = true;
                if (!Character.isDigit(next) && next != '+' && next != '-') {
                    return false;
                }
            } else if (c == '.') {
                if (decimal) {
                    return false;
                }
                decimal = true;
                if (i == 0 || !Character.isDigit(s.charAt(i - 1))) {
                    if (!Character.isDigit(next)) {
                        return false;
                    }
                } else {
                    if (!Character.isDigit(next) && next != 'e') {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        char last = s.charAt(s.length() - 1);
        if (Character.isDigit(last)) {
            return true;
        } else if (last == '.' && !decimal && Character.isDigit(s.charAt(s.length() - 2))) {
            return true;
        } else {
            return false;
        }
    }
}
