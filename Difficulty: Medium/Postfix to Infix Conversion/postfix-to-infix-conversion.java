// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        for (char ch : exp.toCharArray()){
            
            if ((ch >= 'A' && ch <= 'Z')|| 
                (ch >= 'a' && ch <= 'z') || 
                (ch >=0 && ch <= 9)){
                    st.push(ch + "");
                }else {
                    String top1 = st.pop();
                    String top2 = st.pop();
                    st.push("(" + top2 + ch + top1 + ")");
                }
        }
        return st.peek();
    }
}
