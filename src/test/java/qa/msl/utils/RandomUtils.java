package qa.msl.utils;

import qa.msl.enums.Gender;
import qa.msl.enums.Hobby;
import qa.msl.enums.StateAndCity;
import qa.msl.enums.Subject;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

/**
 * Math.random() синхронизирован, то есть безопасен для многопоточного использования
 * Math.random() в диапазоне от 0.0 (включительно) до 1.0 (не включая 1.0)
 * chars.length() = 62
 * Когда умножаем Math.random() на 62, получаем число в диапазоне:
 * 0.0 ≤ Math.random() * 62 < 62.0
 * (int)(Math.random() * 62) — отбрасывает дробную часть, оставляя только целую.
 * Теперь диапазон: 0 ≤ (int)(Math.random() * 62) ≤ 61
 *
 * Вместо статического метода Math.random() юзать
 * Random rnd = new Random();
 * rnd.nextFloat() - результат будет тот же
 *
 * int randomInt = ThreadLocalRandom.current().nextInt(1, 101); // От 1 до 100
 */
public class RandomUtils {

  public static String getRandomString(int lengthStr) {
    String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder(lengthStr);
    for (int i = 0; i < lengthStr; i++) {
      sb.append(LETTERS.charAt((int)(Math.random() * LETTERS.length())));
    }
    return sb.toString();
  }

  public static String getRandomNumber(int lengthNum) {
    String NUMBERS = "0123456789";
    StringBuilder sb = new StringBuilder(lengthNum);
    for (int i = 0; i < lengthNum; i++) {
      sb.append(NUMBERS.charAt((int)(Math.random() * NUMBERS.length())));
    }
    return sb.toString();
  }

  public static int getRandomInt(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public static String getRandomEmail() {
    return (format("%s@%s.com",getRandomString(8),getRandomString(4))).toLowerCase();
  }

  public static String getRandomEmail(String host) {
    return (format("%s@%s",getRandomString(8),host)).toLowerCase();
  }

  public static String getPhoneFormat() {
    return getPhoneFormat(getRandomNumber(1));
  }

  public static String getPhoneFormat(String countryCode) {
    String phoneTemplate = "+%s (%s) %s - %s - %s";
    return (format(phoneTemplate, countryCode,
            getRandomNumber(3),
            getRandomNumber(3),
            getRandomNumber(2),
            getRandomNumber(2)));
  }

  public static String getRandomGender() {
    Gender[] genders = Gender.values();
    Gender randomGender = getRandomItemFromArray(genders);
    return randomGender.getDisplayName();
  }

  public static String getRandomHobby() {
    Hobby[] hobbies = Hobby.values();
    Hobby randomHobby = getRandomItemFromArray(hobbies);
    return randomHobby.getDisplayName();
  }

  public static String getRandomSubject() {
    Subject[] hobbies = Subject.values();
    Subject randomSubject = getRandomItemFromArray(hobbies);
    return randomSubject.getDisplayName();
  }

  public static String[] getRandomStateAndCity() {
    StateAndCity[] states = StateAndCity.values();
    StateAndCity randomState = getRandomItemFromArray(states);

    String[] results = new String[2];
    results[0] = randomState.getState();
    results[1] = randomState.getRandomCity();
    return results;
  }

  private static <T> T getRandomItemFromArray(T[] array) {
    int randomIndex = getRandomInt(0, array.length - 1);
    return array[randomIndex];
  }

}
