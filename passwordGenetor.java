import java.security.SecureRandom;
import java.util.Scanner;

public class passwordGenetor
{
    
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+<>?";

    public static void main(String[] args) throws IllegalAccessException
    {
        Scanner sc = new Scanner(System.in);
         
        System.out.print("Enter the length of the password : ");
        int length = sc.nextInt();

        System.out.print("Include lowercase letters? (yes/no) : ");
        boolean inLower = sc.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no) : ");
        boolean inUpper = sc.next().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no) : ");
        boolean inDigit = sc.next().equalsIgnoreCase("yes");

        System.out.print("Include special Characters? (yes/no) : ");
        boolean inSpecial = sc.next().equalsIgnoreCase("yes");

        String password = generatePassword(length,inLower,inUpper,inDigit,inSpecial);
        System.out.println("Generated Password : "+password);

        sc.close();

    }

    private static String generatePassword(int length,boolean inLower,boolean inUpper,boolean inDigit,boolean inSpecial) throws IllegalAccessException
    {
        if(length<=0)
        {
            throw new IllegalArgumentException("Password length must be greater than zero...!");
        }

        StringBuilder characterSet = new StringBuilder();
        if(inLower)
        {
            characterSet.append(LOWERCASE);
        }
        if(inLower)
        {
            characterSet.append(UPPERCASE);
        }
        if(inDigit)
        {
            characterSet.append(DIGITS);
        }
        if(inSpecial)
        {
            characterSet.append(SPECIAL_CHARACTERS);
        }

        if(characterSet.length() == 0)
        {
            throw new IllegalAccessException("At least one character set must be selected..!");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for(int i=0;i<length;i++)
        {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();

    }
}