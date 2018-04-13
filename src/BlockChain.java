import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Scanner;

public class BlockChain {
    private ArrayList<Block> blockchain;
    private Scanner input;

    public BlockChain() {
        this.blockchain = new ArrayList<>();
        this.input = new Scanner( System.in );
        generateGenesisBlock();
    }

    private void generateGenesisBlock() {
        blockchain.add( new Block("0", "This is thy Genesis Block") );
    }

    public void createBlock() {
        System.out.print("Enter data to enter in new block : ");
        String data = input.nextLine();
        blockchain.add( new Block( getLastBlock().hash, data ) );
    }

    public Block getLastBlock() {
        return blockchain.get( blockchain.size() - 1 );
    }

    public void printDetails() {
        String details = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(details);
    }
}
