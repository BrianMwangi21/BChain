import java.security.*;
import java.util.ArrayList;

public class Transaction {
    public String transactionId;
    public PublicKey sender, recepient;
    public float value;
    public byte[] signature;

    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    private static int sequence = 0;

    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs ) {
        this.sender = from;
        this.recepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    // Calculates hash used as Id
    private String calculateHash() {
        sequence++;
        return StringUtil.hashString(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(recepient) +
                        Float.toString(value) + sequence
        );
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recepient) + Float.toString(value);
        signature = StringUtil.applyECDSASig(privateKey,data);
    }

    public boolean verifySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(recepient) + Float.toString(value);
        return StringUtil.verifyECDSASig(sender, data, signature);
    }
}
