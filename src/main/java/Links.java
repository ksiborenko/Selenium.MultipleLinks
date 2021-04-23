import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Links {

    private WebDriver driver;

    public Links(WebDriver driver) {
        this.driver = driver;
    }

    public void test() {
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = this.driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement footer = this.driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
        List<WebElement> footerList = footer.findElements(By.tagName("a"));
        String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
        for (WebElement webElement : footerList) {
            webElement.sendKeys(keys);
        }

        Set<String> urls = this.driver.getWindowHandles();
        Iterator<String> iterate = urls.iterator();
        while (iterate.hasNext()) {
            this.driver.switchTo().window(iterate.next());
            System.out.println(this.driver.getCurrentUrl());
        }
    }
}

