package com.chess.common;

public class Locator {
    private static final File[] files = File.values();
    public static Location build(Location current, Integer fileOffset, Integer rankOffset){
        Integer currentfile = current.getFile().ordinal();
        return new Location(files[currentfile + fileOffset], current.getRank() + rankOffset);
    }
}
