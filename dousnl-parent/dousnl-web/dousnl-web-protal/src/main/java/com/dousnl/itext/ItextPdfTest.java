package com.dousnl.itext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfTest {

	public static void main(String[] args) {
		
		Document document=new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("e:/Hello world.pdf"));
			document.open();
			
			Chunk chunk=new Chunk("Chunk elments");
			String content="Quick brown fox jumps over the lazy dog";
			//通过chunk构建phrase元素
			Phrase phrase=new Phrase(chunk);
			//通过字符串构建phrase元素
			Phrase textphrase=new Phrase(content);
			//直接通过字符串构建phrase元素
			Phrase text=new Phrase("Quick brown fox jumps over the lazy dog");
			//构建chapter对象并制定font
			Font font=new Font();
			Chapter chapter=new Chapter(new Paragraph("This is the title.",font), 1);
			
			
			document.add(new Paragraph("Hello World!"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
        document.close();
	}

}
