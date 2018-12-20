class Solution {
    public String longestCommonPrefix(String[] strs) {        
        String result = "";
        
        if(strs == null || strs.length == 0){
        	return result;
        }

        for(int i = 0; i < strs[0].length(); i++){
        	int j = 1;
        	while(j < strs.length){
        		if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
        			return result;
            	}else{
            		j++;
            	}
        	}
        	if(j == strs.length){
        		result = result + strs[0].charAt(i);
        	}
        }
        return result;
    }
}
