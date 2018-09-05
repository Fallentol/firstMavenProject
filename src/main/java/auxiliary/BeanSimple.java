package auxiliary;

public class BeanSimple {
    private String name;
    private String age;

    public BeanSimple(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public BeanSimple() {
        name = "Alex JR";
    }

    public String getName() {
        return "NA";
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

    @Override
    public String toString() {
        return "BeanSimple{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
