package algorithms.gcj2020.r0;

import algorithms.gcj2020.AlgorithmIOTester;
import org.junit.Test;

public class VestigiumTest {

    @Test
    public void testCasesFromFile() {
        AlgorithmIOTester.testFromFile(
                Vestigium::main,
                "gcj2020/r0/vestigium_input.txt",
                "gcj2020/r0/vestigium_solution.txt");
    }

}
