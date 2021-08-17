package com.uniyaz.ui;

import com.uniyaz.CardPanelLayout;
import com.uniyaz.MyUI;
import com.uniyaz.components.common.Page;
import com.uniyaz.components.layout.AramaSonucPage;
import com.uniyaz.components.layout.HeaderPage;
import com.uniyaz.components.layout.IcerikEkle;
import com.uniyaz.components.layout.KullaniciKayitComponent;
import com.vaadin.ui.*;

public class Yonetim extends Page {

    private HorizontalLayout cardBodyLayout;
    private FormLayout personelFormLayout;


    private HorizontalLayout personelFormLayout1;
    private Label headerLabel;

    public Yonetim(String caption) {
        super("");
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


        yonetim();

        cardBodyLayout.addComponent(personelFormLayout);

    }

    private void yonetim() {
        personelFormLayout = new FormLayout();

        Panel panel = new Panel("Yönetim Paneli");

        personelFormLayout.addComponent(panel);

        HorizontalLayout personelVerticalLayout = new HorizontalLayout();



        Button konuEkle = new Button("Konu Ekle");
        konuEkle.setWidth("300px");
        konuEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


                IcerikEkle icerikEkle = new IcerikEkle("");
                personelFormLayout.addComponent(icerikEkle);


            }
        });
        personelVerticalLayout.addComponent(konuEkle);

        Button kullaniciEkle = new Button("Kullanıcı Ekle");
        kullaniciEkle.setWidth("300px");
        kullaniciEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


                KullaniciKayitComponent kullaniciKayitComponent = new KullaniciKayitComponent("Kullanıcı Ekle");

                personelFormLayout.addComponent(kullaniciKayitComponent);


            }
        });
        personelVerticalLayout.addComponent(kullaniciEkle);


        personelVerticalLayout.setMargin(true);
        panel.setContent(personelVerticalLayout);
        personelVerticalLayout.setSpacing(true);

    }
}