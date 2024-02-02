package AlmosaferWebSite;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestClass extends Parameter {
	@BeforeTest
	public void setUp() {
		driver.get(URL);
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

	@Test(priority = 7,invocationCount = 4)
	public void selectRandomLanguage() {
		Random rand = new Random();
		int randomLang = rand.nextInt(language.length);
		driver.get(language[randomLang]);
		if (driver.getCurrentUrl().contains("ar")) {
			String expected = "ar";
			String actual = driver.findElement(By.tagName("html")).getAttribute("lang");
			System.out.println("the actual lang =" + actual);
			assertEquals(actual, expected);

		}else {
			String expected = "en";
			String actual = driver.findElement(By.tagName("html")).getAttribute("lang");
			System.out.println("the actual lang =" + actual);
			assertEquals(actual, expected);
			
		}}

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
	public void switchToHotel() {
		WebElement hotelButton=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelButton.click();

//		WebElement searchBar=driver.findElement(By.className("phbroq-2"));
		
		
		
		if(driver.getCurrentUrl().contains("ar")) {
			WebElement searchBar1=driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']"));
			searchBar1.sendKeys(cityInAr[randAr]);
		}else {
			WebElement searchBar=driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
			searchBar.sendKeys(cityInEn[randEn]);
			
		}
		
		
	}

}
