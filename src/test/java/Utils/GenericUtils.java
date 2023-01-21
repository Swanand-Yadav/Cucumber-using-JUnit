package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils 
{
	WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SwitchWindowToChild()
	{
		Set<String> windows= driver.getWindowHandles();
		//System.out.println(windows);
        Iterator<String> it=windows.iterator();
        String parent= it.next();
        String child=it.next();
        driver.switchTo().window(child);
	}
}
