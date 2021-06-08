package kodlamaio.hrms.core.utilities.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Configuration
@EnableSwagger2
public class Beans {

	@Bean
	public KPSPublicSoapProxy kpsPublicSoapProxy() {

		return new KPSPublicSoapProxy();
	}
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms"))                                      
          .build();                                           
    } 
}
