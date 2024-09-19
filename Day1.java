// class Solution {
//     public List<Integer> diffWaysToCompute(String expression) {
//         return compute(expression);
//     }

//     private List<Integer> compute(String expression) {
//         List<Integer> results = new ArrayList<>();
//         // Base case: If the expression is a number, convert and return it
//         if (expression.chars().allMatch(Character::isDigit)) {
//             results.add(Integer.parseInt(expression));
//             return results;
//         }

//         // Split the expression on operators and compute results recursively
//         for (int i = 0; i < expression.length(); i++) {
//             char operator = expression.charAt(i);
//             if (operator == '+' || operator == '-' || operator == '*') {
//                 // Split the expression into two parts
//                 String left = expression.substring(0, i);
//                 String right = expression.substring(i + 1);

//                 // Recursively compute results for left and right parts
//                 List<Integer> leftResults = compute(left);
//                 List<Integer> rightResults = compute(right);

//                 // Combine the results based on the operator
//                 for (int leftValue : leftResults) {
//                     for (int rightValue : rightResults) {
//                         int result = 0;
//                         switch (operator) {
//                             case '+':
//                                 result = leftValue + rightValue;
//                                 break;
//                             case '-':
//                                 result = leftValue - rightValue;
//                                 break;
//                             case '*':
//                                 result = leftValue * rightValue;
//                                 break;
//                         }
//                         results.add(result);
//                     }
//                 }
//             }
//         }
//         return results;
//     }
// }//leetcode;