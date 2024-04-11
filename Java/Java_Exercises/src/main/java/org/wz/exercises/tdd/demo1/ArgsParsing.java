package org.wz.exercises.tdd.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class ArgsParsing {

    public static <T> T parsing(Class<T> optionsClass, String... args) {
        try {
            Constructor<?> constructor = optionsClass.getDeclaredConstructors()[0];
            Parameter parameter = constructor.getParameters()[0];
            Option annotation = parameter.getAnnotation(Option.class);
            List<String> argList = Arrays.asList(args);
            return (T)constructor.newInstance(argList.contains("-" + annotation.value()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
