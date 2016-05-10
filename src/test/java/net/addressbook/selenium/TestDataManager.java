package net.addressbook.selenium;

import java.io.File;

/**
 * Created by Valeriy on 10/5/2016.
 */
public class TestDataManager {
    public static final int SHEET1 = 0;
    public static final int SEARCH_FIELD_DATA_SHEET = 1;

    static File dataFile = null;

    public File getDataFile() {
        if(dataFile == null) {
            dataFile = new File("data.xlsx");
        }

        return dataFile;
    }
}
