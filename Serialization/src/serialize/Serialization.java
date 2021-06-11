package serialize;
import java.io.*;
public class Serialization  {
	public static void main(String args[]) throws Exception {
		
		method m1 =new method();
		
		System.out.println("serislization");
		/* its all about converting of an object into networking file
		
		*/
		/*
		 * FileOutputStream fos = new FileOutputStream("first.abc"); ObjectOutputStream
		 * oos =new ObjectOutputStream(fos); oos.writeObject(m1);
		 * 
		 * FileInputStream fis=new FileInputStream("first.abc"); ObjectInputStream
		 * ois=new ObjectInputStream(fis); method d2=(method)ois.readObject();
		 * 
		 * System.out.println("Deserialization ended");
		 * System.out.println(d2.i+"................"+d2.j);
		 */
		
		student s = new student(489,"dhanesh");
		FileOutputStream fos_1 =new FileOutputStream("std.abc");
		ObjectOutputStream oos_1 = new ObjectOutputStream(fos_1);
		oos_1.writeObject(s);
		oos_1.flush();
		
		FileInputStream fis_1=new FileInputStream("std.abc");
		ObjectInputStream ois_1 =new ObjectInputStream(fis_1);
		student s_1=(student)ois_1.readObject();
		
		System.out.println(s_1.Id+" : "+s_1.name);
		
	}
}
class method implements Serializable{
	int i=10,j=20;
	
}
class student implements Serializable{
	int Id;
	String name;
	student(int Id,String name){
		this.Id = Id;
		this.name = name;
	}
}



