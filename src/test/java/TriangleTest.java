import org.testng.Assert;
import org.testng.annotations.Test;
import ro.catalin.Triangle;
import ro.catalin.exceptionHandler.InvalidInputException;

public class TriangleTest {

    private double sideA;
    private double sideB;
    private double sideC;


    @Test(expectedExceptions = InvalidInputException.class)
    public void verifyError() throws InvalidInputException {

        sideA = -1;
        sideB = 0;
        sideC = 0;

        Triangle.createResponse(sideA, sideB, sideC);

    }

    @Test
    public void verifyInvalid() throws InvalidInputException {

        sideA = -1;
        sideB = 0;
        sideC = 0;

        String triangleType = Triangle.determineTriangleType(sideA, sideB, sideC);

        Assert.assertEquals(triangleType, Triangle.INVALID);

    }

    @Test
    public void verifyEquilateral() {

        sideA = 5.22;
        sideB = 5.22;
        sideC = 5.22;

        String triangleType = Triangle.determineTriangleType(sideA, sideB, sideC);

        Assert.assertEquals(triangleType, Triangle.EQUILATERAL);

    }

    @Test
    public void verifyIsosceles() {

        sideA = 5.22;
        sideB = 4;
        sideC = 5.22;

        String triangleType = Triangle.determineTriangleType(sideA, sideB, sideC);

        Assert.assertEquals(triangleType, Triangle.ISOSCELES);

    }

    @Test
    public void verifyAcuteScalene() {

        sideA = 5.22;
        sideB = 4;
        sideC = 6.22;

        String triangleType = Triangle.determineTypeOfScalene(sideA, sideB, sideC);

        Assert.assertEquals(triangleType, Triangle.SCALENE_ACUTE);

    }

    @Test
    public void verifyObtuseScalene() {

        sideA = 5.22;
        sideB = 4.22;
        sideC = 7;

        String triangleType = Triangle.determineTypeOfScalene(sideA, sideB, sideC);

        Assert.assertEquals(triangleType, Triangle.SCALENE_OBTUSE);

    }

    @Test
    public void verifyRightScalene() {

        sideA = 3;
        sideB = 4;
        sideC = 5;

        String triangleType = Triangle.determineTypeOfScalene(sideA, sideB, sideC);

        Assert.assertEquals(triangleType, Triangle.SCALENE_RIGHT);

    }
}
