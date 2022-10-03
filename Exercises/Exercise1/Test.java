package com.example.Exercise1;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args){
        Session session = new Session();
        session.addFullTimeStudent(new FullTimeStudent("Amelia"));
        session.addFullTimeStudent(new FullTimeStudent("Noah"));
        session.addFullTimeStudent(new FullTimeStudent("Oliver"));
        session.addFullTimeStudent(new FullTimeStudent("Oliva"));
        session.addFullTimeStudent(new FullTimeStudent("George"));
        session.addFullTimeStudent(new FullTimeStudent("Isla"));
        session.addFullTimeStudent(new FullTimeStudent("Leo"));
        session.addFullTimeStudent(new FullTimeStudent("Ava"));
        session.addFullTimeStudent(new FullTimeStudent("Theo"));
        session.addFullTimeStudent(new FullTimeStudent("Freya"));
        session.addFullTimeStudent(new FullTimeStudent("Arthur"));
        session.addFullTimeStudent(new FullTimeStudent("Mia"));
        session.addFullTimeStudent(new FullTimeStudent("Freddie"));
        session.addFullTimeStudent(new FullTimeStudent("Willow"));
        session.addFullTimeStudent(new FullTimeStudent("Harry"));
        session.addFullTimeStudent(new FullTimeStudent("Evie"));
        session.addPartTimeStudent(new PartTimeStudent("Charlie"));
        session.addPartTimeStudent(new PartTimeStudent("Lilly"));
        session.addPartTimeStudent(new PartTimeStudent("Jack"));
        session.addPartTimeStudent(new PartTimeStudent("Grace"));
        Random random = new Random();
        for(int i = 0; i < session.students.size(); i++){
            for(int j = 0; j < session.students.get(i).quiz.length; j++){
                session.students.get(i).quiz[j] = 50 + random.nextInt(50);
            }
        }
        for(int i = 0; i < session.fullTimeStudents.size(); i++){
            session.fullTimeStudents.get(i).exam[0] = 50 + random.nextInt(50);
            session.fullTimeStudents.get(i).exam[1] = 50 + random.nextInt(50);
        }

        float[] avgQuiz = session.getAverageQuizScores();
        System.out.print("Each students' average quiz scores are as follows: \n");
        for(int i = 0; i < session.students.size(); i++){
            System.out.printf("%-10s",session.students.get(i).name);
            System.out.println(avgQuiz[i]);
        }

        session.getAscendingQuizScores(5);
        session.getNamesOfPartTimeStudent();
        session.getExamScores();
    }
}
