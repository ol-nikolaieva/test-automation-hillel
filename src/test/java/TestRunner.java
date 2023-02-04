import com.hillel.core.driver.WebDriverFactory;
import com.hillel.util.ConfigProvider;
import org.openqa.selenium.WebDriver;

public class TestRunner {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver();

        driver.get(ConfigProvider.BASE_URL);

        driver.quit();
    }
}
