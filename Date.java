public class Date {
  //declare variables privately
  private int m;
  private int d;
  private int y;

  //set the date in the object
  public void setDate(int m, int d, int y){
    this.m = m;
    this.d = d;
    this.y = y;
  }

  //methods to retrieve data in object
  public int getDay(){
    return d;
  }

  public int getMonth(){
    return m;
  }

  public int getYear(){
    return y;
  }

  //method to create a string that declares the date
  public String displayMessage(int m, int d, int y){
    String msg = "The date is " + m + "/"+d+"/"+y+".";
    return msg;
  }
}
