import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Document document = new Document();
		String i;
		String t;

		try {
			//生成路徑
			String filename = "C:/iTextDemo/ChineseDisplay.pdf";
	        File file = new File(filename);
	        file.getParentFile().mkdirs();
	        //這個文件放在哪裡
			PdfWriter.getInstance(document,new FileOutputStream(filename));
			//開始處理中文
			BaseFont baseFont = BaseFont.createFont("/MSJHBD.TTC,0",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);	
			 Font font = new Font( baseFont, 12, Font.NORMAL );
			 //以上處理中文
			 document.open();
	        document.add(new Paragraph("劉德華你好！", font));
	        Paragraph to = new Paragraph("亲爱的傅遠勝：", font);
	        document.add(to);

	        Paragraph hello = new Paragraph("你好！", font);
	        hello.setIndentationLeft(28); // 整体缩进
	        document.add(hello);

	        Paragraph content = new Paragraph("我现在正在学习iText，正好写一封信给你，为了整点内容凑个换行，我这个不怎么擅长写作文的人也是拼了。", font);
	        content.setFirstLineIndent(24); // 首行缩进
	        document.add(content);

	        Paragraph from = new Paragraph("韩梅梅\n2017年11月29日", font);
	        from.setAlignment(Element.ALIGN_RIGHT); // 居右显示
	        document.add(from);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		document.close();
	}
}
