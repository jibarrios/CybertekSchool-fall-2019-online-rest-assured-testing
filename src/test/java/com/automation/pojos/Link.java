package com.automation.pojos;

/**
 *  {
 *     "rel": "self",
 *     "href": "http://3.85.41.58:1000/ords/hr/employees/100"
 *   }
 */
public class Link {
    private String rel;
    private String href;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Link{" +
                "rel='" + rel + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
