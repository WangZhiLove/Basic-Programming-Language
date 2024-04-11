package org.wz.exercises.tdd.demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLineParameterParsingTest {

    // 解析 -l -p 8080 -d /usr/logs　
    /*@Test
    public void testParsing() {
        Options options = ArgsParsing.parsing(Options.class, "-l", "-p", "8080", "-d", "/usr/logs");
        options.logging();
        options.port();
        options.directory();

    }

    static record Options(@Option("l") boolean logging, @Option("p") int port, @Option("d") String directory) {

    };*/

    // 解析 -l
    @Test
    public void test_set_boolean_is_true_if_option_is_present() {
        BooleanOptions booleanOptions = ArgsParsing.parsing(BooleanOptions.class, "-l");
        assertTrue(booleanOptions.logging());
    }

    @Test
    public void test_set_boolean_is_false_if_option_is_not_present() {
        BooleanOptions booleanOptions = ArgsParsing.parsing(BooleanOptions.class);
        assertFalse(booleanOptions.logging());
    }

    static record BooleanOptions(@Option("l") boolean logging) {
    }


}
