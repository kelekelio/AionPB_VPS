package pl.aionpb.aionpb_vps.translation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * @author Grzegorz Nowakowski
 */

@Entity
@Table(name = "translation")
public class TranslationEntity {

    @Id
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String body;

    @Column(name = "LAN_EN")
    private String en;

    @Column(name = "LAN_DE")
    private String de;

    @Column(name = "LAN_FR")
    private String fr;

    @Column(name = "LAN_ES")
    private String es;

    @Column(name = "LAN_IT")
    private String it;

    @Column(name = "LAN_PL")
    private String pl;

    @Column(name = "LAN_KO")
    private String ko;

    @Column(name = "LAN_US")
    private String us;

    @Column(name = "LAN_CN")
    private String cn;


    public TranslationEntity(Integer id, String name, String body, String en, String de, String fr, String es, String it, String pl, String ko, String us, String cn) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.en = en;
        this.de = de;
        this.fr = fr;
        this.es = es;
        this.it = it;
        this.pl = pl;
        this.ko = ko;
        this.us = us;
        this.cn = cn;
    }

    public TranslationEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getKo() {
        return ko;
    }

    public void setKo(String ko) {
        this.ko = ko;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @JsonIgnore
    public String getLocaString () {

        String loca;
        String code = Settings.getLocaCode();

        switch (code) {
            case "en":
                loca = (en != null) ? en : body;
                break;
            case "de":
                loca =  (de != null) ? de : body;
                break;
            default:
                loca =  (body != null) ? body : name;
        }

        if (name == null) {
            return loca;
        } else {
            return loca.replaceAll("&apos;", "'");
        }

    }
}
