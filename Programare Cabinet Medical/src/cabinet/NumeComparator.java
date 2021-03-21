package cabinet;

import java.util.Comparator;

public class NumeComparator implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        return client1.getNume().compareTo(client2.getNume());
    }
}
