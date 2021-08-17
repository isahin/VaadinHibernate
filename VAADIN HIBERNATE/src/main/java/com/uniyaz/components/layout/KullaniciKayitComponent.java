package com.uniyaz.components.layout;

import com.uniyaz.CardPanelLayout;
import com.uniyaz.components.common.Page;
import com.uniyaz.domain.Kullanicilar;
import com.uniyaz.service.KullaniciService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class KullaniciKayitComponent extends Page {
    private BeanItem<Kullanicilar> beanItem;
    private BeanFieldGroup<Kullanicilar> fieldGroup;

    @PropertyId("kullaniciAdi")
    private TextField kullaniciAdi;
    @PropertyId("sifre")
    private TextField sifre;











    private HorizontalLayout cardBodyLayout;
    private FormLayout personelFormLayout;
    private Button kayitButton;
    public KullaniciKayitComponent(String caption) {
        super("");

    }

    @Override
    public CardPanelLayout getCardPanelLayout() {
        CardPanelLayout cardPanelLayout = new CardPanelLayout();
        buildCardBodyLayout();
        cardPanelLayout.addComponent(cardBodyLayout);

        fieldGroup = new BeanFieldGroup<Kullanicilar>(Kullanicilar.class);
        beanItem = new BeanItem<>(new Kullanicilar());
        fieldGroup.setItemDataSource(beanItem);
        fieldGroup.bindMemberFields(this);


        return cardPanelLayout;

    }


    public void buildCardBodyLayout() {

        cardBodyLayout = new HorizontalLayout();

        Image image = new Image();
        cardBodyLayout.addComponent(image);

        buildPersonelFormLayout();



        cardBodyLayout.addComponent(personelFormLayout);

    }



    private void buildPersonelFormLayout() {

        personelFormLayout = new FormLayout();

        kullaniciAdi = new TextField();
        kullaniciAdi.setWidth("250px");
        kullaniciAdi.setCaption("Adınız");
        personelFormLayout.addComponent(kullaniciAdi);

        sifre = new TextField();
        sifre.setWidth("250px");
        sifre.setCaption("Şifreniz");
        personelFormLayout.addComponent(sifre);

        kayitButton = new Button();
        kayitButton.setWidth("250px");
        kayitButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        kayitButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        kayitButton.setIcon(FontAwesome.SAVE);
        kayitButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                try {
                    fieldGroup.commit();
                    BeanItem<Kullanicilar> itemDataSource = fieldGroup.getItemDataSource();
                    Kullanicilar kullanicilar = itemDataSource.getBean();
                    personelFormLayout.removeAllComponents();
                    KullaniciService kullaniciService = new KullaniciService();
                    kullaniciService.save(kullanicilar);



                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }
                kullaniciAdi.clear();
                sifre.clear();
            }

        });

        personelFormLayout.addComponent(kayitButton);

    }


}