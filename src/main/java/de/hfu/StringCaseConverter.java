package de.hfu;
public class StringCaseConverter {

    public static void main(String[] args) {

        System.out.println("Enter lowerString");
        String lowerString = new java.util.Scanner(System.in).nextLine();

        String upperString = lowerString.toUpperCase(); // Convert lower String to upper String
        System.out.println("upperString is: \n" + upperString); // Output upper String
            }
}
