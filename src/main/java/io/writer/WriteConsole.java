package io.writer;

public class WriteConsole implements Writer {

    @Override
    public void write(String thing) {
        System.out.print(thing + " ");
    }
}