package com.test.algorithm;


import java.util.*;

public class MyTest {

   private static Map<String, Integer> operators = new TreeMap<>();

   private static final String LEFT_BRACKET = "(";
   private static final String RIGHT_BRACKET = ")";

   static {
      //operators.put('(', 1);
      operators.put("+", 2);
      operators.put("-", 3);
      operators.put("*", 4);
      operators.put("/", 5);
      //operators.put(')', 6);
   }

   private static boolean isDigit(String c) {
      return Character.isDigit(c.charAt(0));
   }

   private static boolean isOperator(String c) {
      return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
   }

   private static boolean isLeftBracket(String c) {
      return LEFT_BRACKET.equals(c);
   }

   private static boolean isRightBracket(String c) {
      return RIGHT_BRACKET.equals(c);
   }

   public static String[] convert(String expresionStr) {
      String[] tokens = expresionStr.split("");
      List<String> reversePolishNotion = new ArrayList<>();
      Stack<String> operatorStack = new Stack<>();
      for (int i = 0; i < tokens.length; i++) {
         String token = tokens[i];
         //左括号入符号栈
         if (isLeftBracket(token)) {
            operatorStack.push(token);
         } else if (isDigit(token)) {
            //数字直接入输出列表
            reversePolishNotion.add(token);
         } else if (isRightBracket(token)) {
            //遇右括号时连续出栈，直到遇到左括号
            while (!operatorStack.isEmpty()
               && !isLeftBracket(operatorStack.peek())
               && isOperator(operatorStack.peek())) {
               reversePolishNotion.add(operatorStack.pop());
            }
            //最后将左括号弹出符号栈
            operatorStack.pop();
         } else if (isOperator(token)) {
            //遇到操作符，连续出栈，直到所有高优先级的全部出完
            while (!operatorStack.isEmpty()
               && isOperator(operatorStack.peek())
               && operators.get(token) < operators.get(operatorStack.peek())
               && !isLeftBracket(operatorStack.peek())) {
               reversePolishNotion.add(operatorStack.pop());
            }
            //当前操作符进栈
            operatorStack.push(token);
         }
      }
      //处理完成后，将操作栈中剩余符号弹出到输出队列
      while (!operatorStack.isEmpty()) {
         reversePolishNotion.add(operatorStack.pop());
      }
      System.out.println("origin:" + expresionStr);
      System.out.println(reversePolishNotion);
      return reversePolishNotion.toArray(new String[0]);
   }


   public static int evalRPN(String[] tokens) {
      Stack<String> stack = new Stack<>();
      for (int i = 0; i < tokens.length; i++) {
         if (operators.containsKey(tokens[i])) {
            String t2 = stack.pop();
            String t1 = stack.pop();
            String v = calculate(tokens[i], t1, t2);
            stack.push(v);
         } else {
            stack.push(tokens[i]);
         }
      }
      return Integer.parseInt(stack.pop());
   }

   private static String calculate(String token, String t1, String t2) {
      if (token.equals("+")) {
         return String.valueOf(Integer.parseInt(t1) + Integer.parseInt(t2));
      }
      if (token.equals("-")) {
         return String.valueOf(Integer.parseInt(t1) - Integer.parseInt(t2));
      }
      if (token.equals("*")) {
         return String.valueOf(Integer.parseInt(t1) * Integer.parseInt(t2));
      }
      if (token.equals("/")) {
         return String.valueOf(Integer.parseInt(t1) / Integer.parseInt(t2));
      }
      return null;
   }

   public static void main(String[] args) {

      String[] exp1 = convert("(3+8)*2");
      String[] t1 = Arrays.stream(exp1).toArray(String[]::new);
      System.out.println(evalRPN(t1));
      String[] exp2 = convert("(3+4)*5-2*(3+9)");
      String[] t2 = Arrays.stream(exp2).toArray(String[]::new);
      System.out.println(evalRPN(t2));

      String[] exp3 = convert("((3+4)*5-2)-(3+9)*3+2-1");
      String[] t3 = Arrays.stream(exp3).toArray(String[]::new);
      System.out.println(evalRPN(t3));

      //(3+8)*2
      //String[] sa = new String[]{"1", "2", "+", "3", "4", "+", "*"};
      //System.out.println(evalRPN(sa));
   }
}
