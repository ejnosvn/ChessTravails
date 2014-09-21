package ejnosvn.ChessTravails;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TravailsTest {
	Travails rookTravails, knightTravails;
	
	@BeforeMethod
    public void init() {
        rookTravails = new RookTravails();
        knightTravails = new KnightTravails();
    }

    @Test(dataProvider = "testDatas_RookMoves")
    public void testRookTravails(String[][] a) {
        String[] result = rookTravails.solve(a[0]);
        Assert.assertEquals(result, a[1]);
    }

    @DataProvider
    public Object[][] testDatas_RookMoves() {
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
    	String[][] e6 = { {"A2", "G5", "F4", "F5", "F6", "F7", "G4", "G7", "H4", "H5", "H6", "H7"}, null };
        return new Object[][] { {e1}, {e2}, {e3}, {e4}, {e5}, {e6} };
    }

    @Test(dataProvider = "testDatas_KnightMoves")
    public void testKnightTravails(String[][] a) {
        String[] result = knightTravails.solve(a[0]);
        Assert.assertEquals(result, a[1]);
    }

    //todo kene meg futo is
    @DataProvider
    public Object[][] testDatas_KnightMoves() {
    	//test_KnightOneSteps
    	String[][] e1 = { {"A2", "B4"}, {"B4"} };

    	//test_KnightTwoSteps1
    	String[][] e2 = { {"A2", "C6"}, {"B4", "C6"} };

    	//test_KnightOneStepWithOneBlocking
    	String[][] e3 = { {"A2", "C6", "B4"}, {"C1", "B3", "A5", "C6"} };

    	//test_KnightOneStepWithAllBlocking
    	String[][] e4 = { {"A2", "A8", "A6", "A7", "B6", "B7", "B8", "C6", "C7", "C8"}, null };

    	//test_RookOneStepWithAllBlockingWithUnreachableField
    	String[][] e5 = { {"A2", "A8", "A6", "A7", "B6", "B7", "C6", "C7", "C8", "D6", "D7", "D8"}, null };
        return new Object[][] { {e1}, {e2}, {e3}, {e4}, {e5} };
    }
}
