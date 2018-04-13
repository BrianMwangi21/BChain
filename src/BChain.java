public class BChain {

    public static void main(String[] args) {
        BlockChain bchain = new BlockChain();

        for( int i = 0; i < 3; ++i ) {
            bchain.createBlock();
        }

        bchain.printDetails();

        // Check if chain is valid
        if( bchain.isChainValid() ) {
            System.out.println("Chain is valid");
        }else {
            System.out.println("Chain is not valid");
        }
    }
}
