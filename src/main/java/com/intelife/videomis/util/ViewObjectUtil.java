package com.intelife.videomis.util;

import java.util.Date;

import org.springframework.beans.BeanUtils;

public class ViewObjectUtil {

    public static <V, T> V CopyModelToVO(T model, V vo) {

        BeanUtils.copyProperties(model, vo);

        return vo;
    }

    public static void main(String[] args) {

        Model m = new ViewObjectUtil().new Model();
        m.setId(10);
        m.setNo("123");
        m.setName(null);
        m.setTime(new Date());
        m.setDesc(null);

        View v = new ViewObjectUtil().new View();

        ViewObjectUtil.CopyModelToVO(m, v);

        System.out.println(v.getId());
        System.out.println(v.getNo());
        System.out.println(v.getName());
        System.out.println(v.getTime());
        System.out.println(v.getEndtime());

    }

    public class Model {
        private int id;
        private String no;
        private String name;
        private Date time;
        private String desc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

    }

    public class View {
        private int id;
        private String no;
        private String name;
        private Date time;
        private Date endtime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public Date getEndtime() {
            return endtime;
        }

        public void setEndtime(Date endtime) {
            this.endtime = endtime;
        }

    }

}
