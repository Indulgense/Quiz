package Calculator;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args) throws CalcException {
        Scanner console = new Scanner(System.in);
        String[] x = (console.nextLine()).split(" ");
        if (x.length != 3) {
            throw new CalcException();
        }
        String one = x[0];
        String sign = x[1];
        String two = x[2];
        transformation(one,sign,two);
    }
    private static void transformation (String one, String sign, String two) throws CalcException {
        if (Roman.isRoman(one) && Roman.isRoman(two)) {
            roman(one, sign, two);
        } else {
            arabian(one, sign, two);
        }
    }

    private static void roman(String a, String b, String c) throws CalcException {
        int roman1 = Roman.getArabian(a);
        int roman2 = Roman.getArabian(c);
        switch (b) {
            case "+":
                int e = roman1 + roman2;
                System.out.println(Roman.getRoman(e));
                break;
            case "-":
                int r = roman1 - roman2;
                if (r >= 1) {
                    System.out.println(Roman.getRoman(r));
                } else {
                    throw new CalcException();
                }
                break;
            case "*":
                int y = roman1 * roman2;
                System.out.println(Roman.getRoman(y));
                break;
            case "/":
                int t = roman1 / roman2;
                if (t >= 1) {
                    System.out.println(Roman.getRoman(t));
                } else {
                    throw new CalcException();
                }
                break;
        }
    }

    private static void arabian(String x, String y, String z) throws CalcException {
        try {
            int first = Integer.parseInt(x);
            int second = Integer.parseInt(z);
            if (first > 0 && first <= 10 && second > 0 && second <= 10) {
                switch (y) {
                    case "+":
                        System.out.println(first + second);
                        break;
                    case "-":
                        System.out.println(first - second);
                        break;
                    case "*":
                        System.out.println(first * second);
                        break;
                    case "/":
                        System.out.println(first / second);
                        break;
                }
            } else {
                throw new CalcException();
            }
        } catch (NumberFormatException e) {
            System.out.println("throws Exception");
        }
    }

}

