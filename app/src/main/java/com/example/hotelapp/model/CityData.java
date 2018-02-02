package com.example.hotelapp.model;

import java.util.List;

/**
 * Created by xiecy on 2018/01/17.
 */

public class CityData {


    /**
     * data : [{"id":"1","name":"Yogyakarta","description":"201 Hotel","background":"http://www.tnetnoc.com/hotelphotos/591/327591/2631759-The-Cangkringan-Spa-Villas-Hotel-Yogyakarta-Guest-Room-3-RTS.jpg"},{"id":"2","name":"Jakarta","description":"71 Hotel","background":"https://media-cdn.tripadvisor.com/media/photo-s/08/dc/c3/be/the-park-lane-jakarta.jpg"},{"id":"3","name":"San Fransisco","description":"309 Hotel","background":"http://hotelunionsquare.com/sites/default/files/HUS-Home-2.jpg"},{"id":"4","name":"New York","description":"101 Hotel","background":"https://a1.cdn-hotels.com/cos/production48/d1785/10fa68a0-ac68-11e4-99a1-d89d672bd508.jpg"},{"id":"5","name":"Bali","description":"30 Hotel","background":"http://balispecialevent.com/images/bali-hotel.jpg"},{"id":"6","name":"Paris","description":"189 Hotel","background":"http://www.hotel-r.net/im/hotel/bg/paris-hotel-21.jpg"}]
     * message : Get city list.
     * status : 200
     */

    private String message;
    private int status;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : Yogyakarta
         * description : 201 Hotel
         * background : http://www.tnetnoc.com/hotelphotos/591/327591/2631759-The-Cangkringan-Spa-Villas-Hotel-Yogyakarta-Guest-Room-3-RTS.jpg
         */

        private String id;
        private String name;
        private String description;
        private String background;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }
    }
}
