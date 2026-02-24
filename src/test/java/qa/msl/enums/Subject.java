package qa.msl.enums;

public enum Subject {
  MATHS("Maths"),
  PHYSICS("Physics"),
  CHEMISTRY("Chemistry"),
  SOCIAL_STUDIES("Social Studies"),
  ENGLISH("English");

  private final String displayName;

  Subject(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }
}
