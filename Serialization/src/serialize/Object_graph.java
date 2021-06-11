package serialize;
import java.io.*;
public class Object_graph {

	public static void main(String[] args) throws Exception{
		Parent_Dog d = new Parent_Dog();
		FileOutputStream fos = new FileOutputStream("dhanesh.abc");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		FileInputStream fis = new FileInputStream("dhanesh.abc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Parent_Dog d1 =(Parent_Dog)ois.readObject();
		System.out.println("the value of i : "+d1.c.b.i);
	}

}
class Parent_Dog implements Serializable{
	child_Dog c = new child_Dog();
}
class child_Dog implements Serializable{
	baby_Dog  b= new baby_Dog();
}
class baby_Dog implements Serializable{
	int i=10,j=20;
}