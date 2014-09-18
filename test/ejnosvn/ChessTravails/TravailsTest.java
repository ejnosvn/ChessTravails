package ejnosvn.ChessTravails;

import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TravailsTest {
	Travails rookTravails, knightTravails;
	
    //@BeforeClass
	@BeforeMethod
    public void init() {
        //System.out.println("@BeforeClass: The annotated method will be run before the first test method in the current class is invoked.");
		System.out.println("@BeforeMethod: The annotated method will be run before the each test method in the current class is invoked.");
        System.out.println("init service");
        rookTravails = new RookTravails();
        knightTravails = new KnightTravails();
    }

    @Test(dataProvider = "testDatas1")
    public void testRookTravails(String[][] a) {
        System.out.println("@Test : rookTravails()");
        String[] result = rookTravails.solve(a[0]);
        Assert.assertEquals(result, a[1]);
    }

    @DataProvider
    public Object[][] testDatas1() {
    	//test_RookOneSteps
    	String[][] e1 = { {"A2", "A7"}, {"A7"} };

    	//test_RookTwoSteps1
    	String[][] e2 = { {"A2", "B7"}, {"A7", "B7"} };

    	//test_RookTwoSteps2
    	String[][] e3 = { {"A2", "C7"}, {"A7", "C7"} };

    	//test_RookOneStepWithOneBlocking
    	String[][] e4 = { {"A2", "A7", "A5"}, {"B2", "B7", "A7"} };

    	//test_RookOneStepWithAllBlocking
    	String[][] e5 = { {"A2", "A7", "A6", "B6", "B7", "B8", "A8"}, null };

    	//test_RookOneStepWithAllBlockingWithUnreachableField
    	//	pl sotet futo nem lephet vilagos celba, rossz lesz a feltetel, nem minden field kiertekelheto
    	String[][] e6 = { {"A2", "G5", "F4", "F5", "F6", "F7", "G4", "G7", "H4", "H5", "H6", "H7"}, null };
        return new Object[][] { {e1}, {e2}, {e3}, {e4}, {e5}, {e6} };
    }

    @Test(dataProvider = "testDatas2")
    public void testKnightTravails(String[][] a) {
        System.out.println("@Test : knightTravails()");
        String[] result = knightTravails.solve(a[0]);
        Assert.assertEquals(result, a[1]);
    }

    //todo kene lo meg futo is, konfigolhato modon
    @DataProvider
    public Object[][] testDatas2() {
    	//test_KnightOneSteps
    	String[][] e1 = { {"A2", "B4"}, {"B4"} };

    	//test_KnightTwoSteps1
    	String[][] e2 = { {"A2", "C6"}, {"B4", "C6"} };
//
//    	//test_RookTwoSteps2
//    	String[][] e3 = { {"A2", "C7"}, {"A7", "C7"} };
//
//    	//test_RookOneStepWithOneBlocking
//    	String[][] e4 = { {"A2", "A7", "A5"}, {"B2", "B7", "A7"} };
//
//    	//test_RookOneStepWithAllBlocking
//    	String[][] e5 = { {"A2", "A7", "A6", "B6", "B7", "B8", "A8"}, null };
//
//    	//test_RookOneStepWithAllBlockingWithUnreachableField
//    	//	pl sotet futo nem lephet vilagos celba, rossz lesz a feltetel, nem minden field kiertekelheto
//    	String[][] e6 = { {"A2", "G5", "F4", "F5", "F6", "F7", "G4", "G7", "H4", "H5", "H6", "H7"}, null };
//      return new Object[][] { {e1}, {e2}, {e3}, {e4}, {e5}, {e6} };
        return new Object[][] { {e1}, {e2} };
    }
}
