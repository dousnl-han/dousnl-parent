import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class TEST {

	public static void main(String[] args) {
		System.out.print("Enter Client Id:");
		Scanner s = new Scanner(System.in);
		//receive string
		String str = s.next();
		System.out.print("Enter Service Code:");
		String str1 = s.next();
		System.out.print("Enter Number Of Launches:");
		int str2 = s.nextInt();
		System.out.print("enter choice Of orbit:");
		String str3 = s.next();
		System.out.print("Nitrogen Flush Needed y/n:");
		String str4 = s.next();
		if("y".equals(str4)){
			System.out.print("Insurance y/n:");
			String str5 = s.next();
			if("y".equals(str4)){
				System.out.print("Enter payload value:");
				double str6 = s.nextDouble();
				System.out.println("-----------------------------");
				System.out.println("SpaceY Quotation System");
				System.out.println("-----------------------------");
				System.out.println("");
				System.out.println("Client                      :"+str);
				System.out.println("Service Code                :"+str1);
				System.out.println("Number Of Launches          :"+str2);
				System.out.println("Orbit type                  :"+str3);
				System.out.println("Nitrogen Flush              :"+str4);
				System.out.println("Insurance                   :"+str4);
				System.out.println("Payload value               :"+str4);
				System.out.println("Credit Checked              :"+new Date());
				System.out.println("-----------------------------");
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("str", str);
				map.put("str1", str1);
				map.put("str2", str2);
				map.put("str3", str3);
				map.put("str4", str4);
				map.put("str5", str5);
				map.put("str6", str6);
				if(str2==1){
					double a1=62000000;
					map.put("a1", a1);
					System.out.println("Base price                      :$"+a1);
					System.out.println("Base price * launches                :$"+a1*str2);
					System.out.println("Gross launch cost          :$"+a1*str2);
					System.out.println("Nett launch cost                  :$"+a1*str2);
					System.out.println("NESA Tracking               :$"+str6);
					System.out.println("-----------------------------");
					System.out.println("Total Amount Due                   :$"+(a1*str2)+str6);
					System.out.print("Do you wish to create the html quote y/n:");
					String str7 = s.next();
					if("y".equals(str7)){
						doPdf(map);
						System.out.println("qwdqwd");
					}else{
						return;
					}
				}else if(str2==2){
					double a1=92000000;
					map.put("a1", a1);
					System.out.println("Base price                      :"+a1);
					System.out.println("Base price * launches                :"+a1*str2);
					System.out.println("Gross launch cost          :"+a1*str2);
					System.out.println("Nett launch cost                  :"+a1*str2);
					System.out.println("NESA Tracking               :"+str6);
					System.out.println("-----------------------------");
					System.out.println("Total Amount Due                   :"+(a1*str2)+str6);
					System.out.print("Do you wish to create the html quote y/n:");
					String str7 = s.next();
					if("y".equals(str7)){
						doPdf(map);
					}else{
						return;
					}
				}
			}else{
				return;
			}
		}else{
			return;
		}
	}

	/**
	 * documnet包maven依赖
	 * <dependency>   
     *   <groupId>com.lowagie</groupId>
     *   <artifactId>itext</artifactId>
     *   <version>2.0.8</version>
     * </dependency>
	 * @param map
	 */
	public static void doPdf(Map<String,Object> map){
		// step 1
	    Document document = new Document(PageSize.A4);
	    // step 2
	    try {
	      PdfWriter.getInstance(document, new FileOutputStream("D:/itextpdf"));
	       
	      document.addTitle("SpaceY Quote V2");
	      //document.addAuthor("dotuian"); 
	      //document.addSubject("This is the subject of the PDF file."); 
	      //document.addKeywords("This is the keyword of the PDF file.");
	      // step 3
	      document.open();
	      // step 4
	      document.add(new Paragraph("Courier New"));
	      document.add(new Paragraph("Client                      :"+map.get("str")));
	      document.add(new Paragraph("Service Code                :"+map.get("str1")));
	      document.add(new Paragraph("Number Of Launches          :"+map.get("str2")));
	      document.add(new Paragraph("Orbit type                  :"+map.get("str3")));
	      document.add(new Paragraph("Nitrogen Flush              :"+map.get("str4")));
	      document.add(new Paragraph("Insurance                   :"+map.get("str5")));
	      document.add(new Paragraph("Payload value               :"+map.get("str6")));
	      document.add(new Paragraph("Credit Checked              :"+new Date()));
		  document.add(new Paragraph("-----------------------------"));
		  document.add(new Paragraph("Base price                      :$"+(double)map.get("a1")));
		  document.add(new Paragraph("Base price * launches                :$"+(double)map.get("a1")*(int)map.get("str2")));
		  document.add(new Paragraph("Gross launch cost          :$"+(double)map.get("a1")*(int)map.get("str2")));
		  document.add(new Paragraph("Nett launch cost                  :$"+(double)map.get("a1")*(int)map.get("str2")));
		  document.add(new Paragraph("NESA Tracking               :$"+map.get("str6")));
		  document.add(new Paragraph("-----------------------------"));
		  document.add(new Paragraph("Total Amount Due                   :$"+(double)map.get("a1")*(int)map.get("str2")+map.get("str6")));
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (DocumentException e) {
	      e.printStackTrace();
	    } finally {
	      document.close();
	      System.out.println("成功生成pdf文件，文件路径D盘，文件名称:itextpdf");
	    } 
	}
}
