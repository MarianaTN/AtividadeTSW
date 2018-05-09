import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SeetingsUser {


    private WebDriver driver;

    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[3]/div[2]/ul/li[4]/div[2]/a")
    private WebElement changePasswordButton;

    @FindBy(xpath = "inputCurrentPassword")
    private WebElement textCurrentPassword;

    @FindBy(xpath = "inputNewPassword")
    private WebElement textNewPassword;

    @FindBy(xpath = "inputNewPassword2")
    private WebElement textNewPasswordAgain;

    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[1]/div/div/form/div[2]/button")
    private WebElement sendChangePasswordButton;

    @FindBy(xpath = "/html/body/app/div/main/app-settings/div/div[3]/div[1]/div/div[2]/div/app-file-uploader/div/div[1]/div[1]/label")
    private WebElement ChangePictureButton;

    public void ChangePassword(String newPassword, String currentPassword) {
        PageFactory.initElements((WebDriver) driver, this);

        changePasswordButton.click();
        textNewPassword.sendKeys(newPassword);
        textNewPasswordAgain.sendKeys(newPassword);
        textCurrentPassword.sendKeys(currentPassword);
        sendChangePasswordButton.click();

    }


}
