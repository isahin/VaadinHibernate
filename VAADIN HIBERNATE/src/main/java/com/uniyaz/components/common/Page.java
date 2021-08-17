package com.uniyaz.components.common;

import com.uniyaz.CardPanelLayout;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.swing.*;

public abstract class Page extends VerticalLayout {


    private Label title;
    private String caption;
    private Panel cardPanel;

    public Page(String caption) {
        this.caption = caption;
        buildLayout();
    }

    private void buildLayout() {

        buildTitle();
        buildCardPanel();




        addComponent(title);
        setComponentAlignment(title, Alignment.MIDDLE_CENTER);

        addComponent(cardPanel);
        setComponentAlignment(cardPanel, Alignment.MIDDLE_CENTER);


        setExpandRatio(title, 0.1f);
        setExpandRatio(cardPanel, 0.9f);
    }

    private void buildTitle() {

        title = new Label();
        title.addStyleName(ValoTheme.LABEL_COLORED);
        title.setSizeUndefined();
        title.addStyleName(ValoTheme.LABEL_H1);



        title.addStyleName(ValoTheme.LABEL_BOLD);
        title.setValue(caption);




    }

    private void buildCardPanel() {

        cardPanel = new Panel();
        cardPanel.setSizeUndefined();
        cardPanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        CardPanelLayout cardPanelLayout = getCardPanelLayout();
        cardPanel.setContent(cardPanelLayout);
    }




    public abstract CardPanelLayout getCardPanelLayout();
}