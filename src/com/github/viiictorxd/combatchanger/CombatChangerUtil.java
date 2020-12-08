package com.github.viiictorxd.combatchanger;

public class CombatChangerUtil {

    public static int getInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException ignored) {
            return -1;
        }
    }
}
