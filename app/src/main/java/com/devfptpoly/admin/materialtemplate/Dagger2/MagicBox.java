package com.devfptpoly.admin.materialtemplate.Dagger2;

import com.devfptpoly.admin.materialtemplate.MainActivity;

import dagger.Component;

/**
 * @Component is a bridge between Module and injection
 */
@Component
public interface MagicBox {
    void poke(MainActivity mainActivity);
}
