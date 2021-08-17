package com.uniyaz.components.layout;

import com.uniyaz.MyUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderPage extends HorizontalLayout {
        private FormLayout formLayout;




    public HeaderPage(){

            setSizeFull();
            buildHeaderLayout();

        }

    private void buildHeaderLayout() {
        Label headerBosluk= new Label("");
        addComponent(headerBosluk);

        Label headerLabel= new Label("VADDIN - HEADER ");
        headerLabel.setSizeUndefined();
        addComponent(headerLabel);


        this.setSpacing(true);
        headerLabel.addStyleName(ValoTheme.LABEL_H1);
        setComponentAlignment(headerLabel, Alignment.MIDDLE_CENTER);





        Button girisButton = new Button("GİRİŞ YAP");
        girisButton.setSizeUndefined();
        girisButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {


                KullaniciGirisComponent quest = new KullaniciGirisComponent("");
                VerticalLayout contentLayout = ((MyUI) MyUI.getCurrent()).getContentLayout();
                contentLayout.removeAllComponents();
                contentLayout.addComponent(quest);
                contentLayout.setSizeFull();


            }
        });

        addComponent(girisButton);
        setComponentAlignment(girisButton, Alignment.MIDDLE_CENTER);

        setExpandRatio(headerBosluk, 1f);
        setExpandRatio(headerLabel, 9f);
        setExpandRatio(girisButton, 1f);




    }


}
