package com.Int.ust.service;

import java.util.ArrayList;
import com.Int.ust.bean.DoctorBean;

public class AdminServiceImpl implements Administrator {

    ArrayList<DoctorBean> doctorList = new ArrayList<>();

    @Override
    public String addDoctor(DoctorBean doctor) {
        doctorList.add(doctor);
        return "Doctor added successfully!";
    }

    @Override
    public ArrayList<DoctorBean> viewAllDoctors() {
        return doctorList;
    }
}
