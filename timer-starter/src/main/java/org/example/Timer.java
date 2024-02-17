package com.example.demo;
/**
 * 1. Создать аннотацию замера времени исполнения метода (Timer). Она может ставиться над методами или классами.
 * Аннотация работает так: после исполнения метода (метода класса) с такой аннотацией, необходимо в лог записать следующее:
 * className - methodName #(количество секунд выполнения)
 *
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Timer {
}
