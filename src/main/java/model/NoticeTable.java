package model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "new_table")
public class NoticeTable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String date;
    private String record;

    public int getId() {
        return id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return "model.NoticeTable{" +
                "id=" + id +
                ", date=" + date + '\'' +
                ", record='" + record + '\'' +
                '}';
    }
    public NoticeTable(){}

    public NoticeTable(String date, String record){
        this.date = date;
        this.record = record;
    }
}
