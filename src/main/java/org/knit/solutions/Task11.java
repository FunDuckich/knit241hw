package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab4sem2.EmailNotifier;
import org.knit.solutions.lab4sem2.MobileApp;
import org.knit.solutions.lab4sem2.Stock;
import org.knit.solutions.lab4sem2.StockObserver;

@TaskDescription(taskNumber = 11, taskDescription = "Паттерн Observer (Наблюдатель), Реализация системы уведомлений в биржевом приложении", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task11 implements Solution {
    @Override
    public void execute() {
        Stock teslaStock = new Stock("Tesla", 150.00);
        Stock googleStock = new Stock("Google", 2800.00);
        Stock appleStock = new Stock("Apple", 170.00);

        StockObserver mobileApp1 = new MobileApp("НереалФон");
        StockObserver mobileApp2 = new MobileApp("ФуПланшет");
        StockObserver emailNotifier1 = new EmailNotifier("petrovegor495@gmail.com");
        StockObserver emailNotifier2 = new EmailNotifier("llllllll@gmail.com");

        teslaStock.registerObserver(mobileApp1);
        teslaStock.registerObserver(emailNotifier1);

        googleStock.registerObserver(mobileApp1);
        googleStock.registerObserver(mobileApp2);
        googleStock.registerObserver(emailNotifier2);

        appleStock.registerObserver(emailNotifier1);

        System.out.println("\n--- Первое изменение цен ---");
        teslaStock.setPrice(155.50);
        googleStock.setPrice(2820.75);
        appleStock.setPrice(172.00);

        System.out.println("\n--- Отписка mobileApp1 от Tesla ---");
        teslaStock.removeObserver(mobileApp1);

        System.out.println("\n--- Второе изменение цен ---");
        teslaStock.setPrice(152.00);
        googleStock.setPrice(2805.00);
        appleStock.setPrice(169.50);

        System.out.println("\n--- petrovegor495@gmail.com отписывается от всех ---");
        teslaStock.removeObserver(emailNotifier1);
        googleStock.removeObserver(emailNotifier1);
        appleStock.removeObserver(emailNotifier1);

        System.out.println("\n--- Третье изменение цен ---");
        teslaStock.setPrice(160.00);
        googleStock.setPrice(2830.00);
        appleStock.setPrice(175.00);
    }
}
