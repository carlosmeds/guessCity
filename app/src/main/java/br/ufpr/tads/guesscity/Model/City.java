package br.ufpr.tads.guesscity.Model;

public class City {
    private String cityName;
    private int cityImage;

    public City(String cityName, int cityImage) {
        this.cityName = cityName;
        this.cityImage = cityImage;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityImage() {
        return cityImage;
    }
}
