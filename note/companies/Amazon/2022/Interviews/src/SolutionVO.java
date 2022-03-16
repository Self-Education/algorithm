package Interviews.src;

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
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


public class SolutionVO {



    public float evaluate(String s) {
        return -1f;
    }

    public String prettyPrint(String s) {
        Map<Integer, Integer> res = simplify(s);
        System.out.println(res);
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
            // handle pre sign
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
                System.out.println(sub);
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

}
// if(s.charAt(i) == '('){
// Map<Integer, Integer> sub = simplify(s.substring(i + 1));
// for (int key : sub.keySet()) {
// res.put(key, res.getOrDefault(key, 0) + sub.get(key));
// }
// }else if(s.charAt(i) == )
// // handle coefficient
// while(i < m && Character.isDigit(s.charAt(i))){
// num = num * 10 + (int) (s.charAt(i++) - '0');
// }

// if(i == m || s.charAt(i) != 'x'){ // constant
// res.put(0, res.getOrDefault(0, 0) + num * sign);
// continue;
// }

// i++; // skip x

// // check ^
// if(i == m || s.charAt(i) != '^'){ // x
// res.put(1, res.getOrDefault(1, 0) + num);
// continue;
// }

// i++; // skip ^

// while(i < m && Character.isDigit(s.charAt(i))){
// p = p * 10 + (int) (s.charAt(i++) - '0');
// }

// res.put(p, res.getOrDefault(p, 0) + num * sign);
//
