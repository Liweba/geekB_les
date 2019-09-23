package Task_3;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
 * из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
 *
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
 * делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main(), прописывая add() и get().
 * */
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


