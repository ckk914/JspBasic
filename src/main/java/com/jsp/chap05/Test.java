package com.jsp.chap05;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        jdbcBasic jdbc = new jdbcBasic();

        //jdbc.insert(new Person(99,"고길동",30));
        //jdbc.insert(new Person(300,"박가",30));
      //  jdbc.delete(99);
       // jdbc.update(300,"박까",333);
        List<Person> people = jdbc.findAll();

        System.out.println("people = " + people);

    }
}
