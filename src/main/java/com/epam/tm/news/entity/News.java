package com.epam.tm.news.entity;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;


@NamedQueries({
        @NamedQuery(name = "findById", query = "from News where id = :id"),
        @NamedQuery(name = "delete", query = "delete News where id = :id"),
        @NamedQuery(name = "getListByDate", query = "from News order by date desc"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "insert", query = "insert into News values(NEWS_SEQ.nextval, :title, :datetime, :brief, :content)"),
        @NamedNativeQuery(name = "update", query = "UPDATE News SET title = :title, dateapp = :datetime," +
                "brief = :brief, content = :content WHERE id = :id"),
        @NamedNativeQuery(name = "lastId", query = "SELECT NEWS_SEQ.currval FROM dual")
})

@XmlRootElement(name = "news")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "news", propOrder = {"title", "date", "brief", "content"})
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity implements Serializable{
    @Column(name = "TITLE", nullable = false, length = 64)
    private String title;
    @Column(name = "dateApp", nullable = false)
    private Date date;
    @Column(name = "BRIEF", length = 512)
    private String brief;
    @Column(name = "CONTENT", length = 2048)
    private String content;

    public News() {
        title = "";
        date = new Time(0);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        if (!super.equals(o)) return false;

        News news = (News) o;

        if (!title.equals(news.title)) return false;
        if (!date.equals(news.date)) return false;
        if (!brief.equals(news.brief)) return false;
        return content != null ? content.equals(news.content) : news.content == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
