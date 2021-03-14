package cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author simple
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider9002.class, args);
    }
}
