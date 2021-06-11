package serialize;
import java.io.*;
public class Inheritance_Serialization{

	public static void main(String[] args)  throws Exception{
		dealer d =new dealer();
		d.i=14;
		d.j=3;
		FileOutputStream fos = new FileOutputStream("inheritance.abc");
		ObjectOutputStream oos= new ObjectOutputStream(fos);
		oos.writeObject(d);
		
		System.out.println("de-serialization");
		FileInputStream fis = new FileInputStream("inheritance.abc");
		ObjectInputStream ois= new ObjectInputStream(fis);
		 dealer d1 = (dealer)ois.readObject();
		 System.out.println(d1.i+" "+d1.j);
	}

}
class Customer {
	int i=10;
	Customer(){
		System.out.println("Customer_constructor");
	}
}
class dealer extends Customer implements Serializable{
	int j=10;
	dealer(){
		System.out.println("dealer_constructor");
	}
}