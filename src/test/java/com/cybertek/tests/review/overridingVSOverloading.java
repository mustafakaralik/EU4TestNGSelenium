package com.cybertek.tests.review;

public class overridingVSOverloading {

    public static void main(String[] args) {
        Dog dog = new Hound();
        dog.bark();

    }
}
        //burada JVM dog class içinde bark metodu varmı diye bakar ancak code koşturulunca
        // Dog classın hound classa atandığını görür ve JVM dog classın
        // hound içindeki dog class olduğunu düşünür ve ondaki bark metodunu çağırır
    class Dog{
        public void bark(){
            System.out.println("woof ");
        }
    }
    class Hound extends Dog{
        public void sniff(){
            System.out.println("sniff ");
        }

        public void bark(){
            System.out.println("bowl");
        }
    }




