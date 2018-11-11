package ro.catalin.service;

import ro.catalin.constants.TriangleConstant;
import ro.catalin.exceptionHandler.InvalidInputException;

public class TriangleServiceImpl implements TriangleService {

    public  void createResponse(double sideA, double sideB, double sideC) throws InvalidInputException {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new InvalidInputException("Please enter a number greater than 0.");
        }
        String triangleType = determineTriangleType(sideA, sideB, sideC);
        if (triangleType.equalsIgnoreCase(TriangleConstant.INVALID)) {
            System.out.println("The input values create an invalid triangle, please note that in order to " +
                    "create a valid triangle the sum of 2 sides must be greater than the value of the biggest " +
                    "side.");
        } else {
            System.out.println("Your input values created " + triangleType + " triangle !");
        }
    }

    public String determineTriangleType(double sideA, double sideB, double sideC) {
        if (sideA >= (sideB + sideC) || sideC >= (sideB + sideA) || sideB >= (sideA + sideC)) {
            return TriangleConstant.INVALID;
        } else if (sideA == sideB && sideB == sideC) {
            return TriangleConstant.EQUILATERAL;
        } else if (sideA == sideB || sideC == sideA || sideC == sideB) {
            return TriangleConstant.ISOSCELES;
        } else {
            //if the triangle is scalene ( all the sides are different from each other) determine what type of scalene triangle it is
            return determineTypeOfScalene(sideA, sideB, sideC);
        }
    }

    public String determineTypeOfScalene(double sideA, double sideB, double sideC) {

        double aCos = (Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC);
        double aAngle = Math.toDegrees(Math.acos(aCos));

        double bCos = (Math.pow(sideC, 2) + Math.pow(sideA, 2) - Math.pow(sideB, 2)) / (2 * sideC * sideA);
        double bAngle = Math.toDegrees(Math.acos(bCos));

        double cAngle = 180 - (aAngle + bAngle);

        if (Math.round(aAngle) == 90 || Math.round(bAngle) == 90 || Math.round(cAngle) == 90) {
            return TriangleConstant.SCALENE_RIGHT;
        } else if (Math.round(aAngle) > 90 || Math.round(bAngle) > 90 || Math.round(cAngle) > 90) {
            return TriangleConstant.SCALENE_OBTUSE;
        } else {
            return TriangleConstant.SCALENE_ACUTE;
        }
    }
}
