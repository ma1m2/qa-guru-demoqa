package qa.msl.tests;

import org.junit.jupiter.api.Test;
import qa.msl.testdata.TestDataFaker;

public class RegistrationTests extends BaseTest{

  @Test
  void succesfulRegistrationTest() {
    TestDataFaker tdf = new TestDataFaker();
    registrationPage.openPage()
            .typeFirstName(tdf.firstName)
            .typeLastName(tdf.lastName)
            .typeUserEmail(tdf.userEmail)
            .setGender(tdf.gender)
            .typeUserNumber(tdf.phoneNumber)
            .setDateOfBirth(tdf.day, tdf.month, tdf.year)
            .setHobby(tdf.hobbie)
            .setSubject(tdf.subject)
            .uploadPhoto(tdf.imgName)
            .typeCurrentAddress(tdf.currentAddress)
            .setStateAndCity(tdf.state, tdf.city)
            .submitForm()
            .checkModalWindowAppears()
            .checkOutput("Student Name", tdf.firstName + " " + tdf.lastName)
            .checkOutput("Student Email", tdf.userEmail)
            .checkOutput("Gender", tdf.gender)
            .checkOutput("Mobile", tdf.phoneNumber)
            .checkOutput("Date of Birth", tdf.day + " " + tdf.month + "," + tdf.year)
            .checkOutput("Subjects", tdf.subject)
            .checkOutput("Hobbies", tdf.hobbie)
            .checkOutput("Address", tdf.currentAddress)
            .checkOutput("Picture", tdf.imgName)
            .checkOutput("State and City", tdf.state + " " + tdf.city)
            .closeModalWindow();
  }

}
