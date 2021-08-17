package com.uniyaz.ui;

import com.uniyaz.domain.Icerik;
import com.uniyaz.utils.HibernateUtil;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;


public class AramaSonuc extends GridLayout {

    private double rowCount;
    private List<Icerik> tumicerik;
    private IndexedContainer indexedContainer;
    String Java = "Java";
    List<Icerik> icerikList = new ArrayList<Icerik>();



    public List<Icerik> listicerik() {



        return icerikList;
    }


    public AramaSonuc(String value) {

        System.out.println(value);

        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Icerik WHERE baslik='"+value+"'";
        Query query = session.createQuery(hql);
        icerikList = query.list();
        session.close();


        tumicerik = listicerik();

        if (tumicerik.size() > 0) {
            rowCount = 1 ;
            buildGrid(rowCount);

        } else {

        }

    }

    private void buildGrid(double rowCount) {
        addStyleName("outlined");
        setSizeFull();
        fillItemsGrid((int) rowCount, 2);
        setMargin(true);
        setSpacing(true);
    }

    private void fillItemsGrid(final int rows, final int columns) {

        this.setMargin(true);
        removeAllComponents();
        setRows(rows);
        setColumns(columns);

        int count = 0;

        for (Icerik icerik : tumicerik) {
            VerticalLayout icerikItem = new VerticalLayout();
            icerikItem.setMargin(true);
            count += 1;


            Panel panel = new Panel(String.valueOf(count)+" : "+icerik.getBaslik());
            panel.addStyleName("mypanelexample");
            icerikItem.addComponent(panel);
            VerticalLayout verlayout = new VerticalLayout();


            Label lbl = new Label();
            lbl.setValue(icerik.getAciklama());
            if (icerik.getAciklama().length()>200){
                lbl.setValue(icerik.getAciklama().substring(0,200)+"...");
            } else {
                lbl.setContentMode(ContentMode.HTML);
                lbl.setValue("<p>"+icerik.getAciklama() +"<p/>" + " ...");

            }
            verlayout.addComponent(lbl);

            Label tarihLabel = new Label();
            tarihLabel.setValue(icerik.getPublishDate());
            verlayout.setSpacing(true);
            verlayout.setMargin(true);
            verlayout.addComponent(tarihLabel);

            panel.setContent(verlayout);
            addComponent(icerikItem);

        }

    }


}
