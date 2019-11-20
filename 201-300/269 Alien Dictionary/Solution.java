    public String alienOrder(String[] words) {
        HashSet<Character> set = new HashSet<>();
        Map<Character, Set<Character>> map = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }

        int[] inDegree = new int[26];
        for (int i = 0; i < words.length - 1; i++) {
            int preLen = words[i].length();
            int nexLen = words[i + 1].length();
            for (int j = 0; j < Math.min(preLen, nexLen); j++) {
                char prev = words[i].charAt(j);
                char next = words[i + 1].charAt(j);
                if (prev != next) {
                    if (!map.containsKey(prev)) {
                        map.put(prev, new HashSet<>());
                    }

                    if (!map.get(prev).contains(next)) {
                        inDegree[next - 'a']++;
                    }

                    map.get(prev).add(next);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && set.contains((char)('a' + i))) {
                queue.offer((char)('a' + i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);

            if (map.containsKey(ch)) {
                for (char c : map.get(ch)) {
                    inDegree[c - 'a']--;
                    if (inDegree[c - 'a'] == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
        return sb.length() == set.size() ? sb.toString() : "";
    }
