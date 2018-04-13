import java.util.Date;

public class Block {
    public String hash, previousHash;
    private String data;
    private long timeStamp;

    public Block( String previousHash, String data ) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.hashString( this.previousHash + this.data + Long.toString(this.timeStamp) );
        return calculatedHash;
    }
}