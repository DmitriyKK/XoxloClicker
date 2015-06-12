package com.XoxloClicker.framework;

import java.util.ArrayList;

/**
 * Created by dakue_000 on 11.06.2015.
 */
public final class Signal {

    public interface Listener {
        void signalReceived(Signal.Event event);
    }

    public static class Event {
        public String ev;
        public Object obj;
        public long integer;

        public Event(String ev) {
            this(ev, null, 0);
        }

        public Event(String ev, Object obj) {
            this(ev, obj, 0);
        }

        public Event(String ev, Object obj, long integer) {
            this.ev = ev;
            this.obj = obj;
            this.integer = integer;
        }
    }

    private ArrayList<Listener> arr = new ArrayList<>();

    public void emit(String string) {
        Signal.Event event = new Signal.Event(string);
        emit(event);
    }

    public void emit(Signal.Event event) {
        for (int i = 0; i < arr.size(); ++i)
            arr.get(i).signalReceived(event);
    }

    public void addListener(Listener listener) {
        arr.add(listener);
    }
    public void addListeger(Listener[] listeners) {
        for (int i = 0; i < listeners.length; ++i) {
            arr.add(listeners[i]);
        }
    }
}
