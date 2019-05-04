package algorithms.gcj2019.r1c;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RobotProgrammingStrategyTest {

    @Test
    public void testCase1() {
        List<RobotProgrammingStrategy.Robot> robots = new ArrayList<>();
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        String expected = "P";
        String actual = RobotProgrammingStrategy.solve(robots);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        List<RobotProgrammingStrategy.Robot> robots = new ArrayList<>();
        robots.add(new RobotProgrammingStrategy.Robot("R"));
        robots.add(new RobotProgrammingStrategy.Robot("P"));
        robots.add(new RobotProgrammingStrategy.Robot("S"));
        String expected = "IMPOSSIBLE";
        String actual = RobotProgrammingStrategy.solve(robots);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        List<RobotProgrammingStrategy.Robot> robots = new ArrayList<>();
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        robots.add(new RobotProgrammingStrategy.Robot("RS"));
        String expected = "P";
        String actual = RobotProgrammingStrategy.solve(robots);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        List<RobotProgrammingStrategy.Robot> robots = new ArrayList<>();
        robots.add(new RobotProgrammingStrategy.Robot("PP"));
        robots.add(new RobotProgrammingStrategy.Robot("PR"));
        robots.add(new RobotProgrammingStrategy.Robot("PS"));
        String expected = "S";
        String actual = RobotProgrammingStrategy.solve(robots);
        assertEquals(expected, actual);
    }

    @Test
    public void testCaseEmptyInput() {
        List<RobotProgrammingStrategy.Robot> robots = new ArrayList<>();
        String expected = "IMPOSSIBLE";
        String actual = RobotProgrammingStrategy.solve(robots);
        assertEquals(expected, actual);
    }

}
