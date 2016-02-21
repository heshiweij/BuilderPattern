package cn.ifavor.builderpattern;

/**
 * Created by Administrator on 2016/2/21.
 */
public class User {

    private String name;
    private int age;
    private String address;

    private User(){
        //  empty
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private User user = new User();

        public Builder setName(String name) {
            user.name = name;
            return this;
        }

        public Builder setAge(int age) {
            user.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            user.address = address;
            return this;
        }

        public User build() {
            return user;
        }
    }
}
