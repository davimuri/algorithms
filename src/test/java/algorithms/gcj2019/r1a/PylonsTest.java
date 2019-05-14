package algorithms.gcj2019.r1a;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PylonsTest {

    @Test
    public void testFrom2To20Matrix() {
        for (int row = 2; row <= 20; row++) {
            for (int col = 2; col <= 20; col++) {
                List<int[]> path = Pylons.path(row, col);
                Assert.assertTrue("matrix " + row + " x " + col + " path size " + path.size(),
                        validPath(path, row, col));
                System.out.println("Success! matrix " + row + " x " + col + " path size " + path.size());
            }
        }
    }

    private boolean validPath(List<int[]> path, int rows, int cols) {
        if (rows * cols <= 9) {
            return path.isEmpty();
        }
        if (path.size() != rows * cols) {
            return false;
        }
        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i)[0] == path.get(i+1)[0]
                || path.get(i)[1] == path.get(i+1)[1]
                || path.get(i)[0] - path.get(i)[1] == path.get(i+1)[0] - path.get(i+1)[1]
                || path.get(i)[0] + path.get(i)[1] == path.get(i+1)[0] + path.get(i+1)[1]) {
                return false;
            }
        }
        return true;
    }
}
