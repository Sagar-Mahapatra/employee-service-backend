package in.nareshit.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.messages")
public class AppProperties {

	private String saveEmployeeSuccess;
	private String updateEmployeeSuccess;
	private String updateEmployeeNameSuccess;
	private String updateEmployeeNameError;
	private String deleteEmployeeSuccess;

}
