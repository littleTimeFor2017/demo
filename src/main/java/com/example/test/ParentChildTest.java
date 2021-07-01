package com.example.test;

public class ParentChildTest {
    public static void main(String[] args) {
        Parent child = new Child("lixc","18");
        System.out.println(child.getName());
        say(child);
        System.out.println(child.getName());
        eat(child);
    }


    public static void say(Parent parent){
        System.out.println(parent);
        parent.setName("123");
    }
    public static void eat(Parent parent){
        System.out.println(parent.getName());
    }
    static class Parent {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Child extends Parent {
        private String name;
        private String age;

        public Child(String name, String age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
