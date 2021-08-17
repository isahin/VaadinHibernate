package com.uniyaz;

import com.uniyaz.components.layout.AramaSonucPage;
import com.uniyaz.components.layout.HeaderPage;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class MyUI extends UI {

    private VerticalLayout mainLayout;
    private VerticalLayout bodyLayout;
    private HeaderPage headerPageLayout;
    private AramaSonucPage aramaSonucPage;
    private VerticalLayout contentLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        buildMainLayout();
        setContent(mainLayout);
    }

    private void buildMainLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        buildBodyLayout();
        mainLayout.addComponent(bodyLayout);
    }

    private void buildBodyLayout() {

        bodyLayout = new VerticalLayout();
        bodyLayout.setSizeFull();

        headerPageLayout = new HeaderPage();
        bodyLayout.addComponent(headerPageLayout);

        aramaSonucPage = new AramaSonucPage();
        bodyLayout.addComponent(aramaSonucPage);

        buildContentLayout();
        bodyLayout.addComponent(contentLayout);

        bodyLayout.setExpandRatio(headerPageLayout, 0.2f);
        bodyLayout.setExpandRatio(aramaSonucPage, 0.1f);

        bodyLayout.setExpandRatio(contentLayout, 0.7f);
    }


    private void buildContentLayout() {
        contentLayout = new VerticalLayout();
        contentLayout.setSizeFull();
    }

    public VerticalLayout getContentLayout() {
        return contentLayout;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
