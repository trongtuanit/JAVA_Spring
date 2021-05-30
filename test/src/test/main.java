package test;


import java.security.SecureRandom;


public class main {

	private final static Integer shuffleTimes = 200;
	private final static Integer Lenght = 20;
	
	public static String generateRandomString(int len){
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
		final String lowerChars = "abcdefghijklmnopqrstuvwxyz";
	//	final String secialChars = "@$!%*#?&_";
		final String numbers = "0123456789";
		final String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		
		int randomIdxNumbers = random.nextInt(numbers.length());
		int randomIdxUpperChars = random.nextInt(upperChars.length());
		int randomIdxLowerChars = random.nextInt(lowerChars.length());
		
		sb.append(numbers.charAt(randomIdxNumbers));
		sb.append(upperChars.charAt(randomIdxUpperChars));
		sb.append(lowerChars.charAt(randomIdxLowerChars));
		for (int i = 0; i < len-3; i++)
		{
			int choose = random.nextInt(2);
			switch (choose) {
			case 0:
				randomIdxNumbers = random.nextInt(numbers.length());			
				sb.append(numbers.charAt(randomIdxNumbers));
				break;
			case 1:
				randomIdxUpperChars = random.nextInt(upperChars.length());
				sb.append(upperChars.charAt(randomIdxUpperChars));
				break;
			case 2:
				randomIdxLowerChars = random.nextInt(lowerChars.length());
				sb.append(lowerChars.charAt(randomIdxLowerChars));
			default:
				break;
			}
		    int randomIndex = random.nextInt(lowerChars.length());
		    sb.append(lowerChars.charAt(randomIndex));
		}
		// get a random index of template string
	
//		System.out.println(sb);
		return sb.toString();
	}
	
	public static String shuffleString(String str) {
		String str1 = str.substring(0,4);
		String str2 = str.substring(4);
		str = str2+str1;
		int max=str.length()-1;
	    int min=1;
		SecureRandom random = new SecureRandom();
		for(int i = 0; i < shuffleTimes; i++) {
			int randomIndex = random.nextInt(max-min+1)+min;
			str1 = str.substring(0,randomIndex);
			str2 = str.substring(randomIndex);
			str = str2+str1;
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(shuffleString(generateRandomString(Lenght)));
	}
    	
    	
		
}
