package tests;

import org.junit.jupiter.api.Test;
import pages.FormPage;
import testbase.TestBase;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess(){
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(System.getProperty("firstName"))
                .setLastName(System.getProperty("lastName"))
                .setEmail(System.getProperty("email"))
                .setAge(System.getProperty("age"))
                .selectRandomProfession()
                .selectRandomExperience()
                .selectMale()
                .selectContinent(System.getProperty("continent"))
                .selectSeleniumCommand(System.getProperty("command"))
                .uploadFile(System.getProperty("filepath"))
                .submitForm();

        String message = formPage.getValidationMsg();

        assertThat(message, equalTo(System.getProperty("message")));
    }


}
