package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> dictionary = new HashMap<>();

        dictionary.put("красивый", new String[]{"прекрасный", "чудесный",
                "велеколепный", "симпотичный"});
        dictionary.put("дом", new String[] {"квартира", "жилище",
                "аппартаменты", "хижина"});
        dictionary.put("человек", new String[] {"личность", "персона",
                "хомосапиенс","индивидум"});
        HashMap<String, String[]> bigDictionary = new HashMap<>(dictionary);

        Set<String> stringSet = dictionary.keySet();
        Iterator<String> iter = stringSet.iterator();


        while (iter.hasNext()) {
            try {
                String key = iter.next();
                String[] arr = bigDictionary.get(key);
                bigDictionary.put(key, arr);

                for (String str : arr) {
                    ArrayList<String> arrayList = new ArrayList<>(arr.length);
                    arrayList.addAll(Arrays.asList(arr));
                    arrayList.add(key);
                    arrayList.remove(str);
                    String[] arr2 = new String[arrayList.size()];
                    arr2 = arrayList.toArray(arr2);
                    bigDictionary.put(str, arr2);
                    //System.out.println(str + " - " + Arrays.toString(arr2));
                }
            } catch (Exception ex) {
            }
        }

        System.out.println("Введите слово:");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] word = sentence.split(" ");
        for (int i = 0; i < word.length; i++) {
            if (bigDictionary.get(word[i]) == null) {
                System.out.println("Данное слово не найдено");
            } else {
                String[] synonyms = bigDictionary.get(word[i]);
                Random random = new Random();
                int randomIndex = random.nextInt(synonyms.length);
                System.out.println(synonyms[randomIndex] + " ");
            }
            System.out.println("Введите слово или фразу:");
            Scanner scan = new Scanner(System.in);
            String phrase = sc.nextLine();
            String[] words = phrase.split(" ");
            for (String wordd: words) {
            String[] synonyms = dictionary.get(wordd);
            Random r = new Random();
            if (synonyms != null) {
                System.out.printf(synonyms[r.nextInt(synonyms.length)] + " ");
            }  else {
                System.out.println("Такого слово в словаре нет");
            }
        }




    }}}