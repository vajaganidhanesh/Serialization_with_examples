package serialize;
import java.io.*;
public class Customized_serialization {

	public static void main(String[] args) throws Exception{

		password p = new password();
		
		System.out.println("username : "+p.UserName);
		
		System.out.println("password : "+p.pwd);
		
		FileOutputStream fos = new FileOutputStream("pas.abc");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(p);
		
		FileInputStream fis = new FileInputStream("pas.abc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		password p1 =(password)ois.readObject();
		
		System.out.println("after serialization");
		
		System.out.println("username : "+p1.UserName);
		
		System.out.println("password : "+p1.pwd);
		
	}

}
class password implements Serializable{
	
	String UserName = "dhansh";
	transient String pwd = "dhani";
	private void writeObject(ObjectOutputStream os) throws Exception{
		os.defaultWriteObject();
		String epwd = "123"+pwd;
		os.writeObject(epwd);
	}
	private void readObject(ObjectInputStream is) throws Exception{
		is.defaultReadObject();
		String epwd =(String)is.readObject();
		pwd = epwd.substring(3);
	}
	
} 
