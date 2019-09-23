package Task_3;

import java.lang.reflect.Array;
import java.util.*;


public class Main extends TelephoneDirectory{
    public static void main(String[] args) {

        System.out.println("\n=== Добавление контакта ==="); //add(*,*) Добавить контакт
        System.out.println(txtAdd+add("Ivan","89999999999"));
        System.out.println(txtAdd+add("Ivan","88888888888"));
        System.out.println(txtAdd+add("Ivan","87777777777"));
        System.out.println(txtAdd+add("Ivan","86666666666"));
        System.out.println(txtAdd+add("Ivan","85555555555"));
        System.out.println(txtAdd+add("Vasya","84444444444"));
        System.out.println(txtAdd+add("Maxim","83333333333"));

        System.out.println("\n=== Получение контакта ==="); //get(*) Получить данные контакта
        System.out.println(txtGet+get("Ivan"));
        System.out.println(txtGet+get("Ivan35"));
        System.out.println(txtGet+get("Maxim"));

        System.out.println("\n=== Телефонная книга ===\nlogin | phone");
        for (Map.Entry<String, String> o: new TreeMap<>(hmm).entrySet()) {
            System.out.println(o.getKey() + " | " + o.getValue());
        }
        List<String> arr = new ArrayList<>(Arrays.asList("Дом", "Машина", "Стул", "Кот", "Мышка", "Пол", "Дом", "Пол", "Пол", "Мяч", "Дом", "Ослик", "Медуза", "Удав", "Кот"));
        List<String> arr2 = new ArrayList<>(Arrays.asList("Артём", "Иван", "Артём", "Java", "Java"));

        countingDuplicate(arr,arr2);
    }


    private static void countingDuplicate(List<String>... arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nМассив №" + (i+1));
            if (arr[i].size() == 0) {
                System.out.println("Пустой");
                continue;
            }
            System.out.println(new HashSet<>(arr[i]));

            HashMap<String, Integer> hm = new HashMap<>();
            for (String name: arr[i]) {
                if(!hm.containsKey(name))hm.put(name, 0);
                if(hm.containsKey(name))hm.put(name, hm.get(name) +1);
            }
            System.out.println(hm);
        }

    }
}


