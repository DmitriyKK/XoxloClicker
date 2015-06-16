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
        public int eventType;
        public String string;
        public Object obj;

        public Event(int eventType) { this(eventType, null, null); }

        public Event(String string) {
            this(0, string, null);
        }

        public Event(String string, Object obj) {
            this(0, string, obj);
        }

        public Event(int eventType, String string, Object obj) {
            this.eventType = eventType;
            this.string = string;
            this.obj = obj;
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

    public void addListeger(Listener listener) {
        arr.add(listener);
    }
    public void addListegers(Listener[] listeners) {
        for (int i = 0; i < listeners.length; ++i) {
            arr.add(listeners[i]);
        }
    }
}
