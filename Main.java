package org.Homework_S6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("Эконом", 4, "HDD", 512, "Linux Ubuntu");
        Laptop laptop2 = new Laptop("Немного лучше", 8, "HDD", 512, "Windows 10");
        Laptop laptop3 = new Laptop("Существенно лучше", 16, "SSD", 1024, "Windows 11");
        Laptop laptop4 = new Laptop("Супер", 32, "SSD", 2048, "Windows 11 Pro");

        Set<Laptop> showcase = new HashSet<Laptop>();
        showcase.add(laptop1);
        showcase.add(laptop2);
        showcase.add(laptop3);
        showcase.add(laptop4);

        // Запрос параметров у пользователя
        Laptop laptopToFind = ParametersInput(showcase);
        Set<Laptop> res = LaptopFilter(showcase, laptopToFind);
        System.out.println(res.isEmpty() ? "Такая модель отсутствует" : res);

    }

    // Выбор действия или параметра
    static Laptop ParametersInput(Set showcase) {
        System.out.println("По каким параметрам выбрать модели? Введите номера параметров через пробел: \n" +
                " 1 - Название модели \n" +
                " 2 - Объём оперативной памяти \n" +
                " 3 - Тип основной памяти \n" +
                " 4 - Объем основной памяти \n" +
                " 5 - Операционная система \n");
        Scanner scan = new Scanner(System.in);
        String field = scan.nextLine();
        Laptop noteToFind = new Laptop();

        if (field.equals("0")) {
            System.out.println(showcase);
        }
        if (field.contains("1")) {
            System.out.println("Укажите название модели");
            noteToFind.setModel(scan.nextLine());
        }
        if (field.contains("2")) {
            System.out.println("Укажите объем оперативной памяти в ГБ");
            noteToFind.setRam(scan.nextInt());
        }
        if (field.contains("3")) {
            System.out.println("Укажите тип основной памяти");
            noteToFind.setMemoryType(scan.nextLine());
        }
        if (field.contains("4")) {
            System.out.println("Укажите объём основной памяти в ГБ");
            noteToFind.setMemory(scan.nextInt());
        }
        if (field.contains("5")) {
            System.out.println("Укажите название операционной системы");
            noteToFind.setOperatingSystem(scan.nextLine());
        }
        scan.close();
        return noteToFind;
    }

    // Создание списка моделей по параметрам
    static Set<Laptop> LaptopFilter(Set<Laptop> showcase, Laptop laptopToFind) {
        Set<Laptop> resultSet = new HashSet<>();
        // Проверяем модель отдельно, потому что если пользователь знает модель, то поиск по остальным параметрам не имеет смысла
        if (!laptopToFind.getModel().equals("Нет данных")) {
            for (Laptop someNote : showcase) {
                if (someNote.getModel().equalsIgnoreCase(laptopToFind.getModel())) {
                    resultSet.add(someNote);
                    break;
                }
            }
        } else {
            for (Laptop someNote : showcase) {
                if (laptopToFind.getRam() == 0
                        || someNote.getRam() >= laptopToFind.getRam()) {
                    if (laptopToFind.getMemoryType().equals("Нет данных")
                            || someNote.getMemoryType().equalsIgnoreCase(laptopToFind.getMemoryType())) {
                        if (laptopToFind.getMemory() == 0
                                || someNote.getMemory() >= laptopToFind.getMemory()) {
                            if (laptopToFind.getOperatingSystem().equals("Нет данных")
                                    || someNote.getOperatingSystem().toLowerCase().contains(laptopToFind.getOperatingSystem().toLowerCase())) {
                                resultSet.add(someNote);
                            }
                        }
                    }
                }
            }
        }
        return resultSet;
    }
}



