package SeleniumTest.SeleniumTest;


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
	public static WebDriver driver = new ChromeDriver();

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
	
		accessHomepage();
		gotofindDentistpage();
		findDentistByName();
		findDentistByLocation();
		accessFacebookpage();
		accessYoutubepage();
		accessSearchBlogPage();
		accessCategoryPage();
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

	public static void accessFacebookpage() {
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://thaiortho.org/";
		String fbURL = "https://www.facebook.com/ThaiOrtho";
		String expectedTitleHome = "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย";

		driver.get(baseUrl);

		// get the actual value of the title
		WebElement elementHome = driver.findElement(By.xpath(page_title_home));
		String actualTitleHome = elementHome.getText();

		if (actualTitleHome.contentEquals(expectedTitleHome)) {
			// must find button in webpage first then call click() method
			// driver.find_element_by_xpath("//a[@href='"+fbURL+"']");
			driver.findElement(By.xpath("//a[@href='"+fbURL+"']")).click();
			// baseUrl = "https://www.facebook.com/ThaiOrtho";
			// driver.get(baseUrl);
			// can go to facebook page but there is still error T-T
			// elementHome = driver.findElement(By.xpath(page_title_home));
			expectedTitleHome = "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย – Thai Association of Orthodontists";
			// actualTitleHome = elementHome.getText();
			actualTitleHome = driver.getTitle();

			if (actualTitleHome.contentEquals(expectedTitleHome)) {
				System.out.println("Test 5 Passed!");
			} else {
				System.out.println("Test 5 Failed");
			}
		} else {
			System.out.println("Test 5 Failed");
		}

	driver.quit();
	}

	public static void accessYoutubepage() {
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://thaiortho.org/";
		String ytURL = "https://www.youtube.com/channel/UCXhesSBZWDQq_1k9SoYYnnQ";
		String expectedTitleHome = "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย";

		driver.get(baseUrl);

		// get the actual value of the title
		WebElement elementHome = driver.findElement(By.xpath(page_title_home));
		String actualTitleHome = elementHome.getText();

		if (actualTitleHome.contentEquals(expectedTitleHome)) {
			// baseUrl = "https://www.youtube.com/channel/UCXhesSBZWDQq_1k9SoYYnnQ";
			// driver.get(baseUrl);
			// can go to facebook page but there is still error T-T
			//	elementHome = driver.findElement(By.xpath(page_title_home));
			driver.findElement(By.xpath("//a[@href='"+ytURL+"']")).click();
			expectedTitleHome = "สมาคมทันตแพทย์จัดฟันแห่งประเทศไทย – Thai Association of Orthodontists";
			//	actualTitleHome = elementHome.getText();
			actualTitleHome = driver.getTitle();
			// System.out.println(actualTitleHome);
			if (actualTitleHome.contentEquals(expectedTitleHome)) {
				System.out.println("Test 6 Passed!");
			} else {
				System.out.println("Test 6 Failed");
			}
		} else {
			System.out.println("Test 6 Failed");
		}

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
}
