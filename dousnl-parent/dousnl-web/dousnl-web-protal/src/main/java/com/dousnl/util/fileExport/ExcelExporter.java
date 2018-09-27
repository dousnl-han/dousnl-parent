package com.dousnl.util.fileExport;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Apache POI
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import com.dousnl.api.domain.User;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 * Created by hl on 16/4/18.
 */
public class ExcelExporter extends GridExporter {

    static  public File exportToFile(JSONObject jsonObject) {
        return exportToFile(jsonObject, Paths.get(DefaultTempPath));
    }
    /**
     * 导出Excel文件到指定目录
     * @param jsonObject Grid信息.将会去其中取出标题(Key为title),
     *        列信息(Key为meta,value为JSONArray.Array内容为String),
     *        各行数据(Key为data,value为JSONArray.Array内容为每行数据,其Key为ColumnName,value为Cell的text).
     * @param dirPath 导出文件的目录.
     */
    static  public File exportToFile(JSONObject jsonObject, Path dirPath)  {

        //Create File
            Workbook wb ;
            String title = jsonObject.get(GridTitle).toString();
            File d = dirPath.toFile();
            d.mkdir();
            Path filePath = Paths.get(dirPath.toString(),title+".xls");

        try {
            wb = new XSSFWorkbook();

            Sheet sheet = wb.createSheet(title);

            JSONArray colArray = jsonObject.getJSONArray(GridColumns);//列标题
            JSONArray dataArray = jsonObject.getJSONArray(GridDatas);//每一列对应的行数据

            CellStyle style = wb.createCellStyle();
            sheet.createRow(dataArray.length()+1);//创建数据+1行
            Row columns = sheet.createRow(0);//创建header标题第一行

                for (int i = 0; i < colArray.length(); i++) {//循环放列标题
                    Cell cell = columns.createCell(i);
                    cell.setCellValue(colArray.getString(i));
                    cell.setCellStyle(style);
                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);

                }

                for (int i = 0; i < dataArray.length(); i++) {//循环数据
                    JSONObject rowData = dataArray.getJSONObject(i);
                    Row row = sheet.createRow(i+1);//创建item数据第一行
                    for (int j = 0; j < colArray.length(); j++) {//循环创建单元格
                        Cell cell = row.createCell(j);
                        cell.setCellValue(rowData.getString(colArray.getString(j)));//单元格数据对应，列的下标
                        cell.setCellStyle(style);
                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                    }

                }

            FileOutputStream outputStream = new FileOutputStream(filePath.toFile());
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath.toFile();


    }

    /**
     * 将Grid信息导出Excel文件到指定目录
     * @param title 文件名,也是文件标题与SheetName.
     * @param colData 列信息，显示在第一行.
     * @param rowDatas 行数据.Key为列信息中的内容.
     * @param dirPath 导出文件的目录.
     */
    static public File exportToFile(String title,ArrayList<String> colData,ArrayList<Map> rowDatas, Path dirPath) {

        Workbook wb ;
        File d = dirPath.toFile();
        d.mkdir();
        Path filePath = Paths.get(dirPath.toString(),title+".xlsx");

        try {
            wb = new XSSFWorkbook();

            Sheet sheet = wb.createSheet(title);
            CellStyle style = wb.createCellStyle();
            sheet.createRow(colData.size()+1);
            Row columns = sheet.createRow(0);
            for (int i = 0; i < colData.size(); i++) {
                Cell cell = columns.createCell(i);
                cell.setCellValue(colData.get(i).toString());
                cell.setCellStyle(style);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            }
            for (int i = 0; i < rowDatas.size(); i++) {
                Map rowMap = rowDatas.get(i);
                    Row row = sheet.createRow(i+1);
                    for (int j = 0; j < colData.size(); j++) {
                        /*
                        Cell cell = row.createCell(j);
                        cell.setCellValue(rowMap.get(colData.get(j).toString()).toString());
                        cell.setCellStyle(style);
                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);*/
                        createCell(rowMap.get(colData.get(j).toString()).toString(),j,row);
                    }

            }

            FileOutputStream outputStream = new FileOutputStream(filePath.toFile());
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
            System.out.println("导出成功！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath.toFile();
    }

    static  private Cell createCell(String text,Integer index,Row atRow) {
        Cell cell = atRow.createCell(index);
        cell.setCellValue(text);
        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
        return cell;
    }
    public static void main(String[] args) {
		String title="execlTest11";
		ArrayList<String> list=new ArrayList<String>();
		list.add("年龄");
		list.add("名称");
		list.add("金额");
		ArrayList<Map> listMap=new ArrayList<Map>();
		ArrayList<User> listUser=new ArrayList<User>();
		User u=new User();
		u.setAge(18);
		u.setName("张三");
		u.setMoney(2018);
		User u1=new User();
		u.setAge(19);
		u.setName("李四");
		u.setMoney(2123);
		User u2=new User();
		u.setAge(20);
		u.setName("王五");
		u.setMoney(201218);
		listUser.add(u);
		listUser.add(u1);
		listUser.add(u2);
		//String[] str1={"asd","qwe","zxc"};
		//String[] str2={"123","345","567"};
		//String[] str3={"wew","wefwe","wef12321"};
		for(int i=0;i<listUser.size();i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put(list.get(0).toString(), listUser.get(i).getAge());
			map.put(list.get(1).toString(), listUser.get(i).getName());
			map.put(list.get(2).toString(), listUser.get(i).getMoney());
			listMap.add(map);
		}
		exportToFile(title,list,listMap,Paths.get("D:\\"));
	}
}
