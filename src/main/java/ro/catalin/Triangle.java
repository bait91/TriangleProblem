package ro.catalin;

import ro.catalin.exceptionHandler.InvalidInputException;

import java.util.Scanner;

public class Triangle {

    //types of triangles
    private enum TriangleType {
        isosceles,
        equilateral,
        scaleneRight,
        scaleneObtuse,
        scaleneAcute,
        invalid
    }

    public static void main(String[] args) throws InvalidInputException {
        int sideA;
        int sideB;
        int sideC;
        //users input
        Scanner sc = new Scanner(System.in);
        try {
            sideA = sc.nextInt();
            sideB = sc.nextInt();
            sideC = sc.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException("Please enter a valid number in order to continue");
        }

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new InvalidInputException("Please enter a valid number in order to continue");
        }

        String triangleType = String.valueOf(determineTriangleType(sideA, sideB, sideC));

        if (triangleType.equalsIgnoreCase("invalid")) {
            System.out.println("The input values create an invalid triangle, please note that in order to " +
                    "create a valid triangle the sum of 2 sides must be greater than the value of the biggest " +
                    "side.");

        } else {
            System.out.println("Your input values created an " + triangleType + " triangle !");
        }


    }

    private static TriangleType determineTriangleType(int sideA, int sideB, int sideC) {
        if (sideA >= (sideB + sideC) || sideC >= (sideB + sideA) || sideB >= (sideA + sideC)) {
            return TriangleType.invalid;

        } else if (sideA == sideB && sideB == sideC) {
            return TriangleType.equilateral;

        } else if ((sideA == sideB && sideB != sideC) || (sideA != sideB && sideC == sideA) || (sideC == sideB && sideC != sideA)) {
            return TriangleType.isosceles;

        } else if (sideA != sideB && sideB != sideC && sideC != sideA) {
            //if the triangle is scalene ( all the sides are different from each other) determine what type of scalene triangle it is
            return determineTypeOfScalene(sideA, sideB, sideC);
        }
        return TriangleType.invalid;
    }

    private static TriangleType determineTypeOfScalene(int sideA, int sideB, int sideC) {

        double aCos = (Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC);
        double aValue = Math.toDegrees(Math.acos(aCos));

        double bCos = (Math.pow(sideC, 2) + Math.pow(sideA, 2) - Math.pow(sideB, 2)) / (2 * sideC * sideA);
        double bValue = Math.toDegrees(Math.acos(bCos));

        double cValue = 180 - (aValue + bValue);

        if (Math.round(aValue) == 90 || Math.round(bValue) == 90 || Math.round(cValue) == 90) {
            return TriangleType.scaleneRight;
        } else if (Math.round(aValue) > 90 || Math.round(bValue) > 90 || Math.round(cValue) > 90) {
            return TriangleType.scaleneObtuse;
        } else {
            return TriangleType.scaleneAcute;
        }
    }
}
