package modules;

import testbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends Base {

    WebDriver driver;

    public ProductsPage() {
        this.driver = Base.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".header_secondary_container > span")
    public WebElement header;

    @FindBy(className = "inventory_item")
    public List<WebElement> listOfItems;


    public String getHeaderText() {
        return header.getAttribute("innerText");
    }

    public List<WebElement> getListOfItems() {
        if (listOfItems != null) {
            System.out.println("List of products isn't empty: " + listOfItems.size());
        } return listOfItems;
    }

}
