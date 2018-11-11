import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.catalin.Triangle;
import ro.catalin.exceptionHandler.InvalidInputException;

public class TriangleTest {

    @DataProvider(name = "triangleTypeDataProvider")
    public Object[][] triangleType() {
        return new Object[][]{
                {33, 2, 6, Triangle.INVALID},
                {5.22, 5.22, 5.22, Triangle.EQUILATERAL},
                {5.22, 4, 5.22, Triangle.ISOSCELES}};
    }

    @DataProvider(name = "scaleneTypeDataProvider")
    public Object[][] scaleneType() {
        return new Object[][]{
                {5.22, 4, 6.22, Triangle.SCALENE_ACUTE},
                {5.22, 4.22, 7, Triangle.SCALENE_OBTUSE},
                {3, 4, 5, Triangle.SCALENE_RIGHT}};
    }


    @Test(expectedExceptions = InvalidInputException.class)
    public void verifyError() throws InvalidInputException {

        double sideA = -1;
        double sideB = 0;
        double sideC = 0;

        Triangle.createResponse(sideA, sideB, sideC);

    }

    @Test(dataProvider = "triangleTypeDataProvider")
    public void verifyInvalid(double sideA, double sideB, double sideC, String triangleData) {
        String triangleType = Triangle.determineTriangleType(sideA, sideB, sideC);
        System.out.println("Looking for " + triangleData + " and got " + triangleType);
        Assert.assertEquals(triangleType, triangleData);

    }


    @Test(dataProvider = "scaleneTypeDataProvider")
    public void verifyAcuteScalene(double sideA, double sideB, double sideC,  String triangleData) {
        String triangleType = Triangle.determineTypeOfScalene(sideA, sideB, sideC);
        System.out.println("Looking for " + triangleData + " and got " + triangleType);
        Assert.assertEquals(triangleType, triangleData);

    }


}
