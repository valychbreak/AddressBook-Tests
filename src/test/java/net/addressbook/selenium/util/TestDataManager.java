package net.addressbook.selenium.util;

import java.io.File;


public class TestDataManager {
    public static final int SHEET1 = 0;
    public static final int SEARCH_FIELD_DATA_SHEET = 1;
    public static final int PRINT_ALL_CHECK_DATA_SHEET = 2;
    public static final int ADD_NEW_DATA_SHEET = 3;

    private static File dataFile = null;

    public File getDataFile() {
        if(dataFile == null) {
            dataFile = new File("data.xlsx");
        }

        return dataFile;
    }
}
