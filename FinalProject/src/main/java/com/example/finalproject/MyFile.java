package com.example.finalproject;

import javaxt.io.Image;

import java.io.File;
import java.util.HashMap;

public interface MyFile {
    long getSize();
}

class MyImage implements MyFile {
    File file;
    Image image;

    MyImage (File file) {
        this.file = file;
        this.image = new Image(this.file);
    }

    @Override
    public long getSize () {
        long fileSize = file.length();
        return fileSize;
    }

    // return image size in MB as a 2-decimal as a String
    private String getSizeMB () {
        return String.format("%.2fMB",file.length() * 1.0 / 1000000);
    }
    
    // return image property according to property name provided.
    /* This method is created in light of the Factory Design Pattern, hiding the javaxt library from frond-end developer */
    public String getProperties (String name) {
        HashMap<Integer, Object> iptc = image.getIptcTags();
        HashMap<Integer, Object> exif = image.getExifTags();
        if (name.equalsIgnoreCase("date")) {
            if (iptc.containsKey(0x0237)) {
                String date = iptc.get(0x0237).toString();
                return date.substring(0,4) + "." + date.substring(4,6) + "." + date.substring(6);
            } else return "/";
        } else if (name.equalsIgnoreCase("device")) {
            if (exif.containsKey(316)) return exif.get(316).toString();
            else return "Unknown";
        } else if (name.equalsIgnoreCase("width")) return Integer.toString(image.getWidth());
        else if (name.equalsIgnoreCase("height")) return Integer.toString(image.getHeight());
        else if (name.equalsIgnoreCase("size")) return getSizeMB();
        else return "/";
    }
    
    // saving image to desired format and desired directory.
    public void saveAs (String format, String directory) {
        String fileName = file.getName();
        int dot = fileName.indexOf(".");
        String path = directory + "/" + fileName.substring(0,dot) + "." + format;
        image.saveAs(path);
    }

}
