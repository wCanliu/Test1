package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Application {

    public static void main(String[] args) {
        String pageUrl = "http://10.122.7.154/javaweb/data/images-url.txt";
        String directory = "C:\\images";
        PageReader pageReader = new PageReader();
        List<String> imageUrls = pageReader.getImageUrls(pageUrl);
        List<ImageReader> imageReaders = new ArrayList<>();

        for (String imageUrl : imageUrls) {
            ImageReader imageReader = new ImageReader();
            imageReader.download(imageUrl, directory);
            imageReaders.add(imageReader);
        }

        // 按大小排序
        imageReaders.sort(Comparator.comparingInt(ImageReader::getSize));

        // 将排序结果写入文件
        ImageReader.writeSortedImages(imageReaders, directory + "\\images-sorted.txt");
    }
}
