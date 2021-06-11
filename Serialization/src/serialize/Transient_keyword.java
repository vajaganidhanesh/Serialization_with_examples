package serialize;
import java.io.*;
import java.util.*;
public class Transient_keyword  {
	
	public static void main(String args[]) throws Exception {
		/*
		 * int IdNumber; String Name; String Branch; Scanner ss = new
		 * Scanner(System.in); studentDetails[] arr = new studentDetails[5]; for(int
		 * i=0;i<arr.length;i++) { IdNumber = ss.nextInt(); Name = ss.next(); Branch =
		 * ss.next(); arr[i] = new studentDetails(IdNumber,Name,Branch); }
		 */
		studentDetails s = new studentDetails(489,"dhanesh","ECE");
		aaaa a = new aaaa();
		bbbb b = new bbbb();
		cccc c = new cccc();
		FileOutputStream fos = new FileOutputStream("trs.abc");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		oos.writeObject(a);
		oos.writeObject(b);
		oos.writeObject(c);
		
		FileInputStream fis = new FileInputStream("trs.abc");
		ObjectInputStream ois = new ObjectInputStream(fis);
		studentDetails d =(studentDetails) ois.readObject();
		aaaa d1 = (aaaa)ois.readObject();
		bbbb d2 = (bbbb)ois.readObject();
		cccc d3 = (cccc)ois.readObject();
		
		System.out.println("Id_Number    : "+d.IdNumber+" == " + d1.aa);
		System.out.println("Name_Student : "+d.Name);
		System.out.println("Branch       : "+d.Branch);
	}
	
	
}
class studentDetails implements Serializable{
	transient int IdNumber;
	transient final String Name;
	transient static String Branch;
	studentDetails(int IdNumber,String Name, String Branch){
		this.IdNumber= IdNumber;
		this.Name = Name;
		this.Branch = Branch;
	}
}
class aaaa implements Serializable{
	int aa = 10,bb = 20;
}

class bbbb implements Serializable{
	
}
class cccc implements Serializable{
	
}

	
