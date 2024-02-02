import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Job {
    String name;
    int duration;

    public Job(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}

public class SJF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Job> jobs = new ArrayList<>();

        // Input jobs
        System.out.println("Enter the number of jobs:");
        int numJobs = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numJobs; i++) {
            System.out.println("Enter job name for Job " + (i + 1) + ":");
            String jobName = scanner.nextLine();
            System.out.println("Enter duration for Job " + (i + 1) + ":");
            int jobDuration = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            jobs.add(new Job(jobName, jobDuration));
        }

        // Sort jobs alphabetically
        Collections.sort(jobs, Comparator.comparing(job -> job.name));

        // Execute jobs based on SJF
        int currentTime = 0;
        for (Job job : jobs) {
            System.out.println("Executing Job " + job.name + " for duration " + job.duration + " units.");
            currentTime += job.duration;
        }

        System.out.println("All jobs executed successfully.");
    }
}