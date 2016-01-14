package com.example.tumpa.nevigationdrawer;

import java.io.Serializable;

/**
 * Created by tumpa on 12/23/2015.
 */
public class Doctor implements Serializable {
    String doctor_id;

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id='" + doctor_id + '\'' +
                ", category_id='" + category_id + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_degree='" + doctor_degree + '\'' +
                ", doctor_contact_no='" + doctor_contact_no + '\'' +
                ", others_info='" + others_info + '\'' +
                ", caregory='" + caregory + '\'' +
                ", category_details='" + category_details + '\'' +
                '}';
    }

    String category_id;
    String doctor_name;
    String doctor_degree;
    String doctor_contact_no;
    String others_info;
    String caregory;
    String category_details;


    public Doctor(String doctor_id, String category_id, String doctor_name, String doctor_degree, String doctor_contact_no, String others_info, String caregory, String category_details) {
        this.doctor_id = doctor_id;
        this.category_id = category_id;
        this.doctor_name = doctor_name;
        this.doctor_degree = doctor_degree;
        this.doctor_contact_no = doctor_contact_no;
        this.others_info = others_info;
        this.caregory = caregory;
        this.category_details = category_details;
    }

    public Doctor(String doctor_name, String doctor_degree, String doctor_contact_no, String others_info, String caregory) {
        this.doctor_name = doctor_name;
        this.doctor_degree = doctor_degree;
        this.doctor_contact_no = doctor_contact_no;
        this.others_info = others_info;
        this.caregory = caregory;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDoctor_degree() {
        return doctor_degree;
    }

    public void setDoctor_degree(String doctor_degree) {
        this.doctor_degree = doctor_degree;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_contact_no() {
        return doctor_contact_no;
    }

    public void setDoctor_contact_no(String doctor_contact_no) {
        this.doctor_contact_no = doctor_contact_no;
    }

    public String getOthers_info() {
        return others_info;
    }

    public void setOthers_info(String others_info) {
        this.others_info = others_info;
    }

    public String getCaregory() {
        return caregory;
    }

    public void setCaregory(String caregory) {
        this.caregory = caregory;
    }

    public String getCategory_details() {
        return category_details;
    }

    public void setCategory_details(String category_details) {
        this.category_details = category_details;
    }
}
