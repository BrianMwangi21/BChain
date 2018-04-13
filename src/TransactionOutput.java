import java.security.PublicKey;

public class TransactionOutput {
    public String id;
    public PublicKey recepient;
    public float value;
    public String parentTransactioId;

    public TransactionOutput(PublicKey recepient, float value, String parentTransactioId) {
        this.recepient = recepient;
        this.value = value;
        this.parentTransactioId = parentTransactioId;
        this.id = StringUtil.hashString(StringUtil.getStringFromKey(recepient) + Float.toString(value) + parentTransactioId );
    }

    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recepient);
    }

}
