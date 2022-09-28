package Week2.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class TransformTheExpression {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            StringBuilder s = new StringBuilder();
            int numOfExpression = Integer.parseInt(br.readLine());
            while (numOfExpression-- > 0) {
                Stack<Character> stack = new Stack<>();
                char[] token = br.readLine().toCharArray();
                for (int i = 0; i < token.length; i++){

                    if (token[i] >= 'a' && token[i] <= 'z' ) {
                        s.append(token[i]);
                        if ( i == token.length - 1 && !stack.empty() && stack.peek() != '(') s.append(stack.pop());
                        continue;
                    }

                    while (token[i] != '(' && !stack.empty() && (token[i] == ')' || precedence(token[i]) <= precedence(stack.peek()))) {
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        }
                        else s.append(stack.pop());
                    }

                    if (token[i] != ')') stack.push(token[i]);
                    else continue;
                }
                s.append("\n");
            }
            out.print(s);
            out.close();
            br.close();
        }


        static int precedence(char op) {
            switch (op) {
                case '(':
                    return -1;
                case '+' :
                case '-' :
                    return 0;
                case '*':
                case '/':
                    return 1;
                case '^':
                    return 2;
                default:
                    throw new IllegalArgumentException("Operator unknown: " + op);
            }
        }
    }

