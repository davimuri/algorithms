package algorithms.gcj2020;

import org.junit.Assert;

import java.io.*;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class AlgorithmIOTester {

    public static void testFromFile(BiConsumer<Scanner, PrintStream> algorithm,
                                    String testCaseFile, String expectedOutputFile) {
        Scanner algorithmInput = null;
        Scanner expectedData = null;
        try {
            String testCaseFilePath = AlgorithmIOTester.class.getClassLoader().getResource(testCaseFile).getFile();
            algorithmInput = new Scanner(new BufferedReader(new FileReader(testCaseFilePath)));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024);
            PrintStream algorithmOutput = new PrintStream(outputStream, true);

            algorithm.accept(algorithmInput, algorithmOutput);

            Scanner actualData = new Scanner(new InputStreamReader(new ByteArrayInputStream(outputStream.toByteArray())));
            String expectedOutputFilePath = AlgorithmIOTester.class.getClassLoader().getResource(expectedOutputFile).getFile();
            expectedData = new Scanner(new BufferedReader(new FileReader(expectedOutputFilePath)));

            while (expectedData.hasNext() && actualData.hasNext()) {
                String expectedLine = expectedData.nextLine();
                String actualLine = actualData.nextLine();
                Assert.assertEquals(expectedLine, actualLine);
            }
            if (actualData.hasNext()) {
                Assert.fail("Algorithm is not given all expected solutions");
            }
            if (expectedData.hasNext()) {
                Assert.fail("Algorithm is giving more data than expected");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        } finally {
            if (algorithmInput != null) {
                algorithmInput.close();
            }
            if (expectedData != null) {
                expectedData.close();
            }
        }
    }
}
