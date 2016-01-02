package interfaces;

import java.util.List;

public interface IRepository<TEntity> 
{
    public TEntity Get(int id);
    
    public List<TEntity> GetAll();
    
    public boolean Insert(TEntity newEntity);
    
    public void Delete(int id);
}
