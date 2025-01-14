package modules;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {


	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ChromeOptions options = new ChromeOptions();
	public static WebDriverWait webDriverWait = null;


	public static WebDriver driver() {
		return driver.get();
	}

	public static void PageObectInitialization() {

	}

	public static void destroyPageObjects() {

	}

	public static void createInstance(String input) {

		switch (input.toLowerCase()) {
		case "chrome":
			Map<String, Object> preference = new HashMap<>();

		}
		}
}
