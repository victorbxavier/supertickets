package DAO;


import Entity.Comprador;

import java.sql.SQLException;

public class CompradorDAO {
    public boolean save(Comprador comprador) throws SQLException {
        return false;
    }
    public boolean update(Comprador comprador) throws SQLException{
        return false;
    }
    public Comprador getById(int id) throws SQLException{
        Comprador comprador = new Comprador();
        return comprador;
    }
    public Comprador getByCpf(int cpf) throws SQLException{
        Comprador comprador = new Comprador();
        return comprador;
    }

    public boolean delete(Comprador comprador) throws SQLException{
        return false;
    }
}
