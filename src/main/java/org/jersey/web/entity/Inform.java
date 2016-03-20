package org.jersey.web.entity;

import org.springframework.stereotype.Component;

/**
 * Created by nandaye on 2016/3/12 11:53.
 */
@Component("inform")
public class Inform {
    private String Title;
    private String name;

    public Inform() {
    }

    public Inform(String name, String title) {
        this.name = name;
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inform{" +
                "name='" + name + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
}
