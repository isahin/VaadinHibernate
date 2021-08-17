package com.uniyaz.ui;

import com.uniyaz.domain.Icerik;
import com.uniyaz.utils.HibernateUtil;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SansSonuc extends GridLayout {

    private double rowCount;
    private List<Icerik> tumicerik;

    public SansSonuc() {


        tumicerik = searchIcerik();

        if (tumicerik.size() > 0) {
            rowCount = 1 ;
            buildGrid(rowCount);

        } else {

        }
    }


    public List<Icerik> searchIcerik()  {
        List<Icerik> searchIcerik = new ArrayList<Icerik>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Random random = new Random();
            int randomsayi=random.nextInt(4);


            Query query = session.createQuery("FROM Icerik WHERE id='"+randomsayi+"'");
            searchIcerik = query.list();
            session.close();
        } catch (Exception hata) {
            throw new RuntimeException(hata);
        }
        return searchIcerik;
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
            VerticalLayout questionItem = new VerticalLayout();
            questionItem.setMargin(true);
            count += 1;


            Panel panel = new Panel(String.valueOf(count)+" : "+icerik.getBaslik());
            panel.addStyleName("mypanelexample");
            questionItem.addComponent(panel);
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

            addComponent(questionItem);

        }

    }

}
