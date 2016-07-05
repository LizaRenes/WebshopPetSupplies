package orders;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class Orders_ {

	public static volatile SingularAttribute<Orders, String> firstName;
	public static volatile SingularAttribute<Orders, String> lastName;
	public static volatile SingularAttribute<Orders, String> prodAmount;
	public static volatile SingularAttribute<Orders, String> city;
	public static volatile SingularAttribute<Orders, String> postalcode;
	public static volatile SingularAttribute<Orders, String> adress;
	public static volatile SingularAttribute<Orders, Long> id;
	public static volatile SingularAttribute<Orders, String> email;

}

