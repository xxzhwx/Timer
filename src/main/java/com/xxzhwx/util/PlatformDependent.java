package com.xxzhwx.util;

import java.util.Locale;

public final class PlatformDependent {
    private static final boolean IS_WINDOWS = isWindows0();

    public static boolean isWindows() {
        return IS_WINDOWS;
    }

    private static boolean isWindows0() {
        return SystemPropertyUtil.get("os.name", "").toLowerCase(Locale.US).contains("win");
    }
}
