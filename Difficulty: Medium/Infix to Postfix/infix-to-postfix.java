class Solution {
    public static String infixToPostfix(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()){
            
            if (Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }else if (ch == '('){
                st.push(ch);
            }else if (ch == ')'){
                while (!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
            }else {
                while (!st.isEmpty() && 
                (
                    (ch != '^' &&  priority(ch) <= priority(st.peek())) ||
                    (ch == '^' && priority(ch) < priority(st.peek()))
                    )){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return String.valueOf(sb);
        
    }
    
    public static int priority(char ch){
        switch(ch){
            
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
                
            case '^':
                return 3;
    
        }
        return -1;
    }
}