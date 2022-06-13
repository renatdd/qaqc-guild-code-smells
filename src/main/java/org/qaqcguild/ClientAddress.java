package org.qaqcguild;

public class ClientAddress {

    private String street;
    private String number;
    private String district;
    private String city;

    private void setStreet(String street) {
        this.street = street;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setDistrict(String district) {
        this.district = district;
    }

    private void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static ClientAddressBuilder builder() {
        return new ClientAddressBuilder();
    }

    public static class ClientAddressBuilder {
        private String street;
        private String number;
        private String district;
        private String city;

        public ClientAddressBuilder street(String streetInput) {
            street = streetInput;
            return this;
        }

        public ClientAddressBuilder number(String numberInput) {
            number = numberInput;
            return this;
        }

        public ClientAddressBuilder district(String districtInput) {
            district = districtInput;
            return this;
        }

        public ClientAddressBuilder city(String cityInput) {
            city = cityInput;
            return this;
        }

        public ClientAddress build() {
            ClientAddress clientAddress = new ClientAddress();
            clientAddress.setStreet(street);
            clientAddress.setNumber(number);
            clientAddress.setDistrict(district);
            clientAddress.setCity(city);
            return clientAddress;
        }
    }
}
