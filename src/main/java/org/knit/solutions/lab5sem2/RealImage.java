package org.knit.solutions.lab5sem2;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Загрузка изображения '" + filename + "' с удаленного сервера...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ошибка во время имитации загрузки: " + e.getMessage());
        }
        System.out.println("Изображение '" + filename + "' успешно загружено.");
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения: " + filename);
    }

    @Override
    public String getFilename() {
        return filename;
    }
}
