package algorithms.gcj2020.r0;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParentingPartneringTest {

    @Test
    public void testUpperLimit() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(1439, 1440),
                ParentingPartnering.DomesticTask.of(1439, 1440)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JC", actual);
    }

    @Test
    public void testTwoNonOverlapingTasks() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 20),
                ParentingPartnering.DomesticTask.of(20, 30)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JJ", actual);
    }

    @Test
    public void testTwoOverlapingTasks() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 20),
                ParentingPartnering.DomesticTask.of(15, 30)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JC", actual);
    }

    @Test
    public void testThreeOverlapingTasks() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 20),
                ParentingPartnering.DomesticTask.of(15, 30),
                ParentingPartnering.DomesticTask.of(18, 30)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("IMPOSSIBLE", actual);
    }

    @Test
    public void testTwoTasksWithSameStartTime() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 20),
                ParentingPartnering.DomesticTask.of(10, 30)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JC", actual);
    }

    @Test
    public void testThreeTasksWithSameStartTime() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 20),
                ParentingPartnering.DomesticTask.of(10, 30),
                ParentingPartnering.DomesticTask.of(10, 40)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("IMPOSSIBLE", actual);
    }

    @Test
    public void testThreeTasksWithSameStartTime2() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 15),
                ParentingPartnering.DomesticTask.of(10, 13),
                ParentingPartnering.DomesticTask.of(10, 11)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("IMPOSSIBLE", actual);
    }

    @Test
    public void testTwoTasksWithSameStartEndTime() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 20),
                ParentingPartnering.DomesticTask.of(10, 20)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JC", actual);
    }

    @Test
    public void testTwoTasksWithSameEndTime() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(10, 11),
                ParentingPartnering.DomesticTask.of(8, 11),
                ParentingPartnering.DomesticTask.of(11, 20)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JCJ", actual);
    }

    @Test
    public void testCase1() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(360, 480),
                ParentingPartnering.DomesticTask.of(420, 540),
                ParentingPartnering.DomesticTask.of(600, 660)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JCJ", actual);
    }

    @Test
    public void testCase2() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(0, 1440),
                ParentingPartnering.DomesticTask.of(1, 3),
                ParentingPartnering.DomesticTask.of(2, 4)
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("IMPOSSIBLE", actual);
    }

    @Test
    public void testCase3() {
        ParentingPartnering.DomesticTask[] tasks = {
                ParentingPartnering.DomesticTask.of(99, 150),  // 3. C
                ParentingPartnering.DomesticTask.of(1, 100),   // 1. J
                ParentingPartnering.DomesticTask.of(100, 301), // 4. J
                ParentingPartnering.DomesticTask.of(2, 5),     // 2. C
                ParentingPartnering.DomesticTask.of(150, 250)  // 5. C
        };
        ParentingPartnering pp = new ParentingPartnering();
        String actual = pp.schedule(toTimeline(tasks), tasks);
        Assert.assertEquals("JCCJC", actual);
    }

    private Map<Integer, List<Integer>> toMap(int[][] tasks) {
        Map<Integer, List<Integer>> startToEnd = new HashMap<>();
        for (int[] task : tasks) {
            List<Integer> list = startToEnd.getOrDefault(task[0], new ArrayList<>());
            list.add(task[1]);
            startToEnd.put(task[0], list);
        }
        return startToEnd;
    }

    private List<ParentingPartnering.DomesticTask>[] toTimeline(ParentingPartnering.DomesticTask[] tasks) {
        List<ParentingPartnering.DomesticTask>[] timeline = new List[1441];
        for (ParentingPartnering.DomesticTask task : tasks) {
            List<ParentingPartnering.DomesticTask> list = timeline[task.start];
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(task);
            timeline[task.start] = list;
        }
        return timeline;
    }
}
