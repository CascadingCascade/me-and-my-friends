package a;
class A {
    public void f() {
        System.out.println("abcdefghijklmnoprstuvwxyz");
    }
}
package b;
import a.*;
class B extends A {
    public void g() {
        System.out.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
}
package c;
import a.*;
import b.*;
public class Main {
    public static void main(String[] args) {
        new A().f();
        new B().g();
    }
}