package org.knit.solutions.lab4sem2;

public class EmailNotifier implements StockObserver {
    private final String userEmail;

    public EmailNotifier(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("[Email для " + userEmail + "] Уведомление: Цена акции '" + stockName + "' теперь " + newPrice);
    }
}
