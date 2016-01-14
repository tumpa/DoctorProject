package com.example.tumpa.nevigationdrawer;

/**
 * Created by tumpa on 1/11/2016.
 */
public class Chamber {
    String docId;
    String chamberId;
    String visitingFee;
    String chamberAddress;
    String appointmentOn;
    String roomNo;
    String arrivalTime;
    String leaveTime;

    @Override
    public String toString() {
        return "Chamber{" +
                "docId='" + docId + '\'' +
                ", chamberId='" + chamberId + '\'' +
                ", visitingFee='" + visitingFee + '\'' +
                ", chamberAddress='" + chamberAddress + '\'' +
                ", appointmentOn='" + appointmentOn + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                '}';
    }

    public Chamber(String docId, String chamberId, String visitingFee, String chamberAddress, String appointmentOn, String roomNo, String arrivalTime, String leaveTime) {
        this.docId = docId;
        this.chamberId = chamberId;
        this.visitingFee = visitingFee;
        this.chamberAddress = chamberAddress;
        this.appointmentOn = appointmentOn;
        this.roomNo = roomNo;
        this.arrivalTime = arrivalTime;
        this.leaveTime = leaveTime;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getChamberId() {
        return chamberId;
    }

    public void setChamberId(String chamberId) {
        this.chamberId = chamberId;
    }

    public String getVisitingFee() {
        return visitingFee;
    }

    public void setVisitingFee(String visitingFee) {
        this.visitingFee = visitingFee;
    }

    public String getAppointmentOn() {
        return appointmentOn;
    }

    public void setAppointmentOn(String appointmentOn) {
        this.appointmentOn = appointmentOn;
    }

    public String getChamberAddress() {
        return chamberAddress;
    }

    public void setChamberAddress(String chamberAddress) {
        this.chamberAddress = chamberAddress;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
}
