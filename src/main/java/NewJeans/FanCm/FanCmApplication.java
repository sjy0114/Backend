package NewJeans.FanCm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("domain")
public class FanCmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FanCmApplication.class, args);
	}

}
