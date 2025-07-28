package io.cote.mcp.thinktool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;


/**
 * A "thinking tool" based on
 * <a href="https://www.anthropic.com/engineering/claude-think-tool"></a>the Anthropic blog post on this topic</a>.
 * More <a href="https://simonwillison.net/2025/Mar/21/the-think-tool/">background here</a>.
 * <p>
 * The thinking tool just takes the input and returns it. This gives the MCP Client the chance to use it as a scratchpad
 * - it takes "time" to think something when it makes the tool call, generates the thought, and then puts it in the
 * context window for later. Depending on the UI implementation, this also means that the user does not see the result
 * of the thinking.
 */
@Service
public class ThinkTool {

    private final Logger logger = LoggerFactory.getLogger(ThinkTool.class);

    @Tool(name = "CoteIndustries_ThinkTool", description = """
                                   Use the tool to think about something. 
                                   It will not obtain new information or change the database, 
                                   but just append the thought to the log/context window. 
                                   Use it when complex reasoning or some cache memory is needed.
                                                           """)
    public String think(@ToolParam(description = "Your thoughts", required = true) String thoughts,
                                                                                   ToolContext toolContext) {
        logger.debug("ThinkTool called with thoughts: {}", thoughts);
        return "I'm thinking about <thoughts>" + thoughts + "</thoughts>";
    }
}
