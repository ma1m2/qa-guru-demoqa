package qa.msl.utils;

import com.github.javafaker.Faker;
import qa.msl.enums.Gender;
import qa.msl.enums.Hobby;
import qa.msl.enums.StateAndCity;
import qa.msl.enums.Subject;

import java.util.Locale;

public class RandomUtils {

  static Locale localeEn = new Locale.Builder()
          .setLanguage("en")
          .setRegion("US")
          .build();
  static Locale localeRu = new Locale.Builder()
          .setLanguage("ru")
          .build();
  public static Faker fakerEn = new Faker(localeEn);
  public static Faker fakerRu = new Faker(localeRu);

  public static String getRandomGender() {
    Gender randomGender = fakerEn.options().option(Gender.class);
    return randomGender.getDisplayName();
  }

  public static String getRandomHobby() {
    Hobby randomHobby = fakerEn.options().option(Hobby.class);
    return randomHobby.getDisplayName();
  }

  public static String getRandomSubject() {
    Subject randomSubject = fakerEn.options().option(Subject.class);
    return randomSubject.getDisplayName();
  }

  public static String[] getRandomStateAndCity() {
    StateAndCity randomStateAndCity = fakerEn.options().option(StateAndCity.class);
    String[] results = new String[2];
    results[0] = randomStateAndCity.getState();
    results[1] = randomStateAndCity.getRandomCity();
    return results;
  }

}
