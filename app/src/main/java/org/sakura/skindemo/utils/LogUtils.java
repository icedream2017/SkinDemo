package org.sakura.skindemo.utils;

import android.util.Log;

@SuppressWarnings("unused")
public final class LogUtils {

    public static boolean DEBUG_MODE = false;
    public static final String LEVEL_VERBOSE = "VERBOSE";
    public static final String LEVEL_DEBUG = "DEBUG";
    public static final String LEVEL_INFO = "INFO";
    public static final String LEVEL_WARN = "WARN";
    public static final String LEVEL_ERROR = "ERROR";
    public static final String TAG_TRACE = "TRACE";

    public static boolean isDebugMode() {
        return DEBUG_MODE;
    }

    public static void setDebugMode(boolean debugMode) {
        DEBUG_MODE = debugMode;
    }

    public static void v(String tag, String msg) {
        if (DEBUG_MODE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG_MODE) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void printCurrentStackTrace() {
        if (DEBUG_MODE) {
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            StackTraceElement log = stack[2];
            String output = log.getClassName() + '/' +
                    log.getMethodName() + '/' +
                    log.getLineNumber();
            Log.d(TAG_TRACE, output);
        }
    }

    private static void output(String level, String tag, String msg) {
        String output = level + '/' + tag + ": " + msg;
        System.out.println(output);
    }

}
