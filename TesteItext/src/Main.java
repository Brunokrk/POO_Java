
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;

public class Main {

	public static void main(String[] args) {
		//Criamos um documento vazio
		Document documentoPDF = new Document();
		
		try {
			//cria uma instancia do documento e da o nome do pdf
			PdfWriter.getInstance(documentoPDF, new FileOutputStream("C:\\Users\\pires\\Desktop\\Agora_foi.pdf"));
			
			//abrir documento
			documentoPDF.open();
			
			//setar tamanho da pagina
			documentoPDF.setPageSize(PageSize.A4);
			
			//adicionar primeiro paragrafo
			documentoPDF.add(new Paragraph("SE NÃO FUNCIONAR AGORA EU ME MATO"));
			
		}catch(DocumentException de) {
			de.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}finally {
			documentoPDF.close();
		}
	}

}
