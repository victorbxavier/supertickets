package DAO;


import Entity.Organizador;

import java.sql.SQLException;

public class OrganizadorDAO {
    public boolean save(Organizador organizador) throws SQLException {
        return false;
    }
    public boolean update(Organizador organizador) throws SQLException{
        return false;
    }
    public Organizador getById(int id) throws SQLException{
        Organizador organizador = new Organizador();
        return organizador;
    }
    public Organizador getByCnpj(int Cnpj) throws SQLException{
        Organizador organizador = new Organizador();
        return organizador;
    }

    public boolean delete(Organizador organizador) throws SQLException{
        return false;
    }
}
