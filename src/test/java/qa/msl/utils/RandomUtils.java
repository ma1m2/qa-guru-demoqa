package qa.msl.utils;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {
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
  public static String getRandomString(int lengthStr) {
    String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";//0123456789
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
    String[] genders = {"Male", "Female", "Other"};
   return getRandomItemFromStringArray(genders);
  }

  public static String getRandomItemFromStringArray(String[] stringArray) {
    int randomIndex = getRandomInt(0, stringArray.length - 1);
    return stringArray[randomIndex];
  }
}
