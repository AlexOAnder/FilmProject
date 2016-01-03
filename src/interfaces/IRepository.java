package interfaces;

import java.util.List;

public interface IRepository<TEntity> 
{
	void Create (TEntity model);
	void Update (TEntity model);
	void Delete (TEntity model);
    public List<TEntity> GetAll() throws Exception;

}
