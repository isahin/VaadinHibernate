package com.uniyaz.ui;

import com.uniyaz.CardPanelLayout;
import com.uniyaz.components.common.Page;
import com.vaadin.ui.*;

public class SansComponent extends Page {

    private HorizontalLayout cardBodyLayout;
    private FormLayout personelFormLayout;


    private HorizontalLayout personelFormLayout1;
    private Label headerLabel;

    public SansComponent(String caption) {
        super("FİLM");
    }

    @Override
    public CardPanelLayout getCardPanelLayout() {
        CardPanelLayout cardPanelLayout = new CardPanelLayout();
        buildCardBodyLayout();
        cardPanelLayout.addComponent(cardBodyLayout);
        return cardPanelLayout;
    }

    public void buildCardBodyLayout() {

        cardBodyLayout = new HorizontalLayout();
        cardBodyLayout.setSizeFull();

        film1FormLayout();

        cardBodyLayout.addComponent(personelFormLayout);

    }

    private void film1FormLayout() {
        film1();
    }




    private void film1() {
        personelFormLayout = new FormLayout();

        Panel panel = new Panel("Film Adı: Kubilay");
        panel.addStyleName("mypanelexample");

        personelFormLayout.addComponent(panel);

        VerticalLayout personelVerticalLayout = new VerticalLayout();

        TextField txtTur = new TextField();
        txtTur.setValue("Film Türü: Tarih Filmi");
        txtTur.setReadOnly(true);
        personelVerticalLayout.addComponent(txtTur);



        TextField txtFiltre = new TextField();
        txtFiltre.setValue("Filtre: Yerli Film");
        txtFiltre.setReadOnly(true);
        personelVerticalLayout.addComponent(txtFiltre);
        personelVerticalLayout.setMargin(true);
        panel.setContent(personelVerticalLayout);
        personelVerticalLayout.setSpacing(true);
        personelFormLayout.setHeight("1000px");
    }







}