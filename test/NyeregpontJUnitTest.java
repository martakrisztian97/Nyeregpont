import nyeregpont.Nyeregpont;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Nyeregpont JUnit tesztelése.
 * @author Márta Krisztián
 */
public class NyeregpontJUnitTest {
    
    public NyeregpontJUnitTest() {
    }

    @Test
    public void NyeregpontTest1() {
        double[][] matrix = {
                {2.0, 1.0} ,
                {0.0, 1.0}
        };
        boolean elvart = true;
        boolean eredmeny = Nyeregpont.nyeregpontVizsgal(matrix);
        assertEquals(eredmeny, elvart);
    }
    
    @Test
    public void NyeregpontTest2() {
        double[][] matrix = {
                {1.0, 1.0} ,
                {1.0, 1.0}
        };
        boolean elvart = true;
        boolean eredmeny = Nyeregpont.nyeregpontVizsgal(matrix);
        assertEquals(eredmeny, elvart);
    }
    
    @Test
    public void NyeregpontTest3() {
        double[][] matrix = {
                {-4.0, 3.0, -1.0} ,
                {2.0, -4.0, 5.0}
        };
        boolean elvart = false;
        boolean eredmeny = Nyeregpont.nyeregpontVizsgal(matrix);
        assertEquals(eredmeny, elvart);
    }
    
    @Test
    public void NyeregpontTest4() {
        double[][] matrix = {
                {3.0, -1.0, 2.0} ,
                {5.0, -4.0, 0.0} ,
                {2.0, -7.0, 4.0} ,
                {3.0, -2.0, 2.0}
        };
        boolean elvart = true;
        boolean eredmeny = Nyeregpont.nyeregpontVizsgal(matrix);
        assertEquals(eredmeny, elvart);
    }
    
    @Test
    public void NyeregpontTest5() {
        double[][] matrix = {
                {1.0, 5.0} ,
                {2.0, 6.0} ,
                {3.0, 7.0} ,
                {4.0, 8.0}
        };
        boolean elvart = true;
        boolean eredmeny = Nyeregpont.nyeregpontVizsgal(matrix);
        assertEquals(eredmeny, elvart);
    }
}
