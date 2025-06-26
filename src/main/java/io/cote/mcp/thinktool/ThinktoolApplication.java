package io.cote.mcp.thinktool;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThinktoolApplication {

	@Bean
	public ToolCallbackProvider oracle(ThinkTool tool) {
		return MethodToolCallbackProvider.builder().toolObjects(tool).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ThinktoolApplication.class, args);
	}

}
