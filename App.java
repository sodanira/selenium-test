package SeleniumTest.SeleniumTest;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

/**
 * Hello world!
 *
 */
public class App {
//	public static WebDriver driver = new ChromeDriver();

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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\U5988179\\Documents\\chromedriver_win32\\chromedriver.exe");
//        	WebDriver driver = new ChromeDriver();
//        	// And now use this to visit Google
//        	driver.get("https://thaiortho.org/");
		
//		accessHomepage();
//		gotofindDentistpage();
//		findDentistByName();
//		findDentistByLocation();
//		accessFacebookpage();
//		accessYoutubepage();
//		accessSearchBlogPage();
//		accessCategoryPage();
//		test9(driver);
//        test10(driver);
//		test11();
		test12();
	}
	
	public static void accessHomepage() {
		//Test 1: Get page title text to find whether access correct webpage
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://thaiortho.org/";
		String expectedTitleHome = "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย";
		String actualTitleHome = "";

		driver.get(baseUrl);

		// get the actual value of the title
		WebElement elementHome = driver.findElement(By.xpath(page_title_home));
		actualTitleHome = elementHome.getText();

		if (actualTitleHome.contentEquals(expectedTitleHome)) {
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
		String expectedTitlePage2 = "ค้นหาทันตแพทย์จัดฟัน";

		driver.get(baseUrl);
		driver.findElement(By.xpath(find_dentist_button)).click();

		// get the actual value of the title
		WebElement elementPage2 = driver.findElement(By.xpath(page_title_page2));
		String actualTitlePage2 = elementPage2.getText();

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
		String Name = "นิรมล";

		driver.get(baseUrl);

		driver.findElement(By.xpath(close_button)).click();
		driver.findElement(By.xpath(find_by_name_button)).click();
		driver.findElement(By.xpath(find_by_name_input)).sendKeys(Name);

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
		String error = "There was a problem with your submission. Errors are marked below.";

		driver.get(baseUrl);

		driver.findElement(By.xpath(close_button)).click();
		driver.findElement(By.xpath(find_by_location_button)).click();
		driver.findElement(By.xpath(seacrh_by_country)).click();
		driver.findElement(By.xpath(seacrh_by_country_input)).sendKeys("กรุงเทพมหานคร");
		driver.findElement(By.xpath(seacrh_by_country_submit_button)).click();
		driver.findElement(By.xpath(close_button)).click();

		WebElement elementError = driver.findElement(By.xpath(error_alert));

		if (elementError.getText().contentEquals(error)) {
			System.out.println("Test 4 Passed!");
		} else {
			System.out.println("Test 4 Failed");
		}
		//close Fire fox
		driver.close();
	}

	public static void accessFacebookpage() 
	{
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
		String fackbook_button = "/html/body/div/div/div/section[1]/div/div/div[2]/div/div/div[3]/div/div/a[1]";
//    	System.setProperty("webdriver.chrome.driver", "C:/Users/User/Desktop/QAT/SeleniumTest/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://thaiortho.org/";
        String expectedTitle = "หมอจัดฟันไทย - หน้าหลัก | Facebook";
        String actualTitle = "";
        //for full screen
//        driver.manage().window().maximize();
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        driver.findElement(By.xpath(fackbook_button)).click();
        //set old window tab
        String HomeWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String currentWindow : windows) 
        {
            //move to new tab
        	if(currentWindow.equals(HomeWindow)==false) 
        	{
        		driver.switchTo().window(currentWindow);	
        		break;
        	}
        	//close old tab
        	driver.close();
        }
        // get the actual value of the title
        actualTitle = driver.getTitle();
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test failed!");
        }
        //close all windows
        driver.quit();
    }

	

	public static void accessYoutubepage() {
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://thaiortho.org/";
		String ytURL = "https://www.youtube.com/channel/UCXhesSBZWDQq_1k9SoYYnnQ";
		String expectedTitle = "หมอจัดฟันไทย - YouTube";
		String youtube_button = "/html/body/div/div/div/section[1]/div/div/div[2]/div/div/div[3]/div/div/a[2]";
		String actualTitle = "";
		
		driver.get(baseUrl);

		// get the actual value of the title
		driver.get(baseUrl);
        driver.findElement(By.xpath(youtube_button)).click();
        //set old window tab
        String HomeWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for(String currentWindow : windows) 
        {
            //move to new tab
        	if(currentWindow.equals(HomeWindow)==false) 
        	{
        		driver.switchTo().window(currentWindow);	
        		break;
        	}
        	//close old tab
        	driver.close();
        }
        // get the actual value of the title
        actualTitle = driver.getTitle();
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } 
        else 
        {
            System.out.println("Test failed!");
        }
        //close all windows
        driver.quit();
	}

	public static void accessSearchBlogPage() {
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://thaiortho.org/";
		driver.get(baseUrl);

		String search_icon = "//i[@class='fas fa-search']";
		String search_input = "//input[@type='search']";
		String search_form = "//form[@role='search']";
		String search_heading = "//p[contains(@class, 'elementor-heading-title elementor-size-default')]";
		String search = "การจัดฟันคืออะไร";
		String expected = "Search Results for: การจัดฟันคืออะไร";

		driver.findElement(By.xpath(search_icon)).click();
		driver.findElement(By.xpath(search_input)).sendKeys(search);
		driver.findElement(By.xpath(search_form)).submit();

		WebElement actualHeading = driver.findElement(By.xpath(search_heading));

		if (actualHeading.getText().trim().contentEquals(expected)){
			System.out.println("Test 7 Passed!");
		} else {
			System.out.println("Test 7 Failed");
		}

		driver.close();
	}

	public static void accessCategoryPage() {
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://thaiortho.org";
		String path = "/category/general-knowledge/";
		String cat_page = baseUrl + path;

		driver.get(baseUrl);

		String page_heading = "//p[contains(@class, 'elementor-heading-title elementor-size-default')]";
		String expected = "สาระน่ารู้";

		// Test Click
		driver.findElement(By.xpath("//a[@href='"+ path +"']")).click();

		// Get new Document Object Model
		driver.get(cat_page);

		// Get element
		WebElement actualHeading = driver.findElement(By.xpath(page_heading));

		if (actualHeading.getText().trim().contentEquals(expected)){
			System.out.println("Test 8 Passed!");
		} else {
			System.out.println("Test 8 Failed");
		}

		// Close an opened tabs (2 tab bars)
		driver.quit();
	}
	
	public static void test9(WebDriver driver) {
		//1. Click on the Payment tab
		driver.findElement(By.linkText("Payment")).click();
		//2. Click English Payment tab
		driver.findElement(By.id("elementor-tab-title-1962")).click();
		//3. Click on the link of Payment form
		WebElement element = driver.findElement(By.linkText("CLICK HERE TO BEGIN CREDIT CARD ONLINE PAYMENT")); 
		element.click();

		//4. Received text from tag (a)
		String actualText = element.getText();
		System.out.println(element.getText());
		String expectedText = "CLICK HERE TO BEGIN CREDIT CARD ONLINE PAYMENT";
		//5. Check whether expected text and actual text from tag (a) is equal or not
		if (actualText.contentEquals(expectedText)){
			System.out.println("Test 9 Passed!");
		    } else {
			System.out.println("Test 9 Failed");
		    }

		driver.quit();
	}
	
	public static void test10(WebDriver driver) {
		//1. Click on the Login tab
		driver.findElement(By.linkText("เข้าสู่ระบบ")).click();
		//2. Input user name
		WebElement username = driver.findElement(By.id("user"));
		username.sendKeys("SodaAndTheBoys");
		//3. Input password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("0123456789!SodaAndTheBoys");
		//4. Check remember
		driver.findElement(By.name("rememberme")).click();
		//5. Submit information
		driver.findElement(By.name("wp-submit")).submit();

		//WebElement element = driver.findElement(By.id(""));
		driver.quit();  
	}
	
	public static void test11() {
		WebDriver driver = new ChromeDriver();
		String News_button = "/html/body/div/div/div/section[3]/div/div/div/div/div/div[2]/div/div/article[1]/div/a";
		String Share_Facebook = "/html/body/div[2]/div/div/section/div/div/div/div/div/section/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/span/i";

        String baseUrl = "https://thaiortho.org/";
        String expectedTitle = "Facebook";
        String actualTitle = "";
        
        driver.manage().window().maximize();
        
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        
        driver.findElement(By.xpath(News_button)).click();
        driver.findElement(By.xpath(Share_Facebook)).click();
 
        String HomeWindow = driver.getWindowHandle();
        
        Set<String> windows = driver.getWindowHandles();
        
        for(String currentWindow : windows) {
            //move to new tab
        	if(currentWindow.equals(HomeWindow)==false) {
        		driver.switchTo().window(currentWindow);	
        		break;
        	}
        	//close old tab
        driver.close();
      }
    
        driver.manage().window().maximize();
        
        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
        	
            System.out.println("Test Failed!");
        }
       
        //close all windows
        driver.quit();
	}
	
	public static void test12() {
		WebDriver driver = new ChromeDriver();
		String Download_button = "//*[@id=\"menu-1-2f56841e\"]/li[4]/a";
    	String Article_button = "/html/body/div[2]/div/div/section/div/div/div/div/div/div/div/ul/li[1]/a/span[2]";
    	String baseUrl = "https://thaiortho.org/";
        String expectedUrl = "https://thaiortho.org/wp-content/uploads/2019/07/Cleft-ebook.pdf";
        String actualUrl = "";
        
        driver.manage().window().maximize();
        
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        
        driver.findElement(By.xpath(Download_button)).click();
        driver.findElement(By.xpath(Article_button)).click();

        String HomeWindow = driver.getWindowHandle();
        
        Set<String> windows = driver.getWindowHandles();
        
        for(String currentWindow : windows) {
            //move to new tab
        	if(currentWindow.equals(HomeWindow)==false) {
        		driver.switchTo().window(currentWindow);	
        		break;
        	}
        	//close old tab
        driver.close();
      }

        driver.manage().window().maximize();
        
        // get the actual value of the title
        actualUrl = driver.getCurrentUrl();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualUrl.contentEquals(expectedUrl)){
            System.out.println("Test Passed!");
        } else {
        	
            System.out.println("Test Failed!");
        }
       
        //close all windows
        driver.quit();
	}
}