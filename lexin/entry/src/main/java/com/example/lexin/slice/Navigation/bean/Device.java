package com.example.lexin.slice.Navigation.bean;

public class Device {
    private String mdev_name;
    private String mdev_id;

    public Device(String device_name, String device_id) {
        this.mdev_name = device_name;
        this.mdev_id=device_id;
    }

    public String getMdev_name() {
        return mdev_name;
    }

    public void setMdev_name(String mdev_name) {
        this.mdev_name = mdev_name;
    }

    public String getMdev_id() {
        return mdev_id;
    }

    public void setMdev_id(String mdev_id) {
        this.mdev_id = mdev_id;
    }
}
