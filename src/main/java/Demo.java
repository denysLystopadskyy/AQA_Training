import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by denys.lystopadskyy on 5/16/2017.
 */
public class Demo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("url");

        ArrayList<WebElement> elements = new ArrayList<WebElement>();

        getElementWithUserName(elements);

        Map<Object, Integer> map = new HashMap<>();

        map.entrySet()
                .removeIf(set -> set.getValue() != 10);

    }

    private static void getElementWithUserNameStream(ArrayList<WebElement> elements) throws Exception {
        elements.parallelStream()
                .filter(element -> element.getText().contains("Denys"))
                .findAny()
                .ifPresent(WebElement::click);
    }

    private static void getElementWithUserName(ArrayList<WebElement> elements) {
        for (WebElement element : elements) {
            if (element.getText().contains("Denys")) {
                element.click();
                break;
            }
        }
    }

}
