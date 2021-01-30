package com.cybertek.tests.inheritance;


   public class single_inheritance_Ex {
        void teach() {
            System.out.println("Teaching subjects");
        }
    }
    class Students extends single_inheritance_Ex {
        void listen() {
            System.out.println("Listening to teacher");
        }
    }
    class CheckForInheritance {
        public static void main(String args[]) {
            Students s1 = new Students();
            s1.teach();
            s1.listen();
        }
    }

