package com.example.exercise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GenericMethods {
    public static void main (String[] args) {

        // testing count method
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(7);
        arrayList.add(9);
        arrayList.add(45);
        arrayList.add(97);
        Condition<Integer> oddNumber = (Integer a) -> {return a % 2 != 0;};
        int oddNumberCount = countIf(arrayList,oddNumber);
        System.out.println(oddNumberCount); //expected to be 4

        // testing exchangePosition method
        Integer[] a = {1,2,3,4,5};
        a = exchangePosition(1,3, a);
        // expected a = [1,4,3,2,5]
        System.out.println(Arrays.toString(a));
        Character[] chars = {'e','w','a','d','z','.'};
        chars = exchangePosition(2,4,chars);
        // expected chars = ['e','w','z','d','a','.']
        System.out.println(Arrays.toString(chars));
        
        //testing find maximum method
        List<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(10);
        list.add(24);
        list.add(35);
        Integer max = findMax(0,4, list);
        System.out.println(max); //expected: 56
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('z');
        characters.add('n');
        Character c = findMax(0,3, characters);
        System.out.println(c); //expected: z
    }

    // Write a generic method to count the number of elements in a collection
    // that have a specific property (for example, odd integers, prime numbers, palindromes).
    public static <T> int countIf (Collection<T> collection, Condition<T> condition) {
        int count = 0;
        for (T element : collection) {
            if (condition.test(element)) count++;
        }
        return count;
    }
    interface Condition<T>{
        boolean test(T object);
    }

    // Write a generic method to exchange the positions of tow different elements in an array
    // assumes a and b are both >= 0 and < array.length
    public static <T> T[] exchangePosition (int a, int b, T[] array) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }

//  Write a generic method to find the maximal element in the range [begin, end) of a list.
//  assumes begin is bigger than 0 and end is less than list length
    public static <E extends Comparable<E>> E findMax (int begin, int end, List<E> list) {
        E max = list.get(begin);
        for (int i = begin; i < end; i++) {
            if (list.get(i).compareTo(max) > 0) max = list.get(i);
        }
        return max;
    }
}


