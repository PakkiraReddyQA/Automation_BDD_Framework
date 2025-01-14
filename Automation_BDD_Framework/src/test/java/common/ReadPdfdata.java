package common;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ReadPdfdata {

	URL PdfUrl;
	RandomAccessRead bis;
	PDFParser pdfparse;

	String getUrl;
	String texttoverify="Version 8.1";

	@Test
	public void readpdfdata() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("q")).sendKeys("pdf file url",Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='Links in PDF']")).click();
		getUrl=driver.getCurrentUrl();

		PdfUrl=new URL(getUrl);

		InputStream inpstrm = PdfUrl.openStream();
//	bis=(RandomAccessRead) new	BufferedInputStream(inpstrm);
//	pdfparse=new PDFParser(bis);
//	pdfparse.parse();
//
//	String pdfData=new PDFTextStripper().getText(pdfparse.getPDDocument());
//	System.out.println(pdfData);
//	Assert.assertTrue(pdfData.contains(texttoverify));


//		 InputStream iStream = url.OpenStream();
	        //Create Buffered Input Stream object to pass InputStream class object reference
	        BufferedInputStream bfStream = new BufferedInputStream(inpstrm);
	        // Create a PDF document object.
	        PDDocument document = PDDocument.load(bfStream);
	        // Get the first page of the document.
	        PDPage page = document.getPage(0);
	        // Create a PDFTextStripper object.
	        PDFTextStripper stripper = new PDFTextStripper();
	        // Strip the text from the page.
	        String text = stripper.getText(document);
//	        if(text.startsWith("https")||text.startsWith("http"))
//	        {
	        System.out.println(text);
//	        }

	}

}
