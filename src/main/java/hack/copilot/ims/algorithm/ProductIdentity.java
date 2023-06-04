package hack.copilot.ims.algorithm;

import java.util.UUID;

public class ProductIdentity {
    //algorithm to generate product id using uuid
    public String generateProductId() {
        return UUID.randomUUID().toString();
    }
}
