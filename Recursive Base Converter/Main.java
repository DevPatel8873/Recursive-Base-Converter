import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner userIn = new Scanner(System.in);
    int userNum = -1;
    int userBase = -1;
    String error = "";

    //Asks user for number to convert; repeats until number is positive; exits if 0
    while(userNum < 0)
    {
      if(userNum == 0)
      {
        break;
      }
      System.out.print(error + "Enter number to convert: ");
      userNum = userIn.nextInt();
      error = "Invalid, must be positive integer\n";
    }
    error = "";
    //Asks user for base to convert to; has to be base 2 or higher but less than 16; exits if 0 is entered
    while(userBase < 2 || userBase > 16)
    {
      if(userNum == 0 || userBase == 0)
      {
        break;
      }
      System.out.print(error + "Enter base to convert to: ");
      userBase = userIn.nextInt();
      error = "Invalid, must be positive integer greater than 1 less than 16\n";
    }

    //Only prints if 0 was not entered to avoid errors
    if(userNum != 0 && userBase != 0)
    {
      System.out.println(userNum + " converted to base " + userBase + " is " + changeBase(userNum,userBase));
    }
    else
    {
      System.out.println("Exiting");
    }
    
  }
  
  public static String changeBase(int iNum, int iBase)
  {
    //Uses Integer.toHexString in order to pull the correct letters for hex conversion from the remainders
    
    //Base case; if the number no longer divides into the base (can no longer convert)
    if(iNum / iBase == 0)
    {
        return Integer.toHexString(iNum % iBase).toUpperCase();
    }
    else
    {
      return changeBase(iNum / iBase, iBase) + Integer.toHexString(iNum % iBase).toUpperCase();
    }
  }
}



/*
Enter number to convert: 0
Exiting

Enter number to convert: 529
Enter base to convert to: 0
Exiting

Enter number to convert: -1
Invalid, must be positive integer
Enter number to convert: 456
Enter base to convert to: -1
Invalid, must be positive integer greater than 1 less than 16
Enter base to convert to: 2
456 converted to base 2 is 111001000

Enter number to convert: 529
Enter base to convert to: 18
Invalid, must be positive integer greater than 1 less than 16
Enter base to convert to: 5
529 converted to base 5 is 4104

Enter number to convert: 3456
Enter base to convert to: 16
3456 converted to base 16 is D80

Enter number to convert: 2134
Enter base to convert to: 13
2134 converted to base 13 is C82
*/