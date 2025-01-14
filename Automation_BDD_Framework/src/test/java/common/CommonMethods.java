package common;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class CommonMethods {
	WebDriver driver;

	public CommonMethods(WebDriver driver) {
		this.driver=driver;
	}
	public void matSelectdropdown(WebElement element,String visibleText) {
		try {
				Wait.elementToBeClickable(element);
				element.click();
				List<WebElement> options =element.findElements(By.xpath("following::div[@role='listbox']//mat-option"));
				for(WebElement option:options) {
					String actual = option.findElement(By.xpath("child::span")).getText().trim();
					System.out.println(visibleText);
					if(actual.equals(visibleText)) {
						Thread.sleep(2000);
						option.click();
//						option.sendKeys(Keys.TAB);
						break;
					}
				}
			} catch (Exception e) {
				SoftAssert soft =new SoftAssert();
				soft.fail();
				e.printStackTrace();
			}

		}


	public void matSelectdropdown1(WebElement element,String visibleText) {
		try {
				Wait.elementToBeClickable(element);
				element.click();
				List<WebElement> options =element.findElements(By.xpath("(//mat-select[@role='combobox'])[4]"));
				for(WebElement option:options) {
					String actual = option.findElement(By.xpath("child::span")).getText().trim();
					System.out.println(visibleText);
					if(actual.equals(visibleText)) {
						Thread.sleep(2000);
						option.click();
//						option.sendKeys(Keys.TAB);
						break;
					}
				}
			} catch (Exception e) {
				SoftAssert soft =new SoftAssert();
				soft.fail();
				e.printStackTrace();
			}

		}




	public void JavascriptScrollIntoView(WebElement element) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void JavascriptClick(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToBottom(WebElement elementm) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void switchTOWindow(String currentWindowHanlde) {

	        Set<String> allWindowHandles = driver.getWindowHandles();

	        // Here we will check if child window has other child windows and will fetch the heading of the child window
	        for (String ChildWindow : allWindowHandles) {
	            if (!currentWindowHanlde.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	            }
	        }
	}

	public void switchTOWindow(String currentWindowHanlde,int index) {
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String>handles=new ArrayList<>(allWindowHandles);
        driver.switchTo().window(handles.get(index));
	}





	/**
     * Compares two lists of strings and validates whether they match or not.
     *
     * @param expectedList The list of expected values.
     * @param actualList   The list of actual values.
     * @return boolean     True if both lists are identical, otherwise false.
     */
    public  boolean compareLists(List<String> expectedList, List<String> actualList)
    {
        if (expectedList == null || actualList == null) {
            throw new IllegalArgumentException("Lists must not be null.");
        }

        // Check if sizes match
        if (expectedList.size() != actualList.size()) {
            System.out.println("Validation Failed: List sizes do not match.");
            System.out.println("Expected Size: " + expectedList.size() + ", Actual Size: " + actualList.size());
            return false;
        }

        // Compare each element
        for (int i = 0; i < expectedList.size(); i++)
        {
            String expected = expectedList.get(i).trim();
            String actual = actualList.get(i).trim();
            if (!expected.equals(actual))
            {
                System.out.println("Validation Failed at Index " + i + ":");
                System.out.println("Expected: " + expected);
                System.out.println("Actual: " + actual);
                return false;
            }
        }

        System.out.println("Validation Successful: Both lists match!");
        return true;
    }





	public String generateRandomString (String type, int length) {
		String candidateChars=null;
		StringBuilder sb = new StringBuilder ();
		Random random = new Random ();
		switch (type.toLowerCase()) {
		case "word":
			candidateChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for (int i = 0; i < length; i ++) {
	            sb.append (candidateChars.charAt (random.nextInt (candidateChars
	                    .length ())));
	        }
			break;
		case "number":
			candidateChars="0123456789";
			for (int i = 0; i < length; i ++) {
	            sb.append (candidateChars.charAt (random.nextInt (candidateChars
	                    .length ())));
	        }
			break;
		default:
			System.out.println("Mention type properly");
			break;
		}
		return sb.toString();

	}


	
}
