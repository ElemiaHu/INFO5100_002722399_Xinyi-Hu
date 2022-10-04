package com.example.Exercise1;
import java.util.ArrayList;

public class Session {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<FullTimeStudent> fullTimeStudents = new ArrayList<>();
    ArrayList<PartTimeStudent> partTimeStudents = new ArrayList<>();

    Session(){}

    public void addFullTimeStudent(FullTimeStudent student){
        if(students.size() < 20){
            fullTimeStudents.add(student);
            students.add(student);
        }else{
            System.out.println("There is no more available seat in this session.");
        }
    }

    public void addPartTimeStudent(PartTimeStudent student){
        if(students.size() < 20){
            partTimeStudents.add(student);
            students.add(student);
        }else{
            System.out.println("There is no more available seat in this session.");
        }
    }

    // return an array of average quiz scores per student
    public float[] getAverageQuizScores(){
        float[] quizAvg = new float[students.size()];
        for(int i = 0; i < students.size(); i++){
            int sum = 0;
            for(int j = 0; j < students.get(i).quiz.length; j++){
                sum = sum + students.get(i).quiz[j];
            }
            quizAvg[i] = sum / 15;
        }
        return quizAvg;
    }

    // for quiz i, print the scores in ascending order
    public void getAscendingQuizScores(int i){
        int[] sorted = new int[students.size()];
        for(int j = 0; j < students.size(); j++){
            sorted[j] = students.get(j).quiz[i];
        }
        sort(sorted);
        System.out.print("Scores of quiz " + i + " in ascending order is: ");
        for(int j = 0; j < sorted.length; j++){
            System.out.print(sorted[j] + " ");
        }
        System.out.println();
    }

    // A sort method using selection sort
    private int[] sort(int[] nums){
        for(int start = 0; start < nums.length - 1; start++){
            int minIdx = start;
            for(int j = start + 1; j < nums.length; j++){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                }
            }
            int temp = nums[start];
            nums[start] = nums[minIdx];
            nums[minIdx] = temp;
        }
        return nums;
    }

    public void getNamesOfPartTimeStudent(){
        System.out.print("Part Time Student(s): ");
        for(int i = 0; i < partTimeStudents.size(); i++){
            System.out.print(partTimeStudents.get(i).name + " ");
        }
        System.out.println();
    }

    public void getExamScores(){
        System.out.printf("%-15s", "StudentName");
        System.out.printf("%-10s", "Exam1");
        System.out.printf("%-10s%n", "Exam2");
        for(int i = 0; i < fullTimeStudents.size(); i++){
            System.out.printf("%-15s", fullTimeStudents.get(i).name);
            System.out.printf("%-10d", fullTimeStudents.get(i).exam[0]);
            System.out.printf("%-10d%n", fullTimeStudents.get(i).exam[1]);
        }
    }

}
