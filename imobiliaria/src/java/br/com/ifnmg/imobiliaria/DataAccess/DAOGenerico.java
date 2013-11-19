/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifnmg.imobiliaria.DataAccess;



import br.com.ifnmg.imobiliaria.DomainModel.RepositorioGenerico;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
public abstract class DAOGenerico<T> implements RepositorioGenerico<T> {
    @PersistenceContext(name="ImobiliariaPU")
    protected EntityManager manager;
    
    Class tipo;
    
    public DAOGenerico(Class tipo){
        this.tipo = tipo;
    }

    @Override
        public boolean Salvar(T obj) {
        try{
            manager.merge(obj);
            manager.flush();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
        public T Abrir(Long id) {
        return (T)manager.find(tipo,manager);
    }

    @Override
        public boolean Remover(T obj) {
        try{
            manager.remove(obj);
            manager.flush();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    
}