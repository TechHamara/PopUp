package com.th.PopUp;

import android.app.Activity;

import android.content.Context;

import com.google.appinventor.components.annotations.*;

import com.google.appinventor.components.annotations.SimpleFunction;

import com.google.appinventor.components.annotations.SimpleProperty;

import com.google.appinventor.components.common.ComponentCategory;

import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;

import com.google.appinventor.components.runtime.ComponentContainer;

import com.google.appinventor.components.runtime.EventDispatcher;

import com.google.appinventor.components.runtime.AndroidViewComponent;

import android.widget.PopupMenu;

import android.view.View;

import android.widget.AdapterView;

import android.view.MenuItem;

import java.util.List;

@DesignerComponent(

        version = 1,

        description = "",

        category = ComponentCategory.EXTENSION,

        nonVisible = true,

        iconName = "")

@SimpleObject(external = true)

public class PopUp extends AndroidNonvisibleComponent {

    private Context context;

    private Activity activity;

    private PopupMenu popup;

    public PopUp(ComponentContainer container){

        super(container.$form());

        this.activity = container.$context();

        this.context = container.$context();

    }

    @SimpleFunction(description = "Creates popup menu")

    public void Create(AndroidViewComponent component) {

        View view = component.getView(); 

        popup = new PopupMenu(context, view);

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    public boolean onMenuItemClick(MenuItem item) {

                        OnClick (item.getTitle().toString());

                        return true;

                    }

                });

    }

    @SimpleProperty(description = "Add item in popup menu")

    public void Add(String name) {

        popup.getMenu().add(name);

    }

    @SimpleFunction(description = "Show popup menu")

    public void Show() {

        popup.show();

    }

    

    @SimpleEvent(description = "")

    public void OnClick (String name) {

        EventDispatcher.dispatchEvent(this, "OnClick", name);

    }

}
