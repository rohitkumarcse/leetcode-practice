class Solution { 
    public boolean isValidSerialization(String preorder) { 
        Stack<Integer> st = new Stack<>(); 
        String tokens[] = preorder.split(","); 
 
        st.push(1); 
 
        for (int i = 0; i < tokens.length; i++) { 
            String ch = tokens[i]; 
 
            if (st.isEmpty()) return false; 
            
            int slot = st.pop(); 
            slot--; 
            
            if (slot > 0) st.push(slot); 
            
            if (!ch.equals("#")) { 
                st.push(2); 
            } 
        } 
        
        return st.isEmpty(); 
    } 
}