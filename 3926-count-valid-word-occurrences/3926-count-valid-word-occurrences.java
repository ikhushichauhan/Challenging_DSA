class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {

        String k = String.join("", chunks);
        HashMap<String, Integer>map = new HashMap<>();
        
        int n = k.length();
        int i = 0;

        while(i < n){
            StringBuilder word = new StringBuilder();
            
        while(i < n){
                
            char c = k.charAt(i);
            if(c >= 'a' && c <= 'z'){
                word.append(c);
            }
            else if(c == '-'){
                
                if(word.length()>0 &&
                   i + 1 < n &&
                   k.charAt(i + 1) >= 'a' &&
                   k.charAt(i + 1) <= 'z'){
                    word.append(c);                    
            }
            else{
                break;
            }
            
        }
        else{
            break;
        }
            i++;

    }
        String w  = word.toString();
            if(w.length() > 0 && w.charAt(w.length()-1)=='-'){
        w = w.substring(0, w.length()-1);
    }
            if (!w.isEmpty()) {
            map.put(w, map.getOrDefault(w, 0) +1);
    }
        i++;
    }
        int [] ans = new int[queries.length];
        
        for (i = 0; i < queries.length; i++){
        ans[i] = map.getOrDefault(queries[i],0);
    }
        return ans;
        }
    }
