import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{
  private int currentIndex;
  private int [] data;

  public ArraySequence(int [] other){
    data = new int[other.length];
    for(int i = 0; i < other.length; i++){
      data[i] = other[i];
    }
  }

  public ArraySequence(IntegerSequence otherseq){
    otherseq.reset();
    data = new int[otherseq.length()];
    for(int i = 0; i < otherseq.length(); i++){
      data[i] = otherseq.next();
    }
  }

  public void reset(){
    currentIndex = 0;
  }
  public int length(){
    return data.length;
  }
  public boolean hasNext(){
    if(currentIndex >= 0 && currentIndex < data.length){
      return true;
    }
    return false;
  }

  public int next(){
    if(hasNext() == false){
      throw new NoSuchElementException(currentIndex + " is not in array " + data.toString());
    }
    int temp = data[currentIndex];
    currentIndex ++;
    return temp;
  }

}
