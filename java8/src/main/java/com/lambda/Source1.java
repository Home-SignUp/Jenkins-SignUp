package com.lambda;

import java.util.Arrays;
import java.util.List;

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
        // Лямбда-выражения в Java 8 — Простые примеры того, как они могут облегчить вашу жизнь
        // ( http://habrahabr.ru/post/213805/ )
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int number : numbers) {
            System.out.println(number);
        }

        numbers.forEach((Integer value) -> System.out.println(value));
    }

}
