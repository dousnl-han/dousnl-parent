package org.dousnl.util.fileExport;

import org.apache.poi.xwpf.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by hanliang on 16/4/20.
 */
public class WordExporter extends GridExporter {
    static public File exportToFile(JSONObject gridObject) {
        return exportToFile(gridObject, Paths.get(DefaultTempPath));

    }
    /**
     * 导出Word文件到指定目录
     * @param gridObject Grid信息.将会去其中取出标题(Key为title),
     *        列信息(Key为meta,value为JSONArray.Array内容为String),
     *        各行数据(Key为data,value为JSONArray.Array内容为每行数据,其Key为ColumnName,value为Cell的text).
     * @param dirPath 导出文件的目录.
     */
    static public File exportToFile(JSONObject gridObject, Path dirPath) {
        String title = gridObject.get(GridTitle).toString();
        File d = dirPath.toFile();
        d.mkdir();
        Path filePath = Paths.get(dirPath.toString(), title + ".docx");
        File f = filePath.toFile();
        try {
            f.createNewFile();
            XWPFDocument wordDoc = new XWPFDocument();

            //Add Title
            XWPFParagraph titlePara = wordDoc.createParagraph();
            XWPFRun run = titlePara.createRun();
            run.setFontSize(15);
            run.setTextPosition(20);
            run.setBold(true);
            run.setText(title);
            titlePara.setAlignment(ParagraphAlignment.CENTER);
            //Add Table
            JSONArray colArray = gridObject.getJSONArray(GridColumns);
            JSONArray dataArray = gridObject.getJSONArray(GridDatas);

            XWPFTable gridTable = wordDoc.createTable(dataArray.length() + 1, colArray.length());
            XWPFTableRow colRow = gridTable.getRow(0);
            //Add Columns
            for (int i = 0; i < colArray.length(); i++) {
                colRow.getCell(i).setText(colArray.getString(i));
            }

            //Add Data Rows
            for (int i = 0; i < dataArray.length(); i++) {
                XWPFTableRow dataRow = gridTable.getRow(i + 1);
                JSONObject rowObj = dataArray.getJSONObject(i);
                for (int j = 0; j < colArray.length(); j++) {
                    dataRow.getCell(j).setText(rowObj.getString(colArray.getString(j)));
                }
            }
            wordDoc.write(new FileOutputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return f;
    }

    /**
     * 将Grid信息导出Word文件到指定目录
     * @param title 文件名,也是文件标题与SheetName.
     * @param colData 列信息，显示在第一行.
     * @param rowDatas 行数据.Key为列信息中的内容.
     * @param dirPath 导出文件的目录.
     */
    static public File exportToFile(String title,ArrayList<String> colData,ArrayList<Map> rowDatas, Path dirPath) {
        File d = dirPath.toFile();
        d.mkdir();
        Path filePath = Paths.get(dirPath.toString(), title + ".docx");
        File f = filePath.toFile();
        try {
            f.createNewFile();
            XWPFDocument wordDoc = new XWPFDocument();

            //Add Title
            XWPFParagraph titlePara = wordDoc.createParagraph();
            XWPFRun run = titlePara.createRun();
            run.setFontSize(15);
            run.setTextPosition(20);
            run.setBold(true);
            run.setText(title);
            titlePara.setAlignment(ParagraphAlignment.CENTER);
            //Add Table
            XWPFTable gridTable = wordDoc.createTable(rowDatas.size() + 1, colData.size());
            XWPFTableRow colRow = gridTable.getRow(0);
            //Add Colmun
            for (int i = 0; i < colData.size(); i++) {
                colRow.getCell(i).setText(colData.get(i).toString());
            }
            //Add cell
            for (int i = 0; i < rowDatas.size(); i++) {
                XWPFTableRow dataRow = gridTable.getRow(i + 1);
                Map rowData = rowDatas.get(i);
                for (int j = 0; j < colData.size(); j++) {
                    dataRow.getCell(j).setText(rowData.get(colData.get(j)).toString());
                }
            }
            wordDoc.write(new FileOutputStream(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return f;

    }
}
