import java.security.MessageDigest;

public class StringUtils{
    //Applies Sha256 to a string and returns the result. 
    public static String applySha512(String input){     
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");//256            
            //Applies sha256/512 to our input, 
            byte[] hash = digest.digest(input.getBytes("UTF-8"));           
            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal values
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }   

}
