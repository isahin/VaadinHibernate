package com.uniyaz.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ICERIK")
public class Icerik {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @Column(name = "BASLIK", length = 100)
        private String baslik;

        @Column(name = "ACIKLAMA", length = 254)
        private String aciklama;

        @Column(name = "PUBLISH_DATE")
        private String publishDate;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getBaslik() {
                return baslik;
        }

        public void setBaslik(String baslik) {
                this.baslik = baslik;
        }

        public String getAciklama() {
                return aciklama;
        }

        public void setAciklama(String aciklama) {
                this.aciklama = aciklama;
        }

        public String getPublishDate() {
                return publishDate;
        }

        public void setPublishDate(String  publishDate) {
                this.publishDate = publishDate;
        }
}

