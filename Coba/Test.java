public class Test{
	public void print(byte x){
		System.out.print("byte");}
	public void print(int x){
		System.out.print("int");}
	public void print(float x){
		System.out.print("float");}
	public void print(Object x){
		System.out.print("Object");}
	public static void main(String[]args){
		Test t = new Test();
		short s = 123;
		t.print(s);
		t.print(123L);
		t.print(6.2);
	}
}	