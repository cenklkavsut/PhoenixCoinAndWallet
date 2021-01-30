import java.util.*;

public class Block {
    public String hash;//the hash its self
    public String previousHash;//previous hash signature
    private String data; //our data will be a simple message.
    private long timeStamp; //as number of milliseconds 1/1/2021.
    
    public String calculateHash() {
        String calculatedhash = StringUtils.applySha512( 
                previousHash +
                Long.toString(timeStamp) +
                data 
                );
        return calculatedhash;
    }

    public Block(String data,String previousHash ) {
        this.data = data;//this contains the data in this case it is a string
        this.previousHash = previousHash;//this instanciates previous hash when called
        this.timeStamp = new Date().getTime();//this intansiates the timestamp of the 
        this.hash = calculateHash();
    }

}
