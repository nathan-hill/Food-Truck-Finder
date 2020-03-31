package com.software2.foodtruckfinder.secure.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Long sender;

    @NotBlank
    private Long receiver;

    @NotBlank
    @Size(max = 256)
    private String text;

    @NotBlank
    private Timestamp sentTime;

    @NotBlank
    private Boolean isRead;

    private String truckName;

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Long getReceiver() {
        return receiver;
    }

    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getSentTime() {
        return sentTime;
    }

    public void setSentTime(Timestamp sentTime) {
        this.sentTime = sentTime;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", text='" + text + '\'' +
                ", sentTime=" + sentTime +
                ", isRead=" + isRead +
                ", truckName='" + truckName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(sender, message.sender) &&
                Objects.equals(receiver, message.receiver) &&
                Objects.equals(text, message.text) &&
                Objects.equals(sentTime, message.sentTime) &&
                Objects.equals(isRead, message.isRead) &&
                Objects.equals(truckName, message.truckName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, receiver, text, sentTime, isRead, truckName);
    }

    public Boolean isInConvo(long uid1, long uid2){
        if(uid1 == sender && uid2 == receiver){
            return true;
        }
        else if(uid1 == receiver && uid2 == sender){
            return true;
        }
        else{
            return false;
        }

    }


    @Override
    public Message clone() throws CloneNotSupportedException {
        Message newClone = new Message();
        newClone.setId(this.getId());
        newClone.setRead(this.getRead());
        newClone.setReceiver(this.getReceiver());
        newClone.setSender(this.getSender());
        newClone.setSentTime(this.getSentTime());
        newClone.setText(this.getText());
        newClone.setTruckName(this.getTruckName());

        return newClone;
    }
}
