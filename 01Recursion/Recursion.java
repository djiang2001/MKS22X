public class Recursion{

  public static int fact(int n){
    if(n < 0){
      throw new IllegalArgumentException();
    }else
      if(n == 0){
        return 1;
      }else{
        return fact(n-1) * n;
      }

  }

  public static int fib(int n){
    if(n<0){
      throw new IllegalArgumentException();
    }else
      {
        return fibHelp(n,0,1,1);
      }
  }

  public static int fibHelp(int n, int prev1,int prev2,int fib){
    if(n == 0){
      return 0;
    }else
      if(n == 1){
        return fib;
      }
      else{
        return fibHelp(n-1,prev2, prev1 + prev2, prev1 + prev2);
      }
  }

  public static double sqrt(double n){

    //    double guess = 1;
    // double pError = ((guess*guess) - n) / n;
    if(n < 0){
      throw new IllegalArgumentException();
    }else
      if(n == 0){
        return 0;
      }else{
       return sqrtHelp(n,1);
          }
  }

  public static double sqrtHelp(double n, double guess){
    if(Math.abs(((guess*guess)-n)/n) < 0.0000001){
      return guess;
        }else{
      return sqrtHelp(n,(n/guess + guess)/2);
    }
}

  public static void main(String[]args){
    System.out.println(fact(0));
    System.out.println(fact(1));
    //System.out.println(fact(-2));
    System.out.println(fact(5));

    System.out.println(fib(0));
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(3));
    System.out.println(fib(4));
    System.out.println(fib(5));

    System.out.println(sqrt(0));
    System.out.println(sqrt(1));
        System.out.println(sqrt(4));
            System.out.println(sqrt(5));
                System.out.println(sqrt(10));
                    System.out.println(sqrt(16));
  }
}
