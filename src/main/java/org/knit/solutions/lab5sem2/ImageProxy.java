package org.knit.solutions.lab5sem2;

public class ImageProxy implements Image {
    private final String filename;
    private RealImage realImage;

    public ImageProxy(String filename) {
        this.filename = filename;
        this.realImage = null;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("ImageProxy: Запрос на отображение '" + filename + "'. Реальный объект еще не загружен.");
            realImage = new RealImage(filename);
        } else {
            System.out.println("ImageProxy: Запрос на отображение '" + filename + "'. Используется кэшированный реальный объект.");
        }
        realImage.display();
    }

    @Override
    public String getFilename() {
        return filename;
    }
}
