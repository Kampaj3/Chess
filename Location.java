package com.chess.common;

public class Location {
    private final File file;
    private final Integer rank;

    public Location(File file, Integer rank){
        this.file = file;
        this.rank = rank;
    }

    public File getFile() {
        return file;
    }

    public Integer getRank() {
        return rank;
    }
}
