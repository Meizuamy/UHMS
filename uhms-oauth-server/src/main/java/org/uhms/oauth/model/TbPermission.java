package org.uhms.oauth.model;

import javax.xml.crypto.Data;

public class TbPermission {
    private Long id;
    private Long parent_id;
    private String name;
    private String enname;
    private String url;
    private String descrption;
    private Data created;
    private Data updated;

    public TbPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Data getCreated() {
        return created;
    }

    public void setCreated(Data created) {
        this.created = created;
    }

    public Data getUpdated() {
        return updated;
    }

    public void setUpdated(Data updated) {
        this.updated = updated;
    }

    public TbPermission(Long id, Long parent_id, String name, String enname, String url, String descrption, Data created, Data updated) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.enname = enname;
        this.url = url;
        this.descrption = descrption;
        this.created = created;
        this.updated = updated;
    }
}
