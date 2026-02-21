package qa.msl.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrangeActAssertTest {

  @Test
  public void verifySum(){
    //Arrange  / Given
    int a = 2;
    int b = 3;
    int expectedResult = 5;

    //Act      / When
    int actualResult = a + b;

    //Assert   / Then
    assertEquals(expectedResult, actualResult);
  }
}
