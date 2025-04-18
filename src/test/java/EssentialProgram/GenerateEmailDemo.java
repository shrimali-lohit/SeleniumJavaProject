package EssentialProgram;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main (String[] args) {
		
		Date date = new Date();
		String stringDate = date.toString();
		String noSpaceStringDate = stringDate.replaceAll("\\s","");
		String noColonStringDate = stringDate.replaceAll("\\:","");
        String emailWithTimeStamp = noColonStringDate + "gmail.com";
        System.out.println(emailWithTimeStamp);

		
	}
	
	
}
