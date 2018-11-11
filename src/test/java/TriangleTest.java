import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ro.catalin.constants.TriangleConstant;
import ro.catalin.exceptionHandler.InvalidInputException;
import ro.catalin.service.TriangleService;
import ro.catalin.service.TriangleServiceImpl;

public class TriangleTest {
    private TriangleService triangleService = new TriangleServiceImpl();

    @DataProvider(name = "triangleTypeDataProvider")
    public Object[][] triangleType() {
        return new Object[][]{
                {33, 2, 6, TriangleConstant.INVALID},
                {5.22, 5.22, 5.22, TriangleConstant.EQUILATERAL},
                {5.22, 4, 5.22, TriangleConstant.ISOSCELES}};
    }

    @DataProvider(name = "scaleneTypeDataProvider")
    public Object[][] scaleneType() {
        return new Object[][]{
                {5.22, 4, 6.22, TriangleConstant.SCALENE_ACUTE},
                {5.22, 4.22, 7, TriangleConstant.SCALENE_OBTUSE},
                {3, 4, 5, TriangleConstant.SCALENE_RIGHT}};
    }


    @Test(expectedExceptions = InvalidInputException.class)
    public void verifyError() throws InvalidInputException {

        double sideA = -1;
        double sideB = 0;
        double sideC = 0;

        triangleService.createResponse(sideA, sideB, sideC);

    }

    @Test(dataProvider = "triangleTypeDataProvider")
    public void verifyInvalid(double sideA, double sideB, double sideC, String triangleData) {
        String triangleType = triangleService.determineTriangleType(sideA, sideB, sideC);
        System.out.println("Looking for " + triangleData + " and got " + triangleType);
        Assert.assertEquals(triangleType, triangleData);

    }


    @Test(dataProvider = "scaleneTypeDataProvider")
    public void verifyAcuteScalene(double sideA, double sideB, double sideC,  String triangleData) {
        String triangleType = triangleService.determineTypeOfScalene(sideA, sideB, sideC);
        System.out.println("Looking for " + triangleData + " and got " + triangleType);
        Assert.assertEquals(triangleType, triangleData);

    }


}
