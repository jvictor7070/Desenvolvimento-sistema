package dao;

import java.util.ArrayList;
import modelo.Cliente;

public class ClienteDao {

    private ArrayList<Cliente>clientes = new ArrayList<>();

    public static void cadastrar(Cliente cliente){
        clientes.add(cliente);
    }
        
    }
    
}
