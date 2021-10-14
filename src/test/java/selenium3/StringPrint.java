package selenium3;

public class StringPrint {

	public static void main(String[] args) {
		String str = "Hi I am Sanyam";


				for(int i=0;i<str.length();i++){

					for(int j=0;j<=i;j++)
					{
						if(str.charAt(i)!= ' '){
							System.out.println(str.charAt(i));
						}
							
					}


				}


	}

}
