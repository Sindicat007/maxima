package javaCollectionAPI.task1;

import java.util.HashMap;
import java.util.Map;

public class ContactStorage {
    private final Map<String, String> nameToPhone = new HashMap<>();

    public void addContactToPhoneBook(String name, String numberPhone) {
        if (name.isEmpty() && numberPhone.isEmpty()) {
            System.out.println("Поля 'Имя' или 'Номер телефона' не могут быть пустыми\n");
            return;
        }
        name = formatName(name);
        nameToPhone.put(name, numberPhone);
        System.out.printf("Контакт с именем: '%s' и номером телефона: '%s' добавлен %n", name, numberPhone);

    }

    public String findContact(String name) {
        name = formatName(name);
        if (nameToPhone.isEmpty() || !nameToPhone.containsKey(name)) {
            return String.format("Контакта с именем %s нет в справочнике %n", name);
        }
        return String.format("Найден контакт %s - %s %n", name, nameToPhone.get(name));
    }

    public String deleteContact(String value) {
        value = formatName(value);
        if (value.isEmpty() && nameToPhone.isEmpty()) {
            return "Список пользователей пуст либо запрашиваемое значение не задано\n";
        }
        if (nameToPhone.containsKey(value)) {
            value = formatName(value);
            nameToPhone.remove(value);
            return String.format("Контакт был удален %n");
        } else if (nameToPhone.containsValue(value)) {
            for (Map.Entry<String, String> val : nameToPhone.entrySet()) {
                if (val.getValue().equals(value)) {
                    nameToPhone.remove(val.getKey());
                    return "Контакт был удален \n";
                }
            }
        }
        return "Номер не найден\n";
    }

    public void getPhoneBook() {
        if (nameToPhone.isEmpty()) {
            System.out.println("Телефонный справочник пуст\n");
            return;
        }
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> phoneRecord : nameToPhone.entrySet()) {
            System.out.printf("%s - %s %n", phoneRecord.getKey(), phoneRecord.getValue());
        }
    }

    public static String formatName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
