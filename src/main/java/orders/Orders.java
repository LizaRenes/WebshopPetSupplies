package orders;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lrenes
 */
@Entity
@XmlRootElement
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String postalcode;
    private String city;
    private String email;
    private String prodAmount;

    public Orders() {
    }
    
    public Orders(String prodAmountArgument, String firstNameArgument, String lastNameArgument, String adressArgument, String postalcodeArgument, String cityArgument, String emailArgument){
        prodAmount = prodAmountArgument;
        firstName = firstNameArgument;
        lastName = lastNameArgument;
        adress = adressArgument;
        postalcode = postalcodeArgument;
        city = cityArgument;
        email = emailArgument;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProdAmount() {
        return prodAmount;
    }

    public void setprodAmount(String prodAmount) {
        this.prodAmount = prodAmount;
    }
    
     public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orders.Orders[ id=" + id + " ]";
    }
    
}
