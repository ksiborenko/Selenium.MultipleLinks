import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Links {

    private WebDriver driver;

    public Links(WebDriver driver) {
        this.driver = driver;
    }

    public void test() {
        this.driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = this.driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        WebElement footer = this.driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
        List<WebElement> footerList = footer.findElements(By.tagName("a"));
        String keys = Keys.chord(Keys.CONTROL, Keys.ENTER);
        Set<String> urls = null;
        Iterator<String> iterate = null;
        for (int x = 0; x < footerList.size(); x++) {
            footerList.get(x).sendKeys(keys);
            urls.add(this.driver.getWindowHandle());
            iterate = urls.iterator();
            if (iterate.hasNext()) {
                iterate.next();
            }
        }
    }
}

