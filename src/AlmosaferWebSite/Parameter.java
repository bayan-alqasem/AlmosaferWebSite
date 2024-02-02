package AlmosaferWebSite;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameter {
	WebDriver driver = new ChromeDriver();
	String URL = "https://global.almosafer.com/en";
	String[] language = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	Random rand = new Random();
	String[] cityInAr = { "دبي", "جدة" };
	int randAr = rand.nextInt(cityInAr.length);
	String[] cityInEn = { "dubai", "jaddeh","riyad" };
	int randEn = rand.nextInt(cityInEn.length);

}
