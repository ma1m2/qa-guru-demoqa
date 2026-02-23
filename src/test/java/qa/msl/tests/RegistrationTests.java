package qa.msl.tests;

import org.junit.jupiter.api.Test;

import static qa.msl.testdata.TestData.*;

public class RegistrationTests extends BaseTest{

  @Test
  void succesfulRegistrationTest() {
    registrationPage.openPage()
            .typeFirstName(firstName)
            .typeLastName(lastName)
            .typeUserEmail(userEmail)
            .setGender(gender)
            .typeUserNumber(phoneNumber)
            .setDateOfBirth(day, month, year)
            .setHobby(hobbie)
            .setSubject(subject)
            .uploadPhoto(fileName)
            .typeCurrentAddress(currentAddress)
            .setStateAndCity(state, city)
            .submitForm()
            .checkModalWindowAppears()
            .checkOutput("Student Name",firstName + " " + lastName)
            .checkOutput("Student Email", userEmail)
            .checkOutput("Gender", gender)
            .checkOutput("Mobile", phoneNumber)
            .checkOutput("Date of Birth", day+" "+month+","+year)
            .checkOutput("Subjects", subject)
            .checkOutput("Hobbies", hobbie)
            .checkOutput("Address", currentAddress)
            .checkOutput("Picture", fileName)
            .checkOutput("State and City", state+" "+city)
            .closeModalWindow();
  }

}
