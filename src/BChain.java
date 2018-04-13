import java.security.Security;

public class BChain {
    public static Wallet walletA, walletB;

    public static void main(String[] args) {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        walletA = new Wallet();
        walletB = new Wallet();

        // Print sample keys
        System.out.println("Keys : ");
        System.out.println("Public A : " + StringUtil.getStringFromKey(walletA.publicKey));
        System.out.println("Public B : " + StringUtil.getStringFromKey(walletB.publicKey));

        // Test transaction
        Transaction transaction = new Transaction(walletA.publicKey, walletB.publicKey, 5, null);
        transaction.generateSignature(walletA.privateKey);

        // Verify
        System.out.println("Result : " + transaction.verifySignature());
    }
}
