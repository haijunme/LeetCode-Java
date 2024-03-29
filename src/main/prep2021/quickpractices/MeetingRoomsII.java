package main.prep2021.quickpractices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    private static final Comparator<int[]> INTERVAL_COMPARATOR = Comparator.comparingInt(o -> o[0]);

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, INTERVAL_COMPARATOR);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!rooms.isEmpty() && rooms.peek() <= interval[0]) {
                rooms.poll();
            }
            rooms.add(interval[1]);
        }
        return rooms.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.minMeetingRooms(new int[][]{{7,10}, {2,4}}));
    }
}
