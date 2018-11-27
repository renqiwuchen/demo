package com.example.demo.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {

    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";


    public static void main(String[] args) throws Exception {
        List<Model> list = new ArrayList<Model>();
       /* File excelFile = new File("e:/e.xlsx"); // 创建文件对象
        FileInputStream in = new FileInputStream(excelFile); // 文件流
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in); //构造一个XSSFWorkbook对象*/


        Workbook wb = readExcel("e:/bb.xlsx");
        Sheet sheet = wb.getSheetAt(0);
        int rownum = sheet.getPhysicalNumberOfRows();

        for(int i=0;i<rownum;i++){
            Row row = sheet.getRow(i);
            String a  = row.getCell(0).toString();
            String b  = row.getCell(1).toString();
            BufferedWriter bw = new BufferedWriter(new FileWriter("e:\\excel2\\\\MYOS-"+b+ i+".html"));
            bw.write(a);//在创建好的文件中写入"Hello I/O"
            bw.close();//一定要关闭文件
        }

    }

    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }




}
