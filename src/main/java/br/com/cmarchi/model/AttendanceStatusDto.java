package br.com.cmarchi.model;

import java.io.Serializable;

public class AttendanceStatusDto implements Serializable {

    private boolean status;

    public AttendanceStatusDto() {
    }

    public AttendanceStatusDto(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
