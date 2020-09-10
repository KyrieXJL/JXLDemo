package com.xjl.excel;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class CreateExcel {
    public static void main(String[] args) throws IOException, WriteException {
        //1.创建excel文件
        File file = new File("Info.xls");
        if (!file.exists()) file.createNewFile();
        //2.创建工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(file);
        //3.设置sheet
        WritableSheet sheet = workbook.createSheet("用户管理", 0);
        //4.设置单元格
        String[] titles = {"编号", "账号", "密码"};
        //5.单元格
        Label label = null;
        //6.给第一行设置列名
        for (int i = 0; i < titles.length; i++) {
            //x,y第一行的列名
            label = new Label(i, 0, titles[i]);
            //添加单元格
            sheet.addCell(label);
        }
        //8.模拟数据
        for (int i = 1; i < 10; i++) {
            //添加编号
            label = new Label(0, i, i + "");
            sheet.addCell(label);
            //添加账号
            label = new Label(1, i, "15666515190" + i);
            sheet.addCell(label);
            //添加密码
            label = new Label(2, i, "123456" + i);
            sheet.addCell(label);
        }
        //9.写入数据
        workbook.write();
        //10.关闭数据，释放资源
        workbook.close();


    }
}
