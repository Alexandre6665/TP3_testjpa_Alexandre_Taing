package com_isep.testjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Emp {
    @Id
    @GeneratedValue
    private Long empno;

    @Column(name = "ename")
    private String ename;

    @Column(name = "efirst")
    private String efirst;

    @Column(name = "job")
    private String job;

    @Column(name = "mgr")
    private Long mgr;

    @Column(name = "sal")
    private Long sal;

    @Column(name = "hiredate")
    private Date hiredate;

    @Column(name = "tel")
    private String tel;

    @Column(name = "mobile_tel", nullable = true)
    private String mobileTel;

    public Long getEmpno() {
        return empno;
    }
    public void setEmpno(Long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEfirst() {
        return efirst;
    }

    public void setEfirst(String efirst) {
        this.efirst = efirst;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getMgr() {
        return mgr;
    }

    public void setMgr(Long mgr) {
        this.mgr = mgr;
    }

    public Long getSal() {
        return sal;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobileTel() {
        return mobileTel;
    }

    public void setMobileTel(String mobileTel) {
        this.mobileTel = mobileTel;
    }
}

