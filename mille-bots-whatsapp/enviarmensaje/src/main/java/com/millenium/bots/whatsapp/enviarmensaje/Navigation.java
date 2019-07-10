package com.millenium.bots.whatsapp.enviarmensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import com.millenium.bots.ahk.AhkFunctions;
import com.millenium.bots.selenium.DriversManager;
import com.millenium.bots.selenium.DriversManager.DriverType;
import com.millenium.bots.selenium.SeleniumFunctions;

/**
 * Navegacion
 *
 * @author cavillada
 * @date Apr 5, 2018
 */
public class Navigation {

	private static WebDriver driver = null;
	
	private static AhkFunctions ahkFunctions = AhkFunctions.getInstance();
	
	/**
	 * 
	 */
	public Navigation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void killBots() throws IOException {
		String line;
		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String myPID = getPID();
		ProcessBuilder pb = null;
		String pidJava;
		while ((line = input.readLine()) != null) {
			if (line.contains("java.exe") || line.contains("chromedriver.exe")) {
				pidJava = (line.split("\\s+"))[1];
				if (!myPID.equals(pidJava)) {
					System.out.println("kill to: " + pidJava);
					pb = new ProcessBuilder("Taskkill", "/F", "/PID", pidJava);
					pb.start();
				}
			}
		}
		input.close();
	}
	
	private static String getPID() {
		String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
		return processName.split("@")[0];
	}
	
	public static boolean enterWhatsApp(String url) throws Exception {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\cavillada\\AppData\\Local\\Google\\Chrome\\User Data\\Default");

        DriversManager driversManager = new DriversManager();
        
		driver = driversManager.getDriver("1", DriverType.CHROME, options);
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement ok = SeleniumFunctions.getWebElementByXpath(driver, "//*[@id='action-button']", 60L);
		if (ok == null) {
			return false;
		}
		ok.click();
		
		WebElement enviar = SeleniumFunctions.getWebElementByXpath(driver, "//*[@id=\"main\"]/footer/div[1]/div[2]/div/div[2]", 60L);
		if (enviar == null) {
			return false;
		}
		enviar.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		return true;
	}
	
	/**
	 * @return the ahkFunctions
	 */
	public static AhkFunctions getAhkFunctions() {
		return ahkFunctions;
	}
	
	public static void killBrowser() {
		ahkFunctions.freeCmd("Process, close, chrome.exe");
	}
	
	public static void killDriver() {
		driver.quit();
	}

}
