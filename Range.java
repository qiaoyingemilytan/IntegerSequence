import java.util.NoSuchElementException;
public class Range implements IntegerSequence{
  private int start,end,current;

  //@param start : the starting value (inclusive) which must be <= end.
  //@param end : the ending value which is also inclusive.
  public Range(int start, int end){
    this.start = start;
    this.end = end;
    current = this.start;
    if(start > end){
      throw new IllegalArgumentException("Start must be less than end");
    }
  }

  public void reset(){
    current = start;
  }
  public int length(){
    return end - start + 1;
  }

  //When current is no longer a valid element in the range, it should return false.
  public boolean hasNext(){
    if(current >= start && current <= end){
      return true;
    }
    return false;
  }

  //@throws NoSuchElementException when hasNext() is false.
  //This will return the current value, it will also increase current value by 1.
  //e.g.  if current is 5. This will make current 6, and return 5.
  public int next(){
    if(hasNext() == false){
      throw new NoSuchElementException(current + " is not in range of " + start + " - " + end);
    }
    int temp = current;
    current ++;
    return temp;
  }

}
