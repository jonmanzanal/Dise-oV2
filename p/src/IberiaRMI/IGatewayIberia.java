package IberiaRMI;

import java.util.List;

import data.Vuelo;
import iberia_remote.Flight;



public interface IGatewayIberia {
public List<Vuelo> buscarVuelos();
public boolean disminiuirasientos(int asinetos,String cod);

}
