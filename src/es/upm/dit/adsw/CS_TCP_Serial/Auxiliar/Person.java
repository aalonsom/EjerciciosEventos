package es.upm.dit.adsw.CS_TCP_Serial.Auxiliar;

import java.io.Serializable;

/**
 * Created by aalonso on 5/9/17.
 */

public class Person implements Serializable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person: [name=" + name + ", age=" + age + "]";
    }


}