package qa.msl.testdata;

import com.github.javafaker.Faker;
import qa.msl.enums.Gender;
import qa.msl.enums.Hobby;
import qa.msl.enums.StateAndCity;
import qa.msl.enums.Subject;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class TestDataFaker {
  private final Locale localeEn = new Locale.Builder()
          .setLanguage("en")
          .setRegion("US")
          .build();
  private final Locale localeRu = new Locale.Builder()
          .setLanguage("ru")
          .build();
  private final Faker fakerEn = new Faker(localeEn);
  private final Faker fakerRu = new Faker(localeRu);

  private final LocalDate randomDate = fakerEn.date()
          .birthday()
          .toInstant()
          .atZone(java.time.ZoneId.systemDefault())
          .toLocalDate();
  private final StateAndCity randomStateAndCity = fakerEn.options().option(StateAndCity.class);

  public String firstName = fakerRu.name().firstName();
  public String lastName = fakerRu.name().lastName();
  public String userEmail = fakerEn.internet().emailAddress();
  public String gender = fakerEn.options().option(Gender.class).getDisplayName();
  public String phoneNumber = fakerEn.phoneNumber().subscriberNumber(10);
  public String year = String.valueOf(randomDate.getYear());
  public String month = randomDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
  public String day = String.format("%02d", randomDate.getDayOfMonth());
  public String subject = fakerEn.options().option(Subject.class).getDisplayName();
  public String hobbie = fakerEn.options().option(Hobby.class).getDisplayName();
  public String imgName = "anna.png";
  public String state = randomStateAndCity.getState();
  public String city = randomStateAndCity.getRandomCity();
  public String currentAddress = fakerEn.address().fullAddress();

}
