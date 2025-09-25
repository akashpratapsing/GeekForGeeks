// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        for (int i = pre_exp.length() - 1; i >= 0; i--){
            char ch = pre_exp.charAt(i);
            
            if ((ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= 0 && ch <= 9)){
                    st.push(ch + "");
                }else {
                    String top1 = st.pop();
                    String top2 = st.pop();
                    st.push("(" + top1 + ch + top2 + ")");
                }
        }
        return st.peek();
        
    }
}
