package HomeWork13;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> fileMap;


    public FileNavigator() {
        fileMap = new HashMap<>();
    }

    public void add(FileData fileData) {
        String path = fileData.getPath();
        List<FileData> fileList = fileMap.getOrDefault(path, new ArrayList<>());
        fileList.add(fileData);
        fileMap.put(path, fileList);
    }

    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            for (FileData fileData : fileList) {
                if (fileData.getSize() <= maxSize) {
                    result.add(fileData);
                }
            }
        }
        return result;
    }

    public void remove(String path){
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            allFiles.addAll(fileList);
        }
        allFiles.sort(Comparator.comparingLong(FileData::getSize));
        return allFiles;
    }

    public void addConsistencyCheck(FileData fileData) {
        String path = fileData.getPath();
        List<FileData> fileList = fileMap.getOrDefault(path, new ArrayList<>());
        boolean isConsistent = fileList.isEmpty()
                || fileList.get(0).getPath().equals(path);
        if (!isConsistent) {
            System.out.println("Inconsistent file data: " + fileData.getName());
            System.out.println("Path mismatch: Expected: " + fileList.get(0).getPath());
        } else {
            fileList.add(fileData);
            fileMap.put(path, fileList);
        }
    }

}
