import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRunner {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get(ConfigProvider.BASE_URL);

        WebElement qaAutomationCourse = driver.findElement(By.xpath("//ul[@class='course-nav_list']/li[3]/a[contains(@href, 'automation')]"));

        qaAutomationCourse.click();
        wait.until(ExpectedConditions.titleContains("QA Automation"));
        driver.quit();
    }
}
