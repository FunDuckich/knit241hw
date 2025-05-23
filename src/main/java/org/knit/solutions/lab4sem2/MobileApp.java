package org.knit.solutions.lab4sem2;

public class MobileApp implements StockObserver {
    private final String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("[" + appName + " App] Уведомление: Цена акции '" + stockName + "' теперь " + newPrice);
    }
}
