package bwie.com.corejava;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/4/9 10:50:23
 * @Description: 描述信息
 */
public class Person {
    private String id;
    private String name;
    private String age;
    private String salary;

    public Person(String id, String name, String age, String salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
