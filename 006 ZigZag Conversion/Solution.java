if(numRows == 1) return s;
        String result = "";
        int len = 2 * (numRows - 1);
        
        for(int i = 0; i < numRows; i++){
        	int j = 0;
            for( ; j + i < s.length(); ){

                result = result + s.charAt(j + i);
                j = j + len;
                
                if(i != 0 && i != numRows - 1 && j - i < s.length()){
                	
                    result = result + s.charAt(j - i);
                    
                }
            
            }
        }
        return result;
