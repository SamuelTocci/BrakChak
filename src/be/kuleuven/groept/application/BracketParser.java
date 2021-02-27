package be.kuleuven.groept.application;

import be.kuleuven.groept.util.Stack;
import be.kuleuven.groept.util.StackIntf;

public class BracketParser implements BracketParserIntf {
    @Override
    public boolean checkBrackets(String text) {
        StackIntf<Character> stack = new Stack<>();

        for (char ch: text.toCharArray()){
            if (ch == '(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
                switch(ch){
                    case ')': if(stack.peek() == null){return false;} if(stack.peek().charValue() == '(' ){stack.pop();} else{return false;} break;
                    case '}': if(stack.peek() == null){return false;} if(stack.peek().charValue() == '{' ){stack.pop();} else{return false;} break;
                    case ']': if(stack.peek() == null){return false;} if(stack.peek().charValue() == '[' ){stack.pop();} else{return false;} break;
                    default: break;
                }
        }
        return stack.isEmpty();
    }

}
