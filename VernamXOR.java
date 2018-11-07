//author: Tawanda Matsika
//student number : 3580059
//based on the XOR operation
import java.util.Scanner;
import java.util.Random;

public class VernamXOR
{
	private static Scanner reader= new Scanner(System.in);
	
	private String vernam_encrypt(String str,String key)
	{
		String result="";
		if(str.length()==key.length())
		{
			System.out.println("Plaintext"+"\t\t\t"+"Key"+"\t\t\t\t"+"XOR");
			for(int i=0;i<str.length();i++)
			{
				char a=str.charAt(i);
				char b=key.charAt(i);
				System.out.println(Integer.toBinaryString(a)+"\t\t\t\t"+Integer.toBinaryString(b)+"\t\t\t\t"+Integer.toBinaryString(a^b));
				char c= (char)((Integer.parseInt(Integer.toBinaryString(a),2)^Integer.parseInt(Integer.toBinaryString(b),2)));					//XOR
				result=result+c;
			}
		}
		else
		{
			System.out.println("Plaintext and key should be of the same length");
		}
		return result;
	}


	private String vernam_decrypt(String ciphertext,String key)
	{
		String result="";
		if(ciphertext.length()==key.length())
		{
			for(int i=0;i<ciphertext.length();i++)
			{
				char a=ciphertext.charAt(i);
				char b=key.charAt(i);

				char c=(char)(Integer.parseInt(Integer.toBinaryString(a^b),2)); 
				result=result+c;
			}
		}
		else
		{
			System.out.println("Ciphertext and key should be of the same length");
		}

		return result;
	}

	public static void main(String [] args)
	{
		VernamXOR obj=new VernamXOR();
		

		System.out.println("Enter the Vernam plaintext : ");
		String plaintext= obj.reader.next();
		System.out.println("Enter the Vernam key : ");
		String key_1= obj.reader.next();
		String cipher=obj.vernam_encrypt(plaintext,key_1);
		System.out.println("The Ciphertext is: "+cipher);
	
		System.out.println("\nEnter the Vernam ciphertext : ");
		String ciphertext=reader.next();
		System.out.println("Enter the Vernam key : ");
		String key_2=reader.next();
		String text=obj.vernam_decrypt(ciphertext,key_2);
		System.out.println("The plaintext is: "+text);

	}
}