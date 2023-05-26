package HomeWork13;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        //adding files
        fileNavigator.add(new FileData("files.txt", 1000, "/path/to/file"));
        fileNavigator.add(new FileData("firstApp.txt", 2000, "/path/to/file"));
        fileNavigator.add(new FileData("anotherFile.txt", 1500, "/another/path/to/file"));
        fileNavigator.add(new FileData("image.png", 3000, "/path/to/file"));

        //Finding files by path
        List<FileData> filesAtPath = fileNavigator.find("/path/to/file");
        System.out.println("Files at /path/to/file:");
        for (FileData file : filesAtPath) {
            System.out.println("Name: " + file.getName() + ", Size: " + file.getSize());
        }

        //Filtering files by size
        long maxSize = 2000;
        List<FileData> filteredFiles = fileNavigator.filterBySize(maxSize);
        System.out.println("File with size <= " + maxSize + ":");
        for (FileData file : filteredFiles) {
            System.out.println("Name: " + file.getName() + ", Size: " + file.getSize());
        }

        //Deleting a path and associated files
        fileNavigator.remove("/path/to/file");
        System.out.println("Files after removing /path/to/file:");
        filesAtPath = fileNavigator.find("/path/to/file");
        for (FileData file : filesAtPath) {
            System.out.println("Name: " + file.getName() + ", Size:");
        }

        //Sorting files by size
        List<FileData> sorterFiles = fileNavigator.sortBySize();
        System.out.println("Sorted files by size: ");
        for (FileData file : sorterFiles) {
            System.out.println("Name: " + file.getName() + ", Size:" + file.getSize());
        }

        //Consistency check when adding a file with an incorrect path
        FileData inconsistentFile = new FileData("inconsistent.txt", 500, "/another/path");
        fileNavigator.addConsistencyCheck(inconsistentFile);

    }
}
