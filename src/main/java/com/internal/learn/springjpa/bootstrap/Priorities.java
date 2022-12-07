package com.internal.learn.springjpa.bootstrap;

import java.util.*;
import java.util.stream.Collectors;

public class Priorities implements Comparator<Student> {

    public List<Student> getStudents(List<String> events){

        PriorityQueue<Student> queue = new PriorityQueue<>(events.size(),this);
        for(String input : events){
            int firstSpaceIndex = input.indexOf(" ");
            String firstWord=null;
            if(firstSpaceIndex>0){
                firstWord = input.substring(0,firstSpaceIndex);
            }
            else{
                firstWord = input.trim();
            }
            if(firstWord.equalsIgnoreCase("ENTER")){
                String subInput = input.substring(firstSpaceIndex);
                String [] tokens = subInput.trim().split(" ");
                Student student = new Student(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2]));
                queue.add(student);

            } else if(firstWord.equalsIgnoreCase("SERVED")){
                if(!queue.isEmpty()){
                    queue.poll();
                }


            }
        }
        //List<Student> studentList  = queue.stream().collect(Collectors.toCollection(ArrayList::new));
        List<Student> studentList = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            studentList.add(queue.poll());
        }
        return studentList;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getCGPA()!=o2.getCGPA()){
            return Double.compare( o2.getCGPA(),o1.getCGPA());
        } else{
            if(!o1.getName().equalsIgnoreCase(o2.getName())){
                return o1.getName().compareTo(o2.getName());
            } else {
                return Integer.compare(o1.getId(),o2.getId());
            }
        }
    }
}
