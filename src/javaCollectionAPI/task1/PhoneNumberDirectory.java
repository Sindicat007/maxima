package javaCollectionAPI.task1;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberDirectory {
    private final Map<String, String> phoneBook = new HashMap<>();

    public void addContactToPhoneBook(String name, String numberPhone) {
        if (!name.isEmpty() && !numberPhone.isEmpty()) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            phoneBook.put(name, numberPhone);
            System.out.printf("Контакт с именем: '%s' и номером телефона: '%s' добавлен %n", name, numberPhone);
        } else {
            System.out.println("Поля 'Имя' или 'Номер телефона' не могут быть пустыми\n");
        }
    }

    public String findContact(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        if (phoneBook.isEmpty() || !phoneBook.containsKey(name)) {
            return String.format("Контакта с именем %s нет в справочнике %n", name);
        }
        return String.format("Найден контакт %s %s", name, phoneBook.get(name));
    }

    public String deleteContact(String value) {
        if (value.isEmpty() && phoneBook.isEmpty()) {
            return "Список пользователей пуст либо запрашиваемое значение не задано\n";
        }
        value = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
        if (phoneBook.containsKey(value)) {
            phoneBook.remove(value);
            return String.format("Контакт %s был удален %n", phoneBook.get(value));
        } else if (phoneBook.containsValue(value)) {
            for (Map.Entry<String, String> val : phoneBook.entrySet()) {
                if (val.getValue().equals(value)) {
                    phoneBook.remove(val.getKey());
                    return "Контакт был удален %n";
                }
            }
        }
        return "Номер не найден\n";
    }

    public String getPhoneBook() {
        if (phoneBook.isEmpty()) {
            return "Телефонный справочник пуст\n";
        }
        StringBuilder phoneNumbers;
        phoneNumbers = new StringBuilder();
        for (Map.Entry<String, String> phoneRecord : phoneBook.entrySet()) {
            phoneNumbers
                    .append(phoneRecord.getKey())
                    .append(" - ")
                    .append(phoneRecord.getValue())
                    .append("\n");
        }
        return String.format("Телефонный справочник %n%s", phoneNumbers);
    }
}
