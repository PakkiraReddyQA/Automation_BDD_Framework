package common;




public class Main {

	
	public static void main(String[] args) {
		
	EdisonBokenLink objBokenLink=new EdisonBokenLink();
	String filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\Edison";
	String filename="EdsionBrokenLink";
	objBokenLink.createSheet(filepath, filename);
	 

	}

}
