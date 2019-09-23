package Task_3;

import java.util.HashMap;

class TelephoneDirectory {
    static String txtAdd = "Контакта добавлен, логин: ";
    static String txtGet = "Данные контакта: ";
    static HashMap<String, String> hmm = new HashMap<>();


    static String add(String name, String phone){
        String sName = name;
        int i = 0;
        while (hmm.containsKey(sName)) sName = name + i++;
        hmm.put(sName, phone);
        return sName;
    }
    static String get(String name){
        return (hmm.get(name) != null) ?  name + " | " +hmm.get(name) : "Пользователя: " + name + " нет в вашем списке контактов";
    }
}
