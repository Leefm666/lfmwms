package com.lfm.wms.model;

/**
 * @author lfm
 * @date 2019/12/9 - 16:33
 */
public class BindUser {
   private  Integer uid;
   private Integer sid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "BindUser{" +
                "uid=" + uid +
                ", sid=" + sid +
                '}';
    }
}
