package ru.push.backend;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class RegisteredDevice {

    @Id
    @Column(name = "pushId", unique = true)
    @NotNull
    @Length(min = 1)
    private String pushId;

    @Column(name = "faculty")
    @NotNull
    @Length(min = 1)
    private String faculty;

    @Column(name = "groupName")
    @NotNull
    @Length(min = 1)
    private String groupName;

    @Column(name = "dataTime")
    private String dataTime;

    @Column(name = "IsSent")
    private boolean IsSent = false;

    @Override
    public String toString() {
        return "faculty = " + faculty +
                " groupName = " + groupName +
                " pushId = " + pushId +
                " dataTime = " + dataTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;

        RegisteredDevice other = (RegisteredDevice) obj;
        return
                this.pushId.equals(other.getPushId()) &&
                        this.faculty.equals(other.getFaculty()) &&
                        this.groupName.equals(other.getGroupName());
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public boolean getIsSent() {
        return IsSent;
    }

    public void setIsSent(boolean isSent) {
        IsSent = isSent;
    }
}
