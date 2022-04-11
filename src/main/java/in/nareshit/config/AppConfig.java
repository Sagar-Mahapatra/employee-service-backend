package in.nareshit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}

	/**
	 * If we want to disable zipkin server(UI) & sleuth(generates spanId & TraceId)
	 * temporarily, we have use the Sampler object. TraceId indicates unique id for
	 * each request SpanId indicates unique id for each MS
	 */
	/*
	 * @Bean public Sampler sampleObj() { return Sampler.ALWAYS_SAMPLE; // return
	 * Sampler.NEVER_SAMPLE; }
	 */

}
