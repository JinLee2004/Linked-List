import java.util.*;

public class Menu 
{
    public static void main(String [] args)
    {
        LinkedList linkedList = new LinkedList();
        boolean menu = true;
        int userInput, userInt;
        String insertNum = "Please select an integer to insert: ";
        try
        {
            // Menu system that allows users to input numbers to make selections
            while (menu == true)
            {
                String prompt = "Please make a selection out of the following options: " + "\n" +
                            "> 1. Insert First" + "\n" +
                            "> 2. Insert Last" + "\n" +
                            "> 3. Remove First" + "\n" +
                            "> 4. Remove Last" + "\n" +
                            "> 5. Display the List" + "\n" + 
                            "> 6. Close program" + "\n";
                userInput = inputInt(prompt, 1, 6);
                // Integer inserted as Object into the Linked List for modularity
                if (userInput == 1)
                {
                    userInt = inputInt(insertNum, -1000000000, 1000000000);
                    linkedList.insertFirst(userInt);
                }
                else if (userInput == 2)
                {
                    userInt = inputInt(insertNum, -1000000000, 1000000000);
                    linkedList.insertLast(userInt);
                }
                else if (userInput == 3)
                {
                    if (linkedList.isEmpty())
                    {
                        System.out.println("The linked list is empty. There is nothing to remove");
                    }
                    else
                    {
                        System.out.println("Number removed from front of list " + linkedList.removeFirst());
                    }
                }
                else if (userInput == 4)
                {
                    if (linkedList.isEmpty())
                    {
                        System.out.println("The linked list is empty. There is nothing to remove");
                    }
                    else
                    {
                        System.out.println("Number removed from front of list " + linkedList.removeLast());
                    }
                }
                else if (userInput == 5)
                {
                    if (linkedList.isEmpty())
                    {
                        System.out.println("The linked list is empty. There is no elements in the list");
                    }
                    else
                    {
                        linkedList.printAllElements();
                    }
                }
                else if (userInput == 6)
                {
                    menu = false;
                }
            }
        }
        catch (IllegalStateException e)
        {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }                       
    
    
    public static int inputInt(String prompt, int min, int max)
    {
        Scanner input = new Scanner(System.in);
        int userInput = min - 1;
        String errorString = "Please enter an integer between " + min + " and " + max + "\n";
        String outString = prompt; 
        do
        {
        try
        {
            System.out.print(outString); // If user input is invalid will ask user to print a valid integer
            outString = errorString + prompt;
            userInput = input.nextInt();
        }
        catch (InputMismatchException error) // Catches error if user inputs a non integer value
        {
            input.nextLine(); // Clears input buffer by consuming "\n" character
        }
        }while(userInput < min || userInput > max); // Ensures that the userInput returned is a valid integer
        return userInput;
    }
}