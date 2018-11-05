package pl.fakturomat.tools;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestExempleTest {
  private TestExample testExample;

  @Before
  public void init(){
    testExample =new TestExample(10,20);
  }

  @Test
  public void isInRange() {
    assertTrue(testExample.isInRange(15));

  }
}