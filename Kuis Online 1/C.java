public class C {
    public static void main(String[] s) {
        Object[] o = {new A(), new B()};
        System.out.print(o[0]);
        System.out.print(o[1]);
    }
}

class B{
    public String toString(){
        return "B";
    }
}

class A extends B{
    public String toString(){
        return "A";
    }
}