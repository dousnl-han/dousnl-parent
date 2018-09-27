package com.dousnl.util.fileExport;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanliang on 16/4/18.
 */
public class PDFExporter extends GridExporter {

    static public File exportToFile(JSONObject gridObject) {
        //Default Dir tmp
        return exportToFile(gridObject, Paths.get(DefaultTempPath));
    }
    /**
     * 导出PDF文件到指定目录
     * @param gridObject Grid信息.将会去其中取出标题(Key为title),
     *        列信息(Key为meta,value为JSONArray.Array内容为String),
     *        各行数据(Key为data,value为JSONArray.Array内容为每行数据,其Key为ColumnName,value为Cell的text).
     * @param dirPath 导出文件的目录.
     */
    static  public  File exportToFile(JSONObject gridObject,Path dirPath) {
            String title = gridObject.get(GridTitle).toString();
            File d = dirPath.toFile();
            d.mkdir();
            Path filePath = Paths.get(dirPath.toString(),title+".pdf");
            File f = filePath.toFile();

        try {
            f.createNewFile();

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            FileOutputStream stream = new FileOutputStream(f);
            PdfWriter writer = PdfWriter.getInstance(doc, stream);
            //TODO:中文特殊处理字体，字体路径问题
            Font chineseFont = new Font(BaseFont.createFont("/Library/Fonts/WeibeiSC-Bold.otf", BaseFont.IDENTITY_H,
                    BaseFont.NOT_EMBEDDED));

            JSONArray colArray = gridObject.getJSONArray(GridColumns);
            JSONArray dataArray = gridObject.getJSONArray(GridDatas);
            PdfPTable table = new PdfPTable(colArray.length());
            for (int i = 0; i < colArray.length(); i++) {
                table.addCell(new Phrase(colArray.getString(i),chineseFont));
            }
            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject rowArray = dataArray.getJSONObject(i);
                for (int j = 0; j < colArray.length(); j++) {
                    table.addCell(new Phrase(rowArray.getString(colArray.getString(j)),chineseFont));
                }
            }

            table.setHeaderRows(0);
            doc.open();
            doc.addTitle(title);

            Paragraph titlePara = new Paragraph(title,chineseFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            doc.add(titlePara);
            doc.add(new Paragraph("\n"));

            Paragraph tablePara = new Paragraph();
            tablePara.add(table);
            doc.add(tablePara);
            doc.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return f;
    }
    /**
     * 将Grid信息导出PDF文件到指定目录
     * @param title 文件名,也是文件标题与SheetName.
     * @param colData 列信息，显示在第一行.
     * @param rowDatas 行数据.Key为列信息中的内容.
     * @param dirPath 导出文件的目录.
     */
    public static void main(String[] args) {
		String title="pdfTest";
		ArrayList<String> list=new ArrayList<String>();
		list.add("标题1");
		list.add("标题2");
		list.add("标题3");
		ArrayList<Map> listMap=new ArrayList<Map>();
		for(int i=0;i<3;i++){
			Map<String,String> map=new HashMap<String,String>();
			map.put("标题1", "asd");
			map.put("标题2", "qwe");
			map.put("标题3", "ert");
			listMap.add(map);
		}
		exportToFile(title,list,listMap,Paths.get("D:\\"));
	}
    static public File exportToFile(String title,ArrayList<String> colData,ArrayList<Map> rowDatas, Path dirPath) {
        File d = dirPath.toFile();
        d.mkdir();
        Path filePath = Paths.get(dirPath.toString(),title+".pdf");
        File f = filePath.toFile();

        try {

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            f.createNewFile();
            FileOutputStream stream = new FileOutputStream(f);
            PdfWriter writer = PdfWriter.getInstance(doc, stream);
            //TODO:中文特殊处理字体，字体路径问题
            Font chineseFont = new Font(BaseFont.createFont(PDFExporter.class.getResource("/") + "/SIMSUN.TTC,1", BaseFont.IDENTITY_H,
                    BaseFont.NOT_EMBEDDED));

            PdfPTable table = new PdfPTable(colData.size());
            //Add Columns
            for (int i = 0; i < colData.size(); i++) {   
                table.addCell(new Phrase(colData.get(i).toString(),chineseFont));
            }
            //Add Data Cells
            for (int i = 0; i < rowDatas.size(); i++) {
                Map rowMap = rowDatas.get(i);
                for (int j = 0; j < colData.size(); j++) {
                    table.addCell(new Phrase(rowMap.get(colData.get(j).toString()).toString(),chineseFont));

                }
            }

            table.setHeaderRows(0);
            doc.open();
            doc.addTitle(title);
            Paragraph titlePara = new Paragraph(title,chineseFont);
            titlePara.setAlignment(Element.ALIGN_CENTER);
            doc.add(titlePara);
            doc.add(new Paragraph("\n"));

            Paragraph tablePara = new Paragraph();
            tablePara.setFont(chineseFont);
            tablePara.add(table);
            doc.add(tablePara);
            doc.close();
            writer.close();
            System.out.println("导出成功！！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return f;
    }
}
