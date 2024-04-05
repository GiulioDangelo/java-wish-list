public class Gift {
    String name;

    public Gift(String regalo) {
        this.name = regalo;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gift{" + "name='" + name + '\'' + '}';
    }
}
