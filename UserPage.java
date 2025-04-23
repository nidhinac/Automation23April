package UsersModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.assignment.drivermanager.DriverReader;
import com.assignment.utilities.CommonUtilities;

public class UserPage
{
	public UserPage()
	{
		PageFactory.initElements(DriverReader.getDriver(), this);
	}
	String useremail1=" ";
	CommonUtilities cu=new CommonUtilities();


	@FindBy (xpath="//span[text()='Users']")
	WebElement userTab;

	@FindBy (xpath="//*[text()='Create User ']")
	WebElement createuser;

	@FindBy(xpath="//*[@id='email']")
	WebElement useremail;

	@FindBy(xpath="//button[text()='Create User']")
	WebElement createUserButton;

	public void userTabClick()
	{
		try 
		{
			System.out.println("userTabClick");
			Thread.sleep(2000);
			userTab.click();
			//logger.info("userTabClick method");
		} 
		catch (Exception e)
		{
			//logger.info("Error"+e);
		}
	}
	public void createNewUser()
	{
		try 
		{
			createuser.click();
			//logger.info("CreateNewUser");
		}
		catch (Exception e) 
		{
			//logger.info("Error"+e);
		}
	}
	public void userform(String email)
	{
		try 
		{
			CommonUtilities.changewindow(DriverReader.getDriver());
			useremail1=email;
			useremail.sendKeys(email);
			//logger.info("userform method");
		}
		catch (Exception e)
		{
			//logger.info("Error"+e);
		}
	}
	public void psroalButton()
	{
		try 
		{
			List<WebElement> li =DriverReader.getDriver().findElements(By.xpath("//button[text()='Prof. Services']"));
			li.get(1).click();
			//logger.info("Prof.Service role is Active for user "+useremail1);
		}
		catch (Exception e)
		{
			//logger.info("Error"+e);
		}

	}
	public void pmroalButton()
	{
		try 
		{
			List<WebElement> li = DriverReader.getDriver().findElements(By.xpath("//button[text()='Project Manager']"));
			li.get(1).click();
			//logger.info("project Manager role is Active for user "+useremail1);
		} 
		catch (Exception e) 
		{
			//logger.info("Error"+e);

		}
	}
	//	public void ssroalButton()
	//	{
	//		try
	//		{
	//			List<WebElement> li = DriverReader.getDriver().findElements(By.xpath("//button[text()='Sim Specialist']"));
	//			li.get(1).click();
	//			logger.info("SIM Specialist role is Active for user "+useremail1);
	//
	//		} 
	//		catch (Exception e)
	//		{
	//			logger.info("Error"+e);
	//
	//		}
	//	}
	public void createNewUserButton()
	{
		try 
		{
			createUserButton.click();
			boolean value = cu.isdisplay("//i[@class='fas fa-info-circle FieldGroup__icon___2ceif']");
			System.out.println("ao creation"+value);
			Assert.assertEquals(false, value);
			//			createUserButton.click();;
			//			WebElement error = DriverReader.getDriver().findElement(By.xpath("//i[@class='fas fa-info-circle FieldGroup__icon___2ceif']"));
			//			boolean
		}
		catch (Exception e)
		{
			//logger.info("Error"+e);

		}
	}
}

