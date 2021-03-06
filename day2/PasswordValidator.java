import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Math;

public class PasswordValidator {

    public static void main(String[] args) {

        Path file_path = Paths.get(System.getProperty("user.dir"), "input.txt");

        try {
            String content = Files.readString(file_path);
            String[] passwords = content.split("\n");
            int res = countValidPasswords(passwords);
            System.out.println("The number of valid passwords:       " + res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int countValidPasswords(String[] passwords){
        int uppeLimit = passwords.length;
        int num = 0;
        for(int i = 0; i < uppeLimit; i++){
            String[] passwordData = passwords[i].split(":");
            String[] limits = passwordData[0].replaceAll("[^0-9]+", " ").trim().split(" ");
            String[] letter = passwordData[0].replaceAll("[^a-z]+", " ").trim().split(" ");
            if(validate(limits, letter, passwordData[1].split(""))){
                num++;
            }
        }
        return num;
    }
    public static boolean validate(String[] limits, String[] letter, String[] password){

        int positionFirst = Integer.parseInt(limits[0]);
        int positionSecond = Integer.parseInt(limits[1]);



        if((password[positionFirst].equals(letter[0]) || password[positionSecond].equals(letter[0])) && !password[positionFirst].equals(password[positionSecond])){
            return true;
        }

        return false;
    }
}