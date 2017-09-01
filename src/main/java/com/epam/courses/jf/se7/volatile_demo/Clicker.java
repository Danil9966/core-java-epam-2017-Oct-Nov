package com.epam.courses.jf.se7.volatile_demo;

class Clicker extends Thread {

    int click = 0;
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    public void stopClick() {
        running = false;
    }
}

