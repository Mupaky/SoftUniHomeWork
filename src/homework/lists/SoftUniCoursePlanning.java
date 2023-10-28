package homework.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SoftUniCoursePlanning {

    private static final String EXERCISE_SUFFIX = "-Exercise";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> schedule = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));

        String command;
        while (!"course start".equals(command = scanner.nextLine())) {
            String[] parts = command.split(":");
            switch (parts[0]) {
                case "Add":
                    addLesson(schedule, parts[1]);
                    break;
                case "Insert":
                    insertLesson(schedule, parts[1], Integer.parseInt(parts[2]));
                    break;
                case "Remove":
                    removeLesson(schedule, parts[1]);
                    break;
                case "Swap":
                    swapLessons(schedule, parts[1], parts[2]);
                    break;
                case "Exercise":
                    addExercise(schedule, parts[1]);
                    break;
            }
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.println((i + 1) + "." + schedule.get(i));
        }
    }

    private static void addLesson(List<String> schedule, String lessonTitle) {
        if (!schedule.contains(lessonTitle)) {
            schedule.add(lessonTitle);
        }
    }

    private static void insertLesson(List<String> schedule, String lessonTitle, int index) {
        if (!schedule.contains(lessonTitle)) {
            schedule.add(index, lessonTitle);
        }
    }

    private static void removeLesson(List<String> schedule, String lessonTitle) {
        schedule.remove(lessonTitle);
        schedule.remove(lessonTitle + EXERCISE_SUFFIX);
    }

    private static void swapLessons(List<String> schedule, String lessonTitle1, String lessonTitle2) {
        int index1 = schedule.indexOf(lessonTitle1);
        int index2 = schedule.indexOf(lessonTitle2);

        if (index1 != -1 && index2 != -1) {
            schedule.set(index1, lessonTitle2);
            schedule.set(index2, lessonTitle1);

            if (schedule.contains(lessonTitle1 + EXERCISE_SUFFIX)) {
                schedule.remove(lessonTitle1 + EXERCISE_SUFFIX);
                schedule.add(index2 + 1, lessonTitle1 + EXERCISE_SUFFIX);
            }

            if (schedule.contains(lessonTitle2 + EXERCISE_SUFFIX)) {
                schedule.remove(lessonTitle2 + EXERCISE_SUFFIX);
                schedule.add(index1 + 1, lessonTitle2 + EXERCISE_SUFFIX);
            }
        }
    }

    private static void addExercise(List<String> schedule, String lessonTitle) {
        int lessonIndex = schedule.indexOf(lessonTitle);
        if (lessonIndex != -1 && !schedule.contains(lessonTitle + EXERCISE_SUFFIX)) {
            schedule.add(lessonIndex + 1, lessonTitle + EXERCISE_SUFFIX);
        } else if (!schedule.contains(lessonTitle)) {
            schedule.add(lessonTitle);
            schedule.add(lessonTitle + EXERCISE_SUFFIX);
        }
    }
}
