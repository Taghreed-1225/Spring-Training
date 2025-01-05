package com.adminPanel.app.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//plane old java object (pojo)
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                '}';
    }
}
