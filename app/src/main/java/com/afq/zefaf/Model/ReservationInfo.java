package com.afq.zefaf.Model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class ReservationInfo {

    private String venueName;
    private String venueAddress;
    private double venuePrice;
    private String reservationTime;

    public ReservationInfo() {
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("venueName", venueName);
        result.put("venueAddress", venueAddress);
        result.put("venuePrice", venuePrice);
        result.put("reservationTime", reservationTime);

        return result;
    }


}
