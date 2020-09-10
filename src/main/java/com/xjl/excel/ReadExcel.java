package com.xjl.excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(new File("Info.xls"));
        Sheet sheet = workbook.getSheet(0);
        //获取行数据
        int rows = sheet.getRows();
        //获取列数据
        int columns = sheet.getColumns();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = sheet.getCell(j, i);
                String contents = cell.getContents();
                System.out.println(contents);
            }
        }
        workbook.close();
    }
}
