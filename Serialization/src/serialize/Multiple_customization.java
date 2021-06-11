package serialize;
import java.io.*;
public class Multiple_customization {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		details d = new details();
		System.out.println(d.UserName+" : "+d.password+" : "+d.pin);
		
		FileOutputStream fos = new FileOutputStream("abcd.abc");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		
		FileInputStream fis = new FileInputStream("abcd.abc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		details d1= (details)ois.readObject();
		System.out.println(d1.UserName+" : "+d1.password+" : "+d1.pin);
	}

}
class details implements Serializable{
	String UserName = "dhanesh";
	transient String password = "dhani";
	transient int pin = 1234;
	private void writeObject(ObjectOutputStream os)throws Exception {
		os.defaultWriteObject();
		String epwd = "123"+password;
		int epin = 4444+pin;
		os.writeObject(epwd);
		os.writeInt(epin);
	}
	private void readObject(ObjectInputStream is) throws Exception {
		is.defaultReadObject();
		String epwd = (String)is.readObject();
		password = epwd.substring(3);
		int epin=is.readInt();
		pin = epin-4444;
	}
}
