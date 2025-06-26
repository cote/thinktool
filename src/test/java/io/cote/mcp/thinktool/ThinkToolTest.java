package io.cote.mcp.thinktool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThinkToolTest {

    @Test
    void testThinkReturnsFormattedThought() {
        ThinkTool tool = new ThinkTool();
        String input = "the unit test would like me to think about testing the Thinking tool";
        String result = tool.think(input);
        assertEquals("I'm thinking about <thoughts>"+input+"</thoughts>", result);
    }
}
