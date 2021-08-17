package com.uniyaz.components.layout;

import com.uniyaz.CardPanelLayout;
import com.uniyaz.components.common.Page;
import com.uniyaz.domain.Icerik;
import com.uniyaz.service.IcerikService;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;


public class IcerikEkle extends Page {
    private Button kaydet;
    private BeanItem<Icerik> beanItem;
    private BeanFieldGroup<Icerik> fieldGroup;

    private HorizontalLayout cardBodyLayout;
    private FormLayout personelFormLayout;
    private Button girisButton;
    private IndexedContainer indexedContainer;

    @PropertyId("baslik")
    private TextField baslik;

    @PropertyId("aciklama")
    private TextField aciklama;


    @PropertyId("publishDate")
    private DateField publishDate;



    public IcerikEkle(String caption) {
        super("");

    }

    @Override
    public CardPanelLayout getCardPanelLayout() {
        CardPanelLayout cardPanelLayout = new CardPanelLayout();
        buildCardBodyLayout();
        cardPanelLayout.addComponent(cardBodyLayout);


        fieldGroup = new BeanFieldGroup<Icerik>(Icerik.class);
        beanItem = new BeanItem<>(new Icerik());
        fieldGroup.setItemDataSource(beanItem);
        fieldGroup.bindMemberFields(this);



        return cardPanelLayout;

    }

    private void setFieldGroupItem(Icerik icerik) {
    }

    public void buildCardBodyLayout() {

        cardBodyLayout = new HorizontalLayout();

        Image image = new Image();
        cardBodyLayout.addComponent(image);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        cardBodyLayout.addComponent(horizontalLayout);
        buildPersonelFormLayout();
        buildKaydetButton();

        cardBodyLayout.addComponent(personelFormLayout);

    }

    private void buildPersonelFormLayout() {

        personelFormLayout = new FormLayout();

        baslik = new TextField();
        baslik.setWidth("400px");
        baslik.setCaption("Başlık");
        personelFormLayout.addComponent(baslik);

        aciklama = new TextField();
        aciklama.setWidth("400px");
        aciklama.setHeight("100px");
        aciklama.setCaption("Açıklama");
        personelFormLayout.addComponent(aciklama);


        publishDate = new DateField();
        publishDate.setWidth("400px");

        publishDate.setCaption("Yayın Tarihi");
        personelFormLayout.addComponent(publishDate);

    }

    private void buildKaydetButton() {
        kaydet = new Button();

        kaydet.setWidth("400px");
        kaydet.addStyleName(ValoTheme.BUTTON_PRIMARY);
        kaydet.setIcon(FontAwesome.SAVE);

        kaydet.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    fieldGroup.commit();
                    BeanItem<Icerik> itemDataSource = fieldGroup.getItemDataSource();
                    Icerik icerik = itemDataSource.getBean();
                    personelFormLayout.removeAllComponents();

                    IcerikService icerikService = new IcerikService();
                    icerikService.save(icerik);

                } catch (FieldGroup.CommitException e) {
                    e.printStackTrace();
                }
                baslik.clear();
                aciklama.clear();
                publishDate.clear();
            }
        });
        personelFormLayout.addComponent(kaydet);
    }

}