package ro.catalin;

import ro.catalin.exceptionHandler.InvalidInputException;
import ro.catalin.service.TriangleService;
import ro.catalin.service.TriangleServiceImpl;

import java.util.Scanner;

public class Triangle {

    private static TriangleService triangleService = new TriangleServiceImpl();

    public static void main(String[] args) throws InvalidInputException {
        double sideA;
        double sideB;
        double sideC;
        //users input
        Scanner sc = new Scanner(System.in);
        try {
            sideA = sc.nextDouble();
            sideB = sc.nextDouble();
            sideC = sc.nextDouble();
        } catch (Exception e) {
            throw new InvalidInputException("Please enter a valid number.");
        }
        triangleService.createResponse(sideA, sideB, sideC);
    }


}
