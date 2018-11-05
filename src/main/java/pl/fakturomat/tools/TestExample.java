package pl.fakturomat.tools;

class TestExample {
  private int leftBound;
  private int rightBound;

  boolean isInRange(int value){
    return leftBound <= value && value <= rightBound;
  }

  TestExample(int leftBound, int rightBound) {
    this.leftBound = leftBound;
    this.rightBound = rightBound;
  }
}
