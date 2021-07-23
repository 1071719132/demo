package com.example.demo.event;

import java.util.EventObject;

public class DemoEvent extends EventObject {

    public DemoEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
