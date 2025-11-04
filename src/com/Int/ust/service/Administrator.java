package com.Int.ust.service;
import java.util.ArrayList;
import com.Int.ust.bean.DoctorBean;

public interface Administrator {
	String addDoctor(DoctorBean doctor);
	ArrayList<DoctorBean> viewAllDoctors();
}
