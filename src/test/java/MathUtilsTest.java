import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest extends Object {
    MathUtils mathUtils;
    @BeforeAll
    void startBeforAll(){ //have it be static or use instance per class method
        System.out.println("runs before ");
    }

    @BeforeEach //initialize before each test;life cycle hook annotation
    void initialize(){
         mathUtils = new MathUtils();

    }

    @Test
    void testAddPositive(){
//        System.out.println("this test ran");
//        MathUtils mathUtils = new MathUtils(); //don't repeat yourself
        int expected  =2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual);
    }

    @Test
    void testDivide(){
//        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class,() -> mathUtils.divide(1,0),"throw exception in denominator is zero");
    }

    @Nested
    class AddTest{
        @Test
        @DisplayName("Testing add method for + ")
        void testAddPositive(){
//        System.out.println("this test ran");
//        MathUtils mathUtils = new MathUtils(); //don't repeat yourself
            int expected  =2;
            int actual = mathUtils.add(1,1);
            assertEquals(expected,actual);
        }

        @Test
        @DisplayName("Testing add method for - ")
        void testAddNegative(){
//        System.out.println("this test ran");
//        MathUtils mathUtils = new MathUtils(); //don't repeat yourself
//            int expected  =2;
//            int actual = mathUtils.add(-3,1);
            assertEquals(-2,mathUtils.add(-3,1));
        }
    }

    @Test
    @DisplayName(" multiplication numbers")
    void testMultiply(){
        assertAll(
                () -> assertEquals(4,mathUtils.multiply(2,2)),
                () -> assertEquals(-2,mathUtils.multiply(2,-1)),
                () ->assertEquals(0,mathUtils.multiply(2,0))
        );
    }
}