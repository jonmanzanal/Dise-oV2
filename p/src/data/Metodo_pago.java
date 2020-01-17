package data;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.DiscriminatorStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Discriminator(strategy = DiscriminatorStrategy.CLASS_NAME, value = "Metodo_pago")
public class Metodo_pago {

}
