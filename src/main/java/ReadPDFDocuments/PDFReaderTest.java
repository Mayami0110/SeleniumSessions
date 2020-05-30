package ReadPDFDocuments;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {

	@Test
	public void readpdf() throws IOException {

		URL url = new URL("file:///C:/Users/Mayami/Downloads/Resume_Mayank%20Mishra%20(2).pdf");

		InputStream isp = url.openStream();

		BufferedInputStream fileparse = new BufferedInputStream(isp);

		PDDocument document = null;

		document = PDDocument.load(fileparse);

		String pdfcontent = new PDFTextStripper().getText(document);
		
		System.out.println(pdfcontent);
		
		Assert.assertTrue(pdfcontent.contains("Mayank Mishra"));

	}

}
