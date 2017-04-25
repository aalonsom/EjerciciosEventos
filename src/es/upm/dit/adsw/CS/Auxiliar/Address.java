package es.upm.dit.adsw.CS.Auxiliar;

/**
 * Created by aalonso on 3/4/17.
 */
public class Address {

    private String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address1 = (Address) o;

        return getAddress().equals(address1.getAddress());
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode();
    }
}
