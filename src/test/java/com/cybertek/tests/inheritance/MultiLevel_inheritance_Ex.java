package com.cybertek.tests.inheritance;

public class MultiLevel_inheritance_Ex {
    void teach() {
        System.out.println("Teaching subject");
    }
}
class Student extends MultiLevel_inheritance_Ex {
    void listen() {
        System.out.println("Listening");
    }
}
class homeTution extends Student {
    void explains() {
        System.out.println("Does homework");
    }
}
    class CheckForInheritance2 {
        public static void main(String argu[]) {
        homeTution h = new homeTution();
        h.explains();
        h.teach();
        h.listen();
    }
}
