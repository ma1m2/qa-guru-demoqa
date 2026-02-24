package qa.msl.examples;

//import net.datafaker.Faker;
import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerExample {

  public static void main(String[] args) {
    Locale locale = new Locale.Builder()
            .setLanguage("en")
            .setRegion("US")
            .build();
    Faker faker = new Faker(locale);
    String userName = faker.name().name();
    String userEmail = faker.internet().emailAddress();
    System.out.println(userName);
    System.out.println(userEmail);
  }
}
