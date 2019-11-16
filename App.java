package niramol.testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

/**
 * Hello world!
 *
 */
public class App 
{
	//xpath Test 1
	public static String page_title_home = "//p[contains(text(), 'สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย') ]"; 
	//xpath Test 2
	public static String find_dentist_button = "//span[contains(text(), \"ค้นหาทันตแพทย์จัดฟัน\")]";
	public static String page_title_page2 = "//p[contains(text(), \"ค้นหาทันตแพทย์จัดฟัน\")]";
	
	//xpath Test 3
	public static String close_button = "//*[@id=\"elementor-popup-modal-2404\"]/div/div[4]";
	public static String find_by_name_button = "//a[contains(text(), 'ค้นหาจากรายชื่อ') ]";
	public static String find_by_name_input = "//label/input";
	public static String find_by_name_Niramol = "//td[contains(@class, 'column-1')]";
	
	//xpath Test 4
	public static String find_by_location_button = "//a[contains(text(), 'ค้นหาตามพื้นที่') ]";
	public static String seacrh_by_country = "//div[contains(@id, \"field_agfju4_chosen\")]";	
	public static String seacrh_by_country_input = "//div[@id='field_agfju4_chosen']/div/div/input";
	public static String seacrh_by_country_submit_button = "//button[@type=\"submit\"]";
	public static String error_alert = "//div[contains(@class, 'frm_error_style')]";
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\U5988157\\Documents\\chromedriver_win32\\chromedriver.exe"); 
	    
		accessHomepage();
	    gotofindDentistpage();
	    findDentistByName();
		findDentistByLocation();
		
		}
	public static void accessHomepage() {
		//Test 1: Get page title text to find whether access correct webpage
		WebDriver driver = new ChromeDriver();
	    String baseUrl = "https://thaiortho.org/";
	    driver.get(baseUrl);
		String expectedTitleHome = "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย";
	    String actualTitleHome = "";  
	    
	    // get the actual value of the title
	    WebElement elementHome = driver.findElement(By.xpath(page_title_home));
	    actualTitleHome = elementHome.getText();
	   
	    if (actualTitleHome.contentEquals(expectedTitleHome)){
	        System.out.println("Test 1 Passed!");
	    } else {
	        System.out.println("Test 1 Failed");
	    }
	    driver.close();
	}
	public static void gotofindDentistpage() {
		//Test 2: Go to FindDentist page from Homepage's nav bar
		WebDriver driver = new ChromeDriver();
	    String baseUrl = "https://thaiortho.org/";
	    driver.get(baseUrl);
		driver.findElement(By.xpath(find_dentist_button)).click();
	    String expectedTitlePage2 = "ค้นหาทันตแพทย์จัดฟัน";
	    String actualTitlePage2= "";  
	    
	    // get the actual value of the title
	    WebElement elementPage2 = driver.findElement(By.xpath(page_title_page2));
	    actualTitlePage2 = elementPage2.getText();
	    
	    if (actualTitlePage2.contentEquals(expectedTitlePage2)){
	        System.out.println("Test 2 Passed!");
	    } else {
	        System.out.println("Test 2 Failed");
	    }
		    
		//close Fire fox
		driver.close();
	}
	
	public static void findDentistByName() {
		//Test 3: Search by inputting name into search box
		WebDriver driver = new ChromeDriver();
	    String baseUrl = "https://thaiortho.org/search-orthodontist-people/";
	    driver.get(baseUrl);
	    
	    driver.findElement(By.xpath(close_button)).click();
	    driver.findElement(By.xpath(find_by_name_button)).click();
	    driver.findElement(By.xpath(find_by_name_input)).sendKeys("นิรมล");
	    String Name = "นิรมล";
	    WebElement elementName = driver.findElement(By.xpath(find_by_name_Niramol));
	    
	    if (elementName.getText().contentEquals(Name)){
	        System.out.println("Test 3 Passed!");
	    } else {
	        System.out.println("Test 3 Failed");
	    }
	  //close Fire fox
	  driver.close();
	}
	
	public static void findDentistByLocation() {
		//Test 4: Search by inputting Country into search box then appears the error alert
		WebDriver driver = new ChromeDriver();
	    String baseUrl = "https://thaiortho.org/search-orthodontist-people/";
	    driver.get(baseUrl);
	    
	    driver.findElement(By.xpath(close_button)).click();
	    driver.findElement(By.xpath(find_by_location_button)).click();
	    driver.findElement(By.xpath(seacrh_by_country)).click();
	    driver.findElement(By.xpath(seacrh_by_country_input)).sendKeys("กรุงเทพมหานคร");
	    driver.findElement(By.xpath(seacrh_by_country_submit_button)).click();
	    
	    driver.findElement(By.xpath(close_button)).click();
	    WebElement elementError = driver.findElement(By.xpath(error_alert));
	    String error = "There was a problem with your submission. Errors are marked below.";
	    if (elementError.getText().contentEquals(error)){
	        System.out.println("Test 4 Passed!");
	    } else {
	        System.out.println("Test 4 Failed");
	    }
	  //close Fire fox
	  driver.close();
	}
	
}
