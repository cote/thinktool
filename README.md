A "thinking tool" based on
[the Anthropic blog post on this topic](https://www.anthropic.com/engineering/claude-think-tool). 
More [background here](https://simonwillison.net/2025/Mar/21/the-think-tool/).
 
The thinking tool requires Java 21. Written as a [Spring AI MCP tool](https://docs.spring.io/spring-ai-mcp/reference/spring-mcp.html), using STDIO or SSE depending on which Spring Boot profile you run it with.

After you build it, to run it in STDIO mode for Claude Desktop, place the JAR file somewhere and add the io.cote.ThinkTool block to your <code>claude_desktop_config.json</code> file like this: 

<pre>
{
  "mcpServers": {
    "io.cote.ThinkTool": {
      "command": "java",
      "args": [
        "-jar",
        "/Users/cote/projects/thinktool/target/thinktool-0.0.1-SNAPSHOT.jar",
        "--spring.profiles.active=stdio"
      ],
      "env": {"LOGGING_LEVEL_IO_COTE_MCP_THINKTOOL": "INFO"}
    }
  }
}
</pre>

To run it in SSE mode, use the sse Spring Boot profile like this:

<pre>
java -jar target/thinktool-0.0.1-SNAPSHOT.jar --spring.profiles.active=sse
</pre>

In STDIO mode, logs are placed in <code>/Library/Logs/io.cote.thinktool/thinktool.log</code> you can change the location by passing in the <code>logging.file.name</code> property like:

<pre>
java -jar target/thinktool-0.0.1-SNAPSHOT.jar --spring.profiles.active=stdio --logging.file.name=/new/log/directory/thinktool.log
</pre>
