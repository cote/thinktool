A "thinking tool" based on
[the Anthropic blog post on this topic](https://www.anthropic.com/engineering/claude-think-tool). 
More [background here](https://simonwillison.net/2025/Mar/21/the-think-tool/).
 
The thinking tool requires Java 17. Written as a [Spring AI MCP tool](https://docs.spring.io/spring-ai-mcp/reference/spring-mcp.html), using STDIO or SSE depending on how you configure it.

After you build it, to run it in STDIO mode for Claude Desktop, place the JAR file somewhere and add the io.cote.ThinkTool block to your <code>claude_desktop_config.json</code> file like this: 

<pre>
{
  "mcpServers": {
    "io.cote.ThinkTool": {
      "command": "java",
      "args": [
        "-jar",
        "/Users/[YOUR HOME DIR]/projects/thinktool/target/thinktool-0.0.1-SNAPSHOT.jar"
      ],
      "env": {}
    }
  }
}
</pre>


To run it in SSE mode, you need to ignore the default application.properties and use application-sse-properties, like this:

<pre>
java -jar target/thinktool-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application-sse.properties
</pre>

Logs are placed in <code>/Library/Logs/io.cote.thinktool/thinktool.log</code> you can change the location by passing in the <code>logging.file.name</code> property like:

<pre>
java -jar target/thinktool-0.0.1-SNAPSHOT.jar --logging.file.name=/new/log/directory/thinktool.log
</pre>
