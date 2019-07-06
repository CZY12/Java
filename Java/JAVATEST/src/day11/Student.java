package day11;

import java.util.Objects;

/**
 * @ClassName Student
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/2 15:29
 * @Version 1.0
 */
public class Student {
    public String name;
    public Integer age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
