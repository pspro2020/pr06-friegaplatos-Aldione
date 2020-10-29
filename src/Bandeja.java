import java.util.ArrayList;

public class Bandeja {

    private ArrayList<Plato> bandejaMojado = new ArrayList<Plato>();
    private ArrayList<Plato> bandejaSeco = new ArrayList<Plato>();



    public synchronized void sueltaPlatoMojado(Plato platoId) {
        bandejaMojado.add(platoId);
        notifyAll();
    }

    public synchronized Plato cogerPlatoMojado() throws InterruptedException {
        while(bandejaMojado.isEmpty()){
            wait();
        }
        return bandejaMojado.remove(0);
    }

    public synchronized void sueltaPlatoSeco(Plato platoId) {
        bandejaSeco.add(platoId);
        notifyAll();
    }

    public synchronized Plato cogerPlatoSeco() throws InterruptedException {
        while(bandejaSeco.isEmpty()){
            wait();
        }
        return bandejaSeco.remove(0);
    }


}
