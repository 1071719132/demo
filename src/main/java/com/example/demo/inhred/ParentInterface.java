package com.example.demo.inhred;

public interface ParentInterface {

    public void action();

    /**
     * de
     */
    default void defaultAction() {

    }

    default void do2() {

    }
}
