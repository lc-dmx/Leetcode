解法一：先把words存在一个map中，key是单词字符串，value是出现的次数。
然后逐个位置遍历字符串s（注意遍历结束位置不必到最后，剩余长度小于单词总长度即停止），判断其后面的和档次总长度相同的子串中的每个单词是否和words一样。
如果一样，这push_back进去；否则，遍历下一个字符。
时间复杂度：O(LNw)，L是s的长度，N是words的个数，w是word的长度。

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int number = words.length;

        if (number == 0) {
            return result;
        }
        int strLength = s.length();
        int wordLength = words[0].length();

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i <= strLength - wordLength * number; i++) {
            count.clear();
            boolean flag = true;
            for (int j = i; j < i + wordLength * number; j += wordLength) {
                String substr = s.substring(j, j + wordLength);
                if (!wordMap.containsKey(substr)) {
                    flag = false;
                    break;
                } else {
                    if (count.containsKey(substr)) {
                        count.put(substr, count.get(substr) + 1);
                    } else {
                        count.put(substr, 1);
                    }
                }
            }

            if (flag && wordMap.equals(count)) {
                result.add(i);
            }

        }
        return result;
    }

}


解法二：因为words中的单词可能有重复，所以要有一个dict来记录一下每个字符串的数目。
然后在遍历原字符串的时候，只需要遍历单词的长度次即可，如"barfoothefoobarman"，因为目标单词的长度为3，所以只需遍历：
'bar' | 'foo' | 'the' | 'foo' | 'bar' | 'man'
'arf' | 'oot' | 'hef' | 'oob' | 'arm'
'rfo' | 'oth' | 'efo' | 'oba' | 'rma'

在遍历时，需要两个指针，一个用来标记子字符串的开始，另一个用来标记子字符串的结束。
再用一个dict来记录当前字符串中单词的数量，如果下一个单词不在words中，那么清空该dict，把前指针直接跳到后指针处；
如果在words中，那么相应的键值要加一，此时如果那个单词的数量超过了目标中的数目，那么前指针要不断后移直到吐出一个那个单词。
通过前后指针之差是否等于所有目标单词长度之和来判断是否有目标子字符串。

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int len = words.length;
        
        if(len == 0){
            return res;
        }
    
        int len0 = words[0].length();
        int totalLen = len * len0;
        
        if(s.length() < totalLen){
        	return res;
        }
        
        //put given dictionary into HashMap with each word's count
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String word : words){
        	if(!dict.containsKey(word)){
        		dict.put(word, 1);
        	}else{
        		dict.put(word, dict.get(word) + 1);
        	}
        }
        
        for(int i = 0; i < len0; i++){
        	int count = 0;
        	int index = i;
        	
        	HashMap<String, Integer> curdict = new HashMap<String, Integer>();
        	for(int j = i; j <= s.length() - len0; j += len0){
        		
        		String curWord = s.substring(j,	j + len0);
        		
        		if(!dict.containsKey(curWord)){
        			curdict.clear();
        			count = 0;
        			index = j + len0;
        		}else{
        			if(!curdict.containsKey(curWord)){
        				curdict.put(curWord, 1);
        			}else{
        				curdict.put(curWord, curdict.get(curWord) + 1);
        			}
        			
        			if(curdict.get(curWord) <= dict.get(curWord)){
        				count++;
        			}else{
        				while(curdict.get(curWord) > dict.get(curWord)){
        					String temp = s.substring(index, index + len0);
        					if(curdict.containsKey(temp)){
            					curdict.put(temp, curdict.get(temp) - 1);
            					if(curdict.get(temp) < dict.get(temp)){
            						count --;
            					}
        					}
        					index = index + len0;
        				}
        			}
        			
        			if(count == len){
        				res.add(index);
        				String temp = s.substring(index, index + len0);
        				curdict.put(temp, curdict.get(temp) - 1);
        				index = index + len0;
        				count --;
        			}
        		}
        	}
        }
        return res;
    }
}
