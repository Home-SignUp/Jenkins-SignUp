package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2015
 * {@link http://habrahabr.ru/post/224593/}
 * {@link http://habrahabr.ru/post/213805/}
 * {@link http://winterbe.com/posts/2014/03/16/java-8-tutorial/}
 * {@link http://java.dzone.com/articles/why-we-need-lambda-expressions}
 * {@link http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html}
 * {@link http://info.javarush.ru/translation/2014/06/14/Lambda-выражения-на-примерах.html}
 ******************************************************
 * java 8 lambda
 */
public class Source1 {

    public static void main(String[] args) {
        // Лямбда-выражение представляет собой блок кода, который можно передать в другое место, поэтому он может быть выполнен позже, один или несколько раз.
        // Лямбда-выражения в Java 8 — Простые примеры того, как они могут облегчить вашу жизнь
        // ( http://habrahabr.ru/post/213805/ )
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();
        numbers.forEach((Integer value) -> System.out.print(value + " "));

        System.out.println();
        numbers.forEach(System.out::print);


        System.out.println();
        // Копипаст или абстракции? Выбирать вам!
        System.out.println("-----------------------------");
        System.out.println(sumAll(numbers));
        System.out.println(sumAllEven(numbers));

//        sumAll(numbers, n -> true);
//        sumAll(numbers, n -> n % 2 == 0);
//        sumAll(numbers, n -> n > 3);
    }

    public static int sumAll(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int sumAllEven(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number;
            }
        }
        return total;
    }

    public int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }
}
