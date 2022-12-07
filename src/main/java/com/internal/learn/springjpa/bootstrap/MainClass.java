package com.internal.learn.springjpa.bootstrap;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        //regex
        for(int i=0;i<4;i++){

            String value=in.next();
            System.out.println("value : "+value);
            String pattern = "(([01]?+[0-9]?+[0-9]?+)|([2][0-4][0-9])|(25[0-5])).(([01]?+[0-9]?+[0-9]?+)|([2][0-4][0-9])|(25[0-5])).(([01]?+[0-9]?+[0-9]?+)|([2][0-4][0-9])|(25[0-5])).(([01]?+[0-9]?+[0-9]?+)|([2][0-4][0-9])|(25[0-5]))";
            boolean matches = value.matches(pattern);
            System.out.println("matches?: "+matches);

        }
        in.close();*/
        Student st1 = new Student("Harry",7.1,234);
        Student st2 = new Student("Aniket",7.1,235);
        Student st3 = new Student("Ankit",7.1,256);
        List<Student> unsortedList = new ArrayList<>();
        unsortedList.add(st1);
        unsortedList.add(st2);
        unsortedList.add(st3);
        Priorities priorties = new Priorities();
        Collections.sort(unsortedList,priorties);
        unsortedList.forEach( student -> {
            System.out.println(student.toString());
        });

        String events = "ENTER John 3.75 50";
        String event2 = "ENTER Mark 3.8 24";
        String event3="ENTER Shafaet 3.7 35";
        String event4 = "SERVED";
        List<String> eventList = new ArrayList<>();
        eventList.add(events);
        eventList.add(event2);
        eventList.add(event3);
        eventList.add(event4);
        List<Student> students = priorties.getStudents(eventList);
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
        /*for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            //int calculate = 0;
            int powerCalculation=0;

            for(int j=0;j<n;j++){
                powerCalculation = (int) (powerCalculation + ((Math.pow(2,j))*b));
                int sumPowerCalc =a+ powerCalculation;

                System.out.print(sumPowerCalc+" ");
            }
            System.out.println("");
        }
        */


    }
}
