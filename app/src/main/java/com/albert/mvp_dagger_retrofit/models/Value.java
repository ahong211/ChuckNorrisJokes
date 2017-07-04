package com.albert.mvp_dagger_retrofit.models;


import java.util.List;

public class Value {

    private Integer id;
    private String joke;
    private List<Object> categories = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Value{" +
                "joke='" + joke + '\'' +
                '}';
    }
}
