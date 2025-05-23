package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab5sem2.Image;
import org.knit.solutions.lab5sem2.ImageProxy;

@TaskDescription(taskNumber = 15, taskDescription = "паттерн Прокси (Proxy), Создайте удаленную библиотеку изображений.", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task15 implements Solution {

    @Override
    public void execute() {
        System.out.println("--- Создание прокси для изображения 1 ---");
        Image image1 = new ImageProxy("screenshot_001.jpg");

        System.out.println("\n--- Первое отображение изображения 1 (ожидается загрузка) ---");
        image1.display();

        System.out.println("\n--- Второе отображение изображения 1 (ожидается использование кэша) ---");
        image1.display();

        System.out.println("\n--- Создание прокси для изображения 2 ---");
        Image image2 = new ImageProxy("screenshot_002.png");

        System.out.println("\n--- Первое отображение изображения 2 (ожидается загрузка) ---");
        image2.display();

        System.out.println("\n--- Повторное отображение изображения 1 (все еще кэшировано в своем прокси) ---");
        image1.display();

        System.out.println("\n--- Проверка имени файла через прокси (без загрузки, если еще не было display) ---");
        Image image3 = new ImageProxy("screenshot_003.png");
        System.out.println("Имя файла для image3 (через прокси): " + image3.getFilename());
        System.out.println("Отображение image3 (теперь будет загрузка):");
        image3.display();
    }
}
