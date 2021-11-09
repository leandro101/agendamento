package io.github.leandro101.domain.util;

public class ExceptionUtils {

    private ExceptionUtils() {
        throw new IllegalAccessError("Utility Class");
    }

    public static <T extends Exception> void throwsIfNull(final Object obj, final T exception) throws T {
        if (obj == null)
            throw exception;
    }

}
