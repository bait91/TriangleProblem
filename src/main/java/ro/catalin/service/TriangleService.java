package ro.catalin.service;

import ro.catalin.exceptionHandler.InvalidInputException;

public interface TriangleService {
    /**
     * Creates the response based on the users input
     * @param sideA side of the triangle
     * @param sideB side of the triangle
     * @param sideC side of the triangle
     * @throws InvalidInputException this error is thrown when the input is invalid
     * when its not a number or the number is smaller than 0
     */
    void createResponse(double sideA, double sideB, double sideC) throws InvalidInputException;

    /**
     * Gets the main type of the triangle based on the users input can be Isosceles, Equilateral, Scalene
     * @param sideA side of the triangle
     * @param sideB side of the triangle
     * @param sideC side of the triangle
     */
    String determineTriangleType(double sideA, double sideB, double sideC);

    /**
     * Gets the type of scalene triangle, there are 3 types Right, Obtuse, Acute
     * @param sideA side of the triangle
     * @param sideB side of the triangle
     * @param sideC side of the triangle
     */
    String determineTypeOfScalene(double sideA, double sideB, double sideC);

}
