package com.uniyaz.components.layout;

import com.uniyaz.*;
import com.uniyaz.ui.AramaSonuc;
import com.uniyaz.ui.SansSonuc;
import com.vaadin.ui.*;

public class AramaSonucPage extends VerticalLayout {


    public AramaSonucPage () {
        setSizeFull();
        setHeight(null);
        aramaBar();
        buildAramaSonucPageLayout();

    }
    TextField searchBar = new TextField();

    private void aramaBar() {

        searchBar.setWidth("500px");
        searchBar.setInputPrompt("Lütfen kelimeyi yazınız ");
        addComponent(searchBar);
        setComponentAlignment(searchBar, Alignment.MIDDLE_CENTER);

    }

    private void buildAramaSonucPageLayout() {
        HorizontalLayout searcLayout = new HorizontalLayout();

        searcLayout.setMargin(true);
        searcLayout.setSpacing(true);


        Button girisButton = new Button("ARAMA YAPINIZ");
        girisButton.setSizeUndefined();
        girisButton.setWidth("245px");
        girisButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AramaSonuc sayfaComponent = new AramaSonuc(searchBar.getValue());
                VerticalLayout contentLayout = ((MyUI) MyUI.getCurrent()).getContentLayout();
                contentLayout.removeAllComponents();


                Label headerLabel = new Label();
                headerLabel.setCaptionAsHtml(true);

                contentLayout.addComponent(sayfaComponent);


                contentLayout.setSizeFull();

            }
        });

        Button sansliButton = new Button("Kendimi Şanşlı Hissediyorum");
        sansliButton.setSizeUndefined();
        sansliButton.setWidth("245px");
        sansliButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SansSonuc sansComponent = new SansSonuc();
                VerticalLayout contentLayout = ((MyUI) MyUI.getCurrent()).getContentLayout();
                contentLayout.removeAllComponents();

                contentLayout.addComponent(sansComponent);


                contentLayout.setSizeFull();


            }
        });

        searcLayout.addComponent(girisButton);
        searcLayout.addComponent(sansliButton);
        addComponent(searcLayout);
        searcLayout.setSizeUndefined();
        this.setComponentAlignment(searcLayout, Alignment.TOP_CENTER);

    }
}