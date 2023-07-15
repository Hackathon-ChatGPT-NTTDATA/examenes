package hackathon.nttdata.coderpath.examenes.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;



@Configuration
@ConfigurationProperties
@RefreshScope
@Getter
@Setter
public class ApplicationConfiguration {
	
    @Value("${config.balanceador.test}")
    private String balanceadorTest;

}
