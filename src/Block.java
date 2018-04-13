import java.util.Date;

public class Block {
    public String hash, previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public Block( String previousHash, String data ) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedHash = StringUtil.hashString(
                this.previousHash + this.data + Long.toString(this.timeStamp) + Integer.toString(this.nonce) );
        return calculatedHash;
    }

    public void mineBlock( int difficulty ) {
        System.out.println("Mining block...");

        String target = new String(new char[difficulty]).replace('\0','0');
        while( !hash.substring(0, difficulty ).equals(target) ) {
            nonce++;
            hash = calculateHash();
        }

        System.out.println("Block mined : " + hash.substring(0, 10) + " -> " + nonce);
    }
}