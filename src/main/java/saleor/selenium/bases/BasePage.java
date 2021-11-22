package saleor.selenium.bases;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasePage {
    private static final String BASE_URL = "https://demo.saleor.io/";
    //private static final String GEARS_URL = "https://gears-beta.opswat.com/";
    protected String path;
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getUrl() {
        if (this.path.contains("http") || this.path.contains("https"))
            return this.path;
        else
            return BASE_URL.concat(this.path);
    }

    public void goToPage() {
        webDriver.manage().window().maximize();
        this.webDriver.get(getUrl());
    }

    /*Function get data by row and column
    filePath: string - path file
    searchColumn: string - search column
    searchRow: int - row number
    Created by Son Tran Date: 19-09-2020*/
    public String getDataByRowAndColumnValue(String filePath, String searchColumn, int searchRow) throws IOException {
        String recordValue = "";
        String value = "";
        Reader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim());

        //Validate row number
        int countColumns = csvParser.getHeaderNames().size();
        for (int i = 0; i < countColumns; i++) {
            if (searchRow <= 0) {
                System.out.println("Could not find value on row: " + searchRow + " in file: " + filePath);
                break;
            }
            //Validate column name
            if (csvParser.getHeaderNames().get(i).toLowerCase().equals(searchColumn.toLowerCase())) {
                for (CSVRecord csvRecord : csvParser) {
                    recordValue = csvRecord.get(searchColumn);
                    if (searchRow == csvRecord.getRecordNumber()) {
                        value = recordValue;
                    }
                }
            }
        }
        return value;
    }
}
