/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifnmg.imobiliaria.DomainModel;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface RepositorioGenerico<T> {
    
    public boolean Salvar(T obj);
    public T Abrir(Long id);
    public boolean Remover(T obj);
    public List<T> Buscar(T obj);
    
}
