package AlmosaferWebSite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestClass extends Parameter {
	@BeforeTest
	public void setUp() {
		driver.get(URL);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		WebElement popUpScreen = driver.findElement(By.className("sc-iBmynh"));
		if (popUpScreen.isDisplayed()) {
			WebElement SARButton = driver.findElement(By.className("cta__saudi"));
			SARButton.click();
		}
	}
//
//	@Test(priority = 2)
//	public void checkTheDefultLanguageIsEnglish() {
//		String expectedLanguage = "EN";
//		String actualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
//		System.out.println(actualLanguage);
//		assertEquals(actualLanguage, expectedLanguage);
//
//	}
//
//	@Test(priority = 3)
//	public void checkTheDefultCurrencyIsSAR() {
//		String expectedCurrency = "SAR";
//		String actualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
//				.getText();
//		System.out.println(actualCurrency);
//		assertEquals(actualCurrency, expectedCurrency);
//
//	}
//
//	@Test(priority = 4)
//	public void checkTheContactNumber() {
//		String expectedNumber = "+966554400000";
//		String actualNumber = driver.findElement(By.tagName("Strong")).getText();
//		System.out.println(actualNumber);
//		assertEquals(actualNumber, expectedNumber);
//
//	}
//
//	@Test(priority = 5)
//	public void checkQitafLogoInFooter() {
//		WebElement theFooter = driver.findElement(By.tagName("footer"));
//		boolean qitafLogo = theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
//		assertEquals(qitafLogo, true);
//
//	}
//
//	@Test(priority = 6)
//	public void checkHotel() {
//		String hotelSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"))
//				.getAttribute("aria-selected");
//		System.out.println(hotelSelected);
//		assertEquals(hotelSelected, "false");
//
//	}

	@Test(priority = 7) // ,invocationCount = 4
	public void selectRandomLanguage() {
		Random rand = new Random();
		int randomLang = rand.nextInt(language.length);
		driver.get(language[randomLang]);
		if (driver.getCurrentUrl().contains("ar")) {
			String expected = "ar";
			String actual = driver.findElement(By.tagName("html")).getAttribute("lang");
			System.out.println("the actual lang =" + actual);
			assertEquals(actual, expected);

		} else {
			String expected = "en";
			String actual = driver.findElement(By.tagName("html")).getAttribute("lang");
			System.out.println("the actual lang =" + actual);
			assertEquals(actual, expected);

		}
	}

//	@Test(priority = 8)
//	public void checkDepartureAndReturnDate() {
//		LocalDate date = LocalDate.now();
//		System.out.println(date);
//		int expectedDepartureDate = date.plusDays(1).getDayOfMonth();
//		System.out.println("expectedDepartureDate" + expectedDepartureDate);
//		int expectedReturnDate = date.plusDays(2).getDayOfMonth();
//		System.out.println("expectedReturnDate" + expectedReturnDate);
//
//		int actualDepartureDate = Integer.parseInt(
//				driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText());
//		int actualReturnDate = Integer.parseInt(
//				driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']")).getText());
//		assertEquals(actualDepartureDate, expectedDepartureDate);
//		assertEquals(actualReturnDate, expectedReturnDate);
//
//	}

	@Test(priority = 9)
	public void switchToHotel() throws InterruptedException {
		WebElement hotelButton = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelButton.click();

//		WebElement searchBar=driver.findElement(By.className("phbroq-2"));

		if (driver.getCurrentUrl().contains("ar")) {
			WebElement searchBar1 = driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));
			searchBar1.sendKeys(cityInAr[randAr]);
		} else {
			WebElement searchBar = driver
					.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
			searchBar.sendKeys(cityInEn[randEn]);

		}
		Thread.sleep(3000);
		WebElement theList = driver.findElement(By.className("UzzIN"));
		theList.findElements(By.tagName("li")).get(1).click();

	}

	@Test(priority = 10)
	public void randomSelectTheVisitorNumber() {
		WebElement selectRoom = driver.findElement(By.cssSelector(".tln3e3-1.eFsRGb"));
		Select selector = new Select(selectRoom);
//			selector.selectByIndex(1);
//			selector.selectByValue("B");
		if (driver.getCurrentUrl().contains("ar")) {
			selector.selectByVisibleText("1 غرفة، 1 بالغ، 0 أطفال");
		} else {
			selector.selectByVisibleText("1 Room, 1 Adult, 0 Children");
		}

		WebElement searchHotelButton = driver.findElement(
				By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[4]/button"));
		searchHotelButton.click();
	}

	@Test(priority = 11)
	public void checkThePageIsLoading() throws InterruptedException {

		Thread.sleep(35800);
		WebElement hotelSearchResult = driver.findElement(By.className("klWOBA"));

		if (driver.getCurrentUrl().contains("ar")) {
			boolean actualAr = hotelSearchResult.getText().contains("وجدنا");
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + actualAr);
			assertEquals(actualAr, true);
		} else {
			boolean actualEn = hotelSearchResult.getText().contains("found");
			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + actualEn);
			assertEquals(actualEn, true);
		}

	}

	@Test(priority = 12)
	public void lowestPrice() {

		WebElement lowestPriceButton = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));
		lowestPriceButton.click();

		WebElement thePriceContainer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));

		List<WebElement> theLowestPrice = thePriceContainer.findElements(By.className("Price__Value"));

		System.out.println("the total" + theLowestPrice.size());
		String low = theLowestPrice.get(0).getText();
		int lowPrice = Integer.parseInt(low);
		System.out.println("the low" + low);
		String max = theLowestPrice.get(theLowestPrice.size() - 1).getText();
		int maxPrice = Integer.parseInt(max);
		System.out.println("the max" + max);

		assertEquals(maxPrice > lowPrice, true);
		System.out.println("done");
	}

}
