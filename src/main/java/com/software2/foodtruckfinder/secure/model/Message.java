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
    @Size(max = 1000)
    private String text;

    @NotBlank
    private Timestamp sentTime;

    @NotBlank
    private String subject;

    @NotBlank
    private Boolean isRead;

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

    public Message(@NotBlank Long sender, @NotBlank Long receiver, @NotBlank @Size(max = 1000) String text, @NotBlank Timestamp sentTime, @NotBlank String subject, @NotBlank Boolean isRead) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.sentTime = sentTime;
        this.subject = subject;
        this.isRead = isRead;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id.equals(message.id) &&
                sender.equals(message.sender) &&
                receiver.equals(message.receiver) &&
                text.equals(message.text) &&
                sentTime.equals(message.sentTime) &&
                isRead.equals(message.isRead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, receiver, text, sentTime, isRead);
    }

//    public Boolean isInConvo(long uid1, long uid2){
//        if(uid1 == sender && uid2 == receiver){
//            return true;
//        }
//        else if(uid1 == receiver && uid2 == sender){
//            return true;
//        }
//        else{
//            return false;
//        }
//
//    }


    @Override
    public Message clone() throws CloneNotSupportedException {
        Message newClone = new Message();
        newClone.setId(this.getId());
        newClone.setRead(this.getRead());
        newClone.setReceiver(this.getReceiver());
        newClone.setSender(this.getSender());
        newClone.setSentTime(this.getSentTime());
        newClone.setText(this.getText());

        return newClone;
    }
}
