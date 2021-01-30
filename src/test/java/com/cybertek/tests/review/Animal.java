package com.cybertek.tests.review;

public class Animal {

    private String name;

    public Animal (String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String speak (){
        return "Animal Speaking.";
    }
}

    class  main {

    public static void getSpeak (Animal animal){

        System.out.println(animal.speak());
}
        public static void main(String[] args) {

            Animal animal =new Animal("Richi");
            Animal animal2 =new Cat("pofuduk ");
            Animal animal3 = new Dogg("Rintenten ");
            Animal animal4 = new Horse("Rüzgar ");

            System.out.println(animal.speak());
            System.out.println(animal2.speak());
            System.out.println(animal3.speak());
            System.out.println(animal4.speak());
            //*********************************************//
            getSpeak(new Cat("mırnaw "));
            getSpeak(new Dogg("rintintin"));
            getSpeak(new Horse("Rüzgarrr"));


        }


    }
    class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        public String speak() {
            return this.getName()+" miyavlıyor";
        }

    }

    class Dogg extends Animal{

    public Dogg(String name){
        super (name);
    }
    @Override
    public String speak(){
        return this.getName() +" Havlıyor";
    }
    }
    class Horse extends Animal{

    public Horse (String name){
        super(name);

    }
    @Override
    public String speak(){
        return this.getName() +" kişniyor";
    }
    }