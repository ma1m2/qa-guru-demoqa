package qa.msl.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static qa.msl.utils.RandomUtils.*;

public class RegistrationTests extends BaseTest{

  LocalDate randomDate;
  String[] stateAndCity;

  String firstName;
  String lastName;
  String userEmail;
  String gender;
  String phoneNumber;
  String year;
  String month;
  String day;
  String subject;
  String hobbie;
  String fileName;
  String state;
  String city;
  String currentAddress;

  @BeforeEach
  public void prepareData() {
    randomDate = fakerEn.date()
            .birthday()
            .toInstant()
            .atZone(java.time.ZoneId.systemDefault())
            .toLocalDate();
    stateAndCity = getRandomStateAndCity();

    firstName = fakerEn.name().firstName();
    lastName = fakerEn.name().lastName();
    userEmail = fakerEn.internet().emailAddress();
    gender = getRandomGender();
    phoneNumber = getRandomNumber(10);
    year = String.valueOf(randomDate.getYear());
    month = randomDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    day = String.format("%02d", randomDate.getDayOfMonth());
    subject = getRandomSubject();
    hobbie = getRandomHobby();
    fileName = "anna.png";
    state = stateAndCity[0];
    city = stateAndCity[1];
    currentAddress = fakerEn.address().fullAddress();
  }

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
