package com.cybertek.tests.inheritance;

public class Hierarchical_inheritance_Ex {

        void teach() {
            System.out.println("Teaching subject");
        }
    }
  //  class Student extends Hierarchical_inheritance_Ex {
  //      void listen() {                            //***yorumu kaldır multileveldaki aynı classı yorum altına al
  //          System.out.println("Listening");
  //      }
  //  }
     class Principal extends Hierarchical_inheritance_Ex {
        void evaluate() {
            System.out.println("Evaluating");
        }
    }
     class CheckForInheritance3 {
        public static void main(String argu[]) {
            Principal p = new Principal();
            p.evaluate();
            p.teach();
            // p.listen(); will produce an error
        }
    }

