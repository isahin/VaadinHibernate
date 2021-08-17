package com.uniyaz.components.layout;

import com.uniyaz.CardPanelLayout;
import com.uniyaz.MyUI;
import com.uniyaz.components.common.Page;
import com.uniyaz.domain.Icerik;
import com.uniyaz.domain.Kullanicilar;
import com.uniyaz.service.KullaniciService;
import com.uniyaz.ui.Yonetim;
import com.uniyaz.utils.HibernateUtil;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

public class KullaniciGirisComponent extends Page {

    List<Icerik> icerikList = new ArrayList<Icerik>();
    private BeanItem<Kullanicilar> beanItem;
    private BeanFieldGroup<Kullanicilar> fieldGroup;

    @PropertyId("kullaniciAdi")
    private TextField kullaniciAdi;
    @PropertyId("sifre")
    private TextField sifre;




    private HorizontalLayout cardBodyLayout;
    private FormLayout personelFormLayout;
    private Button girisButton;
    public KullaniciGirisComponent(String caption) {
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

        kullaniciAdi.setCaption("Adınız");

        personelFormLayout.addComponent(kullaniciAdi);

        sifre = new TextField();
        sifre.setCaption("Şifreniz");


        personelFormLayout.addComponent(sifre);

        girisButton = new Button();
        girisButton.setWidth("185px");
        girisButton.addStyleName(ValoTheme.BUTTON_HUGE);
        girisButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        girisButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        girisButton.setIcon(FontAwesome.USER);
        girisButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                KullaniciService kullaniciService = new KullaniciService();
                Kullanicilar kullanicilar = kullaniciService.findKullanicilar(kullaniciAdi.getValue(), sifre.getValue());

                if (kullanicilar != null) {

                    Yonetim quest = new Yonetim("");
                    VerticalLayout contentLayout = ((MyUI) MyUI.getCurrent()).getContentLayout();
                    contentLayout.removeAllComponents();
                    contentLayout.addComponent(quest);
                    contentLayout.setSizeFull();

                } else {
                    Notification.show(  "Kullanıcı Adınız veya Şifreniz Hatalı ");
                }




            }

        });

        personelFormLayout.addComponent(girisButton);


    }
}