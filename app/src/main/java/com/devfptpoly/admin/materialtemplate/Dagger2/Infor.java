package com.devfptpoly.admin.materialtemplate.Dagger2;

import javax.inject.Inject;

public class Infor {

    private String text = "Simple dagger2";

    /**
     * @Inject annotation is [Injection], you can able to addition @Inject anywhere Class/Object that you want
     * => Dagger will be connected between @Inject that you added to the [Interface (@Component)].
     */

    @Inject
    public Infor() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
