package HomeWork12.Phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private final List<Record> records;

    public PhoneDictionary() {
        this.records = new ArrayList<>();
    }

    public void addRecord(Record record){
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if(record.getName().equals(name)){
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equals(name)){
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? null : foundRecords;
    }

}
