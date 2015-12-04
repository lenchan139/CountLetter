/*
    Programme Name:    CountLetters
    Programme Author:  Len CHAN
    Descrition:        This Programme is count the top ten letter on the string by                      
                       input string.
   Lisense:            GPL 2.0
   Warning:            Don't copy this if you are do a assignment and doing same thing, 
                       it is a cheating and will let you lost all grading  for your course.
*/


import java.util.*;
import java.lang.*;
public class CountLetters{
   public static void main(String args[]){
      String strInputMsg;
      int[] intLetterCount = new int[52];
      int[] intResult = new int[52];
      PrintHeader();
      strInputMsg = TextCollector();
      intResult = CountChar(strInputMsg,intLetterCount);
      TopsAlpha(intResult);
  }
  
   //This is a method to print the programme header.
   public static void PrintHeader(){
      //create the varibles.
      int intCounter1;
      System.out.println("");
   
      //Print the first line of *
      intCounter1 = 0;
      while (intCounter1 <= 62){
         System.out.print("*");
         intCounter1 = intCounter1 +1;
      }
      System.out.println("");
   
      //Print the Couser and name line
      System.out.println("*  IT114112 - HD in Mobile Applications Development (AY1516)  *");
      System.out.println("*  ITE3101 - Introduction to Programming                      *");
      System.out.println("*  IT114112/1B CHAN Kam Yin (150074949)                       *");
      //Print the * line again
      intCounter1 = 0;
      while (intCounter1 <= 62){
         System.out.print("*");
         intCounter1 = intCounter1 +1;
      }
   
   //Print the Descrition line
      System.out.println("");
      System.out.println("*  This program is used to count and report the top TEN most  *");
      System.out.println("*  frequenly used characters in an input text string.         *");
   
   //Print the * line again
      intCounter1 = 0;
      while (intCounter1 <= 62){
         System.out.print("*");
         intCounter1 = intCounter1 +1;
      }
      System.out.println("");
   }
   
   
   
   public static String TextCollector(){
      //create the varible for collected Strnig
      String strCollectedMsg;
      Scanner input = new Scanner(System.in);
      //Show the input hints
      System.out.println("");
      System.out.print("Enter a text string: ");
      
      //Let user input the text
      strCollectedMsg = input.nextLine();
      
      //trim the string
      strCollectedMsg = strCollectedMsg.trim();
      
      //Show the string back
      System.out.println("");
      System.out.println("Input String:");
      System.out.println("   \"" + strCollectedMsg + "\"");
      System.out.println("");
      //return the value;
      return strCollectedMsg;
   }
   
   
   
   
   //This method is for Count the char and return the result of int-array.
   public static int[] CountChar( String strInText, int[] intLetterCount){
      int intStringLength = strInText.length();
      //create the varibles. 
      int intCounterC = 0;
      char charNowAlphabet, charNowText;
      //use for loop to store times into intLetterCount[].
      for(int intCounterA = 0; intCounterA <= intStringLength - 1; intCounterA++){
         charNowText = strInText.charAt(intCounterA);
         //System.out.println("charNowText is " + charNowText); //For Debug use.
         for (int intCounterB = 0; intCounterB <= 51; intCounterB++) {
            charNowAlphabet = Alphabet(intCounterB);
            //System.out.println(charNowText + "---" + charNowAlphabet); //For debug use.
            if((charNowText == charNowAlphabet)||(intCounterC==9)){
               intLetterCount[intCounterB]++; 
                  //System.out.print("x"); //for debug use.
               }
              
         //System.out.print("*"); //for debug use.
         }
         //System.out.print("-"); //for debug use.
      }
      
      return intLetterCount;
   }
   
   
   public static void TopsAlpha( int[] intLetterCountT){
      //declare some varibles.
      int intLengthT  = intLetterCountT.length;
      int[] intTops = new int[intLengthT];
      char[] charTops = new char[intLengthT];
      int intCountResultLength = 0;
      //
      
       
       for (int i = 0; i < 10; i++){
         intTops[i] = 0;
         }
         
      for( int intCounterT = 0; intCounterT < 52; intCounterT++){
         for( int intCounterF = 0; intCounterF < 52; intCounterF++){
            //System.out.println("F Value: " + intCounterF + "  T Value: " + intCounterT); 
            
            if (intLetterCountT[intCounterF] != 0){
               if (intLetterCountT[intCounterF] > intTops[intCountResultLength]) {
                  intTops[intCountResultLength] = intLetterCountT[intCounterF];
                  intLetterCountT[intCounterF] = 0;
                  charTops[intCountResultLength] = Alphabet(intCounterF);
               }
               
               if(intLetterCountT[intCounterF] == intTops[intCountResultLength]) {
                  intCountResultLength++;
                  intTops[intCountResultLength] = intLetterCountT[intCounterF];
                  intLetterCountT[intCounterF] = 0;
                  charTops[intCountResultLength] = Alphabet(intCounterF);
               }
               intCountResultLength++;
            }
         }
      }
   
      //calculate the intTops length except zero freq.
      int intTopsLength = 0;
      for(int intCounterA1 = 0; intCounterA1 < intLengthT; intCounterA1++){
         if( intTops[intCounterA1] != 0){
            intTopsLength++;
         }
      }
      
      //sort it asc.
      for(int intCounterS1 = 0; intCounterS1 < intTopsLength;intCounterS1++){
         for( int intCounterS2 = intCounterS1 + 1; intCounterS2 < intTopsLength; intCounterS2++){
           /* if(intTops[intCounterS2] == intTops[intCounterS1]){
               intCounterS2++;
            } 
            else*/ if(intTops[intCounterS2] < intTops[intCounterS1]){
            // if(charTops[intCounterS2 + 1] != charTops[intCounterS2]){
               int intTemp;
               char charTemp;
               intTemp = intTops[intCounterS1];
               charTemp = charTops[intCounterS1];
               intTops[intCounterS1] = intTops[intCounterS2];
               charTops[intCounterS1] = charTops[intCounterS2];
               intTops[intCounterS2] = intTemp;
               charTops[intCounterS2] = charTemp;
            }
          }
      }
   //Delete all zero freq.
   int[] intTopsNew = new int[intTopsLength];
   char[] charTopsNew = new char[intTopsLength];
   for( int intCounterC1 = 0; intCounterC1 < intTopsLength; intCounterC1++){
      intTopsNew[intCounterC1] = intTops[intCounterC1];
      charTopsNew[intCounterC1] = charTops[intCounterC1];
   }

       
       //  }
         
      
   
   
   charTopsNew = reverseChar(charTopsNew);
   intTopsNew = reverseInt(intTopsNew);
   //sort it desc.
   int intCounterS2S = 1;
   int intCounterQ = 0;
   
        //only reach top10 data.
      int[] intTops10 = new int[10];
      char[] charTops10 = new char[10];
      int intLoopTimes;
      if(intTopsNew.length < 10){
         intLoopTimes = intTopsNew.length;
      }
      else{
         intLoopTimes = 10;
      }
      for(int intCounterT1 = 0;intCounterT1 < intLoopTimes; intCounterT1++){
        intTops10[intCounterT1] = intTopsNew[intCounterT1];
        charTops10[intCounterT1] = charTopsNew[intCounterT1];
      }
      
      PrintModeNormal(intTops10,charTops10,intLoopTimes);
      PrintModeBar(intTops10,charTops10,intLoopTimes);
      PrintModeColumn(intTops10,charTops10,intLoopTimes);
   }
   
   //This method is for output the data of int-array by simple mode.
   public static void PrintModeNormal(int[] intFreq, char[] charAlphabet, int intLength){
      //create varibles and count the int[] length.
      int intLengthA = intFreq.length;
      //use for loop to output message if it is not a zero freq.
      System.out.println("Top 10 letter counts (Number):");
      System.out.print("   ");
      for ( int i = 0; i < intLength; i++){
         if (i != 0){
            System.out.print(", ");
         }
         System.out.print( + intFreq[i] + "-" + charAlphabet[i]);
      }
      System.out.println("");
      System.out.println("");
      
   }
   
   public static void PrintModeBar(int[] intFreq, char[] charAlphabet, int intLength){
         //create varibles and count the int[] length.
         int intLengthA = intFreq.length;
         //use for loop to output message if it is not a zero freq.
         System.out.println("Top 10 letterCounts (Bar Chart): ");
         //print first line.
         System.out.print("    ");
         System.out.print("+"); 
         
         for(int intCounterP1 = 0; intCounterP1 <= 38; intCounterP1++){
            System.out.print("-");
         }
         
         
         //Print the main msg.
         System.out.println("");
         int intCounterV1 = 0;
         for(intCounterV1 = 0; intCounterV1 < intLength; intCounterV1++){
            System.out.print("   ");
            if(charAlphabet[intCounterV1] != 0){
            System.out.print(charAlphabet[intCounterV1] + "|");
            }

            for(int intCounterV2 = 0; intCounterV2 < intFreq[intCounterV1]; intCounterV2++){
               System.out.print("*");
            }
         System.out.println("");
         }
         //print blank line.
         for(int intCounterV7 = intCounterV1; intCounterV7 < 10; intCounterV7++){
            System.out.println("    " + "|");
         }
         
         //print last line.
         System.out.print("    ");
         System.out.print("+"); 
         
         for(int intCounterP1 = 0; intCounterP1 <= 38; intCounterP1++){
            System.out.print("-");
         }
         System.out.println("");
         System.out.println("");
   }
   
   
   public static void PrintModeColumn(int[] intFreq, char[] charAlphabet, int intLength){
      //create varibles and count the int[] length.
      int intLengthA = intFreq.length;
      //use for loop to output message if it is not a zero freq.
      System.out.println("Top 10 letterCounts (Column Chart): ");
      System.out.println("   |                     |");
         
      int intBiggerFreq = intFreq[0];
      for(int intCounterD1 = 0; intCounterD1 < intFreq[0]; intCounterD1++){
         System.out.print("   | ");

         int intCounterTT = 10;
         for(int intCounterE1 = 0; intCounterE1 < intFreq.length; intCounterE1++){
            if(intFreq[intCounterE1] >= intBiggerFreq){
               System.out.print("* ");
            }
            else{
               System.out.print("  ");
            }
            intCounterTT--;
         }
         if(intCounterTT == 0){
            System.out.print("");
         }
         else{
            if(intCounterTT > 0){
               System.out.print("");
                  while(intCounterTT > 0){
                     System.out.print("  ");
                     intCounterTT--;
                  }
               }
            }
            intBiggerFreq--;
            System.out.println("|");
      }
      //print space line.
      System.out.println("   +---------------------+");
      
      //Print the alphabet line.
      System.out.print("     ");
      for(int intCounterFF = 0; intCounterFF < 10; intCounterFF++){
         System.out.print(charAlphabet[intCounterFF] + " ");
      }
      System.out.println("");
      System.out.println("");
   }
   
   
   public static char Alphabet(int intAlphabetRequest){
      String strAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
      char[] strAlphabetOut = strAlphabet.toCharArray();
      char strOut = strAlphabetOut[intAlphabetRequest];
      return strOut;
   }


  

   public static int[] reverseInt(int[] intIn) {
      int[] intResult = new int[intIn.length];
      for (int intCounterR1 = 0; intCounterR1 < intIn.length; intCounterR1++) {
         intResult[intCounterR1] = intIn[intIn.length - 1 - intCounterR1];
    }
      return intResult;
   }
   
   
   public static char[] reverseChar(char[] charIn) {
    char[] charResult = new char[charIn.length];
    for (int intCounterR2 = 0; intCounterR2 < charIn.length; intCounterR2++) {
        charResult[intCounterR2] = charIn[charIn.length - 1 - intCounterR2];
    }
    return charResult;
   }
}  
