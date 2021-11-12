package resolver;

import java.security.Security;
import org.apache.tuweni.devp2p.EthereumNodeRecord;
import org.apache.tuweni.discovery.DNSDaemon;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class DNSResolverApp {

    public static void main(final String[] args) {

        String url = "enrtree://AKA3AM6LPBYEUDMVNU3BSVQJ5AD45Y7YPOHJLEF6W26QOE4VTUDPE@all.mainnet.ethdisco.net";
        Security.addProvider(new BouncyCastleProvider());
        DNSDaemon dnsDaemon = new DNSDaemon(
                url,
                (seq, records) -> {
                    System.out.println("------");
                    for (EthereumNodeRecord enr : records) {
                        System.out.println("Ip: " + enr.ip());
                    }
                });

        dnsDaemon.start();
    }


}
