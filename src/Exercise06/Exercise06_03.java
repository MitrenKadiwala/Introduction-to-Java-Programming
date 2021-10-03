package Exercise06;

import java.util.ArrayList;
import java.util.Scanner;

/* 
*
*
*@author: MITREN KADIWALA (20CS021)
*email : 20CS021@charusat.edu.in
*********************************************************************************************************************************
*(Count occurrence of numbers) Write a program that reads the integers between 1and 100 and counts the occurrences of each. 
*Assume the input ends with 0.
*Here is a sample run of the program:
*Enter the integers between 1 and 100: 2 5 6 5 4 3 23 43 2 0
*2 occurs 2 times
*3 occurs 1 time
*4 occurs 1 time
*5 occurs 2 times
*6 occurs 1 time
*23 occurs 1 time
*43 occurs 1 time
*********************************************************************************************************************************
*
*
*
*
*
*/

class CountOccurence {
    // arrayList to store the input of the numbers from users
    private ArrayList<Integer> numbers = new ArrayList<>();

    // Scanner class for taking input from users
    Scanner sc = new Scanner(System.in);

    // The method which takes input form users
    private int inputNumbers() {

        // Temporarily stores the number taken as input
        int numTemp = 0;

        System.out.print("Enter the integers between 1 and 100: ");
        // do-while loop to take input based on given conditions !!
        do {
            numTemp = 0;
            numTemp = sc.nextInt();

            // Adding the numbers to the arrayList
            numbers.add(numTemp);

            // Checking whether the input is out of limit (1-100)
            int checkNumber = 0;
            checkNumber = OutOfLimitCheck(numTemp);

            // 1 determines false here
            if (checkNumber == 1) {

                // Removes the element which is out of limit
                removeLastNumber();

            } else {

                int lastNum = 0;
                lastNum = LastNumber(numTemp);

                // 10 determines false here
                if (lastNum == 10) {

                    // Removes the element as 0 should be excluded from the arrayList
                    removeLastNumber();

                    // Calling method for counting numbers
                    countNumbers();
                    return 10;
                }
            }

        } while (true);

    }

    // Method which checks whether the input is in the limit
    private int OutOfLimitCheck(int num) {
        if (num < 0 || num > 100) {
            System.out.println("The Entered number is out of the specified limit");
            return 1;
        }
        return 0;
    }

    // Logic to break the loop if 0 is entered as the number
    private int LastNumber(int last) {

        if (last == 0) {
            return 10;
        }
        return 0;

    }

    private void countNumbers() {
        // Looping variables
        int i = 0, j = 0;

        // For iterating the elements of trimmed numberlist
        int z = 0;

        // Counter variable
        int cnt = 0;

        // For making the output look formatted
        System.out.println("\n\n");

        // Clones the original array
        ArrayList<Integer> repNums = new ArrayList<>();
        repNums = (ArrayList) numbers.clone();

        // Remove the repeated numbers
        ArrayList<Integer> noRepeatNum = new ArrayList<>();
        noRepeatNum = removeRepeatedNumbers(repNums);

        // Logic for counting the array elements if they are repeating
        for (i = 0; i < numbers.size(); i++) {
            cnt = 0;
            for (j = 0; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    cnt++;
                }
            }

            if (cnt == 1) {

                // To prevent the looping variable i to fall out of bound for trimmed arrayList
                if (z < noRepeatNum.size()) {
                    if (numbers.get(i) == noRepeatNum.get(z)) {
                        System.out.println(numbers.get(i) + " occurs " + cnt + " time");
                        z++;
                    }

                }
            } else {

                // To prevent the looping variable i to fall out of bound for trimmed ArrayList
                if (z < noRepeatNum.size()) {
                    if (numbers.get(i) == noRepeatNum.get(z)) {
                        System.out.println(numbers.get(i) + " occurs " + cnt + " times");
                        z++;

                    }
                }
            }
        }
    }

    // Removes repeated numbers
    private ArrayList<Integer> removeRepeatedNumbers(ArrayList<Integer> repNum) {
        ArrayList<Integer> repeatedNum = new ArrayList<>();

        // Loop to remove duplicate items
        for (int element : repNum) {

            // If this element is not present in newList
            // then add it
            if (!repeatedNum.contains(element)) {

                repeatedNum.add(element);
            }
        }

        return repeatedNum;
    }

    // Removes the last number
    private void removeLastNumber() {
        int size = 0;
        size = numbers.size();
        numbers.remove(size - 1);
    }

    public void callOtherFunction() {
        // Calling inputNumbers function
        inputNumbers();
    }

}

public class Exercise06_03 {
    // main method
    public static void main(String[] args) {
        // Creating the object of class CountOccurence

        CountOccurence numberList1 = new CountOccurence();
        numberList1.callOtherFunction();
    }
}
