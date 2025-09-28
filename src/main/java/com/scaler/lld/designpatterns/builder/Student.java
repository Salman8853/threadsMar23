package com.scaler.lld.designpatterns.builder;

public class Student {

    private String name;
    private String address;
    private double psp;
    private int age;
    private String gender;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Student(Builder b) {
        this.name = b.getName();
        this.age = b.getAge();
        this.address = b.getAddress();
        this.gender = b.getGender();
        this.psp = b.getPsp();
    }

    //Builder is a static inner class
    public static class Builder {
        private String name;
        private String address;
        private double psp;
        private int age;
        private String gender;

        //make constructor private so that no one can create object of it  from outside
        private Builder() {}

        //All sette methods return current object ofter setting the attribute
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        //build method return the object to actual class andmake sure build mathod should be public
        //if there is any validation we wanna apply we can apply before build the actual object.
        public Student build() throws Exception {
            if (!validate()) {
                throw new Exception("Wrong Parameters");
            }
            return new Student(this);
        }



        //Getters
        
        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public double getPsp() {
            return psp;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public  boolean validate() {
            if (age > 24 && psp < 70) {
                return false;
            }

            if (age < 18) {
                return false;
            }
            return true;
        }
    }
}
