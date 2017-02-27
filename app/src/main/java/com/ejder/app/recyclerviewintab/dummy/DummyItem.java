package com.ejder.app.recyclerviewintab.dummy;

/**
 * Created by ejder on 27.02.2017.
 */

/**
 * A dummy item representing a piece of content.
 */
public class DummyItem {
    public final Integer id;
    public final String content;
    public final String details;

    public DummyItem(Integer id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}
