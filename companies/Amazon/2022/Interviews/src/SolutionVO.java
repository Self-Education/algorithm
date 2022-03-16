import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import customClass.Expression;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class SolutionVO {

    /*
     * evaluate expression (polynomial)
     */
    public int evaluate(String s, int x) {
        Map<Integer, Integer> res = simplify(s);
        int sum = 0;
        for (int key : res.keySet()) {
            sum += Math.pow(x, key) * res.get(key);
        }
        return sum;
    }

    public String prettyPrint(String s) {
        Map<Integer, Integer> res = simplify(s);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int power : res.keySet()) {
            int coef = res.get(power);
            if (coef > 0 && count != 0)
                sb.append("+");
            if (coef != 1) {
                if (coef == -1) {
                    sb.append("-");
                } else {
                    sb.append(coef);
                }
            }

            if (power >= 1) {
                sb.append("x");
            }

            if (power > 1) {
                sb.append("^");
                sb.append(power);
            }
            count++;
        }

        return sb.toString();
    }

    public Map<Integer, Integer> simplify(String s) {
        Queue<Character> queue = new LinkedList<>();
        s += '#';
        for (char c : s.toCharArray())
            queue.offer(c);
        return expressionEvaluatorIHelper(queue);
    }

    public Map<Integer, Integer> expressionEvaluatorIHelper(Queue<Character> queue) {
        Map<Integer, Integer> res = new TreeMap<>((a, b) -> b - a);
        Queue<Integer> coef = new LinkedList<>();
        Queue<Integer> power = new LinkedList<>();
        int num = 0, sign = 1;
        boolean hasPower = false;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            } else if (c == 'x') {// coefficient ends
                coef.offer(num * sign);
                num = 0;
                sign = 1;
            } else if (c == '^') {
                hasPower = true;
            } else if (c == '(') {
                Map<Integer, Integer> sub = expressionEvaluatorIHelper(queue);
                for (int key : sub.keySet())
                    res.put(key, res.getOrDefault(key, 0) + sub.get(key) * sign);
            } else { // +, -, #, )
                if (hasPower) {
                    power.offer(num);
                } else if (coef.size() > power.size()) {// x
                    power.offer(1);
                } else if (coef.size() == power.size()) {// no power -> constant
                    coef.offer(num * sign);
                    power.offer(0);
                }
                num = 0;
                sign = c == '+' ? 1 : -1;
                hasPower = false;
                if (c == ')')
                    break;
            }
        }

        while (!coef.isEmpty() && !power.isEmpty()) {
            res.put(power.peek(), res.getOrDefault(power.poll(), 0) + coef.poll());
        }
        return res;
    }

    /*
     * form word from cards
     */
    public boolean formWordFromCards(char[][] cards, String word) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int m = cards.length;
        for (int i = 0; i < m; i++) {
            char[] card = cards[i];
            map.computeIfAbsent(card[0], x -> new HashSet<>()).add(i);
            map.computeIfAbsent(card[1], x -> new HashSet<>()).add(i);
        }
        return formWordFromCardsHelper(map, visited, word, 0);
    }

    private boolean formWordFromCardsHelper(Map<Character, Set<Integer>> map, Set<Integer> visited, String word,
            int index) {
        if (index == word.length())
            return true;

        if (map.containsKey(word.charAt(index))) {
            Set<Integer> options = map.get(word.charAt(index));
            for (int i : options) {
                if (!visited.contains(i)) {
                    visited.add(i);
                    if (formWordFromCardsHelper(map, visited, word, index + 1))
                        return true;
                    visited.remove(i);
                }
            }
        }
        return false;
    }

    /* Evaluate expression II */

    public int evaluateExpressionII(Expression input) {
        if (input.isInteger()) {
            return input.getVal();
        }
        // it is a pair
        String operator = input.getKey();
        if (input.isBase()) {
            return evaluateExpressionIIHelper(operator, input.getIntArray());
        } else {
            Expression[] values = input.getValues();
            int[] baseValues = new int[values.length];
            System.out.println(Arrays.toString(baseValues));
            for (int i = 0; i < values.length; i++) {
                baseValues[i] = evaluateExpressionII(values[i]);
            }
            return evaluateExpressionIIHelper(operator, baseValues);
        }
    }

    private int evaluateExpressionIIHelper(String operator, int[] values) {
        int sum = 0;
        if (operator.equals("+")) {
            sum = 0;
            for (int v : values)
                sum += v;
        } else if (operator.equals("-")) {
            sum = values[0];
            for (int i = 1; i < values.length; i++) {
                sum -= values[i];
            }
        } else if (operator.equals("*")) {
            sum = 1;
            for (int v : values)
                sum *= v;
        }
        return sum;
    }
}
