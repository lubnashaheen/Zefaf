package com.afq.zefaf.Model;

public class Bookmarks {

    private int venuePic;
    private String venueName;
    private String venueAddress;
    private String venueRating;
    private boolean isBookmark;

    public Bookmarks() {
    }

    public Bookmarks(int venuePic, String venueName, String venueAddress, String venueRating, boolean isBookmark) {
        this.venuePic = venuePic;
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venueRating = venueRating;
        this.isBookmark = isBookmark;
    }

    public int getVenuePic() {
        return venuePic;
    }

    public void setVenuePic(int venuePic) {
        this.venuePic = venuePic;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueRating() {
        return venueRating;
    }

    public void setVenueRating(String venueRating) {
        this.venueRating = venueRating;
    }

    public boolean isBookmark() {
        return isBookmark;
    }

    public void setFave(boolean fave) {
        isBookmark = fave;
    }
}
